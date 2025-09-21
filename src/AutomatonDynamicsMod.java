package automaton_dynamics;

import mindustry.mod.Mod;
import mindustry.mod.ClassMap;

public class AutomatonDynamicsMod extends Mod {
    public AutomatonDynamicsMod() {
        super();
    }

    @Override
    public void loadContent() {
        Logs.info("ass");
        ClassMap.classes.put("ADLimitedBattery", LimitedBattery.java);
        ClassMap.classes.put("ADHeatConductorDamage", HeatConductorDamage.java);
    }
}