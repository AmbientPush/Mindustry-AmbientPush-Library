package apl;

import apl.blocks.*;
//import apl.other.*;
import arc.util.*;
import mindustry.mod.*;

public class AutomatonDynamicsMod extends Mod {
    public AutomatonDynamicsMod() {
        ClassMap.classes.put("APLLimitedBattery", apl.blocks.LimitedBattery.class);
        ClassMap.classes.put("APLHeatConductorDamage", apl.blocks.HeatConductorDamage.class);
//        ClassMap.classes.put("APLFactoryPlan", apl.other.FactoryPlan.class);
//        ClassMap.classes.put("APLPlanDrawer", apl.other.PlanDrawer.class);
//        ClassMap.classes.put("APLHeadacheCrafter", apl.blocks.HeadacheCrafter.class);
        ClassMap.classes.put("APLVeryStaticWall", apl.blocks.VeryStaticWall.class);
        ClassMap.classes.put("APLLargeFloor", apl.blocks.LargeFloor.class);
        ClassMap.classes.put("APLDrawTallBlock", apl.drawed.env.DrawTallBlock.class);

    }

}
