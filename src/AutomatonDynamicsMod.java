package automaton_dynamics;

import mindustry.mod.Mod;
import mindustry.mod.ClassMap;

public class AutomatonDynamicsMod extends Mod {
    public AutomatonDynamicsMod() {
        super();
    }

    @Override
    public void loadContent() {
        ClassMap.classes.put("ADLimitedBattery", blocks.LimitedBattery.java);
        ClassMap.classes.put("ADHeatConductorDamage", blocks.HeatConductorDamage.java);
    }
}
