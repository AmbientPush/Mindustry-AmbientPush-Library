package abl;

import abl.blocks.*;
import arc.util.*;
import mindustry.mod.*;

public class AutomatonDynamicsMod extends Mod {
    public AutomatonDynamicsMod() {
        ClassMap.classes.put("ADLLimitedBattery", adl.blocks.LimitedBattery.class);
        ClassMap.classes.put("ADLHeatConductorDamage", adl.blocks.HeatConductorDamage.class);

        Log.info("AutomatonDynamicsMod initialized");
    }

}
