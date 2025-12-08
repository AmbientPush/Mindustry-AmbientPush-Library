package apl;

import apl.blocks.*;
import arc.util.*;
import mindustry.mod.*;

public class AutomatonDynamicsMod extends Mod {
    public AutomatonDynamicsMod() {
        ClassMap.classes.put("APLLimitedBattery", adl.blocks.LimitedBattery.class);
        ClassMap.classes.put("APLHeatConductorDamage", adl.blocks.HeatConductorDamage.class);
//        ClassMap.classes.put("APLHeadacheCrafter", adl.blocks.HeadacheCrafter.class);
//        ClassMap.classes.put("APLFactoryPlan", adl.other.FactoryPlan.class);
//        ClassMap.classes.put("APLPlanDrawer", adl.other.PlanDrawer.class);
        ClassMap.classes.put("APLVeryStaticWall", adl.blocks.VeryStaticWall.class);

    }

}
