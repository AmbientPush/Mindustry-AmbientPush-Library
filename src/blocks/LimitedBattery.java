import arc.util.Time;
import mindustry.world.blocks.power.Battery;
import mindustry.world.meta.BlockGroup;

public class LimitedBattery extends Battery {
    public float maxPowerInput = 10f; // Maximum power input per tick
    public float maxPowerOutput = 10f; // Maximum power output per tick

    public LimitedBattery(String name) {
        super(name);
        // Configure block properties
        solid = true;
        update = true;
        destructible = true;
        group = BlockGroup.power;
    }

    public class LimitedBatteryBuild extends BatteryBuild {
        @Override
        public void updateTile() {
            // Handle power input (charging)
            if (power.status < 1f && power.graph.getPowerProduced() > power.graph.getPowerNeeded()) {
                float availablePower = power.graph.getPowerBalance() * Time.delta; // Power available this tick
                float powerToAdd = Math.min(availablePower, maxPowerInput * Time.delta); // Cap input
                float capacity = consPower.capacity;
                powerToAdd = Math.min(powerToAdd, (1f - power.status) * capacity); // Don't exceed capacity
                power.status += powerToAdd / capacity;
            }

            // Handle power output (discharging)
            if (power.status > 0f && power.graph.getPowerNeeded() > power.graph.getPowerProduced()) {
                float powerDemand = (power.graph.getPowerNeeded() - power.graph.getPowerProduced()) * Time.delta; // Power needed this tick
                float powerToRemove = Math.min(powerDemand, maxPowerOutput * Time.delta); // Cap output
                float capacity = consPower.capacity;
                powerToRemove = Math.min(powerToRemove, power.status * capacity); // Don't over-discharge
                power.status -= powerToRemove / capacity;
            }

            // Update power graph (vanilla behavior)
            power.graph.update();
        }
    }
}