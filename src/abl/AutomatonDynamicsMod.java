package abl;

import abl.blocks.*;
import arc.util.*;
import mindustry.mod.*;

public class AutomatonDynamicsMod extends Mod {
    public AutomatonDynamicsMod() {
        ClassMap.classes.put("ADLLimitedBattery", abl.blocks.LimitedBattery.class);
        ClassMap.classes.put("ADLHeatConductorDamage", abl.blocks.HeatConductorDamage.class);

        Log.info("AutomatonDynamicsMod initialized");
    }

}
