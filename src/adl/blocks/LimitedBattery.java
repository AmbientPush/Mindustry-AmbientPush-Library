package adl.blocks;

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
        // Ensure power module is initialized
        hasPower = true;
        consumesPower = true;
        outputsPower = true;
    }

    public class LimitedBatteryBuild extends BatteryBuild {
        @Override
        public void updateTile() {
            // Call vanilla update to ensure power graph is initialized
            super.updateTile();
        }

        @Override
        public float getPowerProduction() {
            // Cap power output per tick
            if (power.status <= 0f || power.graph.getPowerNeeded() <= power.graph.getPowerProduced()) {
                return 0f;
            }
            float capacity = consPower.capacity;
            float maxOutputThisTick = maxPowerOutput * Time.delta;
            float availablePower = power.status * capacity;
            return Math.min(maxOutputThisTick, availablePower) / Time.delta;
        }

        @Override
        public float getPowerConsumption() {
            // Cap power input per tick
            if (power.status >= 1f || power.graph.getPowerProduced() <= power.graph.getPowerNeeded()) {
                return 0f;
            }
            float capacity = consPower.capacity;
            float maxInputThisTick = maxPowerInput * Time.delta;
            float neededPower = (1f - power.status) * capacity;
            return Math.min(maxInputThisTick, neededPower) / Time.delta;
        }
    }
}