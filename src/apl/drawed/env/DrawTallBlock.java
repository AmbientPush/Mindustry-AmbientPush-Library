package apl.drawed.env;

import arc.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.draw.*;

public class DrawTallBlock extends TallBlock{
    public @Nullable DrawBlock drawer;
    public DrawTallBlock(String name){
        super(name);
    }

    @Override
    public void drawBase(Tile tile){
        Draw.z(layer);
        drawer.draw(this);
    }
}