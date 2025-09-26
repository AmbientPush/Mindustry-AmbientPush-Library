package adl.blocks;

import arc.util.Time;
import mindustry.world.blocks.power.Battery;
import mindustry.world.meta.BlockGroup;

public class LimitedBattery extends Battery {
    public float maxPowerInput = 10f; // Maximum power input per tick
    public float maxPowerOutput = 10f; // Maximum power output per tick

    public LimitedBattery(String name) {
        super(name);
        solid = true;
        update = true;
        destructible = true;
        group = BlockGroup.power;
        hasPower = true;
        consumesPower = true;
        outputsPower = true;
    }

    public class LimitedBatteryBuild extends BatteryBuild {
        @Override
        public void updateTile() {
            super.updateTile(); // Ensures power graph initialization
        }

        @Override
        public float getPowerProduction() {
            if (power.status <= 0f || power.graph.getPowerNeeded() <= power.graph.getPowerProduced()) {
                return 0f;
            }
            float capacity = consPower.capacity;
            float available = power.status * capacity;
            return Math.min(maxPowerOutput, available / Time.delta);
        }

//        @Override //the error is here
        public float getPowerConsumption() {
            if (power.status >= 1f || power.graph.getPowerProduced() <= power.graph.getPowerNeeded()) {
                return 0f;
            }
            float capacity = consPower.capacity;
            float needed = (1f - power.status) * capacity;
            return Math.min(maxPowerInput, needed / Time.delta);
        }
    }
}