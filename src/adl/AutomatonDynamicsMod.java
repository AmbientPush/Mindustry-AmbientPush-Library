package adl;

import adl.blocks.*;
import arc.util.*;
import mindustry.mod.*;

public class AutomatonDynamicsMod extends Mod {
    public AutomatonDynamicsMod() {
        ClassMap.classes.put("ADLLimitedBattery", adl.blocks.LimitedBattery.class);
        ClassMap.classes.put("ADLHeatConductorDamage", adl.blocks.HeatConductorDamage.class);
        ClassMap.classes.put("ADLHeadacheCrafter", adl.blocks.HeadacheCrafter.class);
        ClassMap.classes.put("ADLFactoryPlan", adl.other.FactoryPlan.class);
        ClassMap.classes.put("ADLPlanDrawer", adl.other.PlanDrawer.class);

        Log.info("AutomatonDynamicsMod initialized");
    }

}
