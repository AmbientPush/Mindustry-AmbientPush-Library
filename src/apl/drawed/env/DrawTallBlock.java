package apl.drawed.env;

import arc.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.TallBlock;
import mindustry.world.draw.*;

public class DrawTallBlock extends TallBlock{
    public DrawBlock drawer = new DrawDefault();

    public DrawTallBlock(String name){
        super(name);
    }
}