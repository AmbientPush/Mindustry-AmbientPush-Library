import arc.util.Time;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.world.blocks.heat.HeatConductor;
import mindustry.world.meta.BlockGroup;

public class HeatConductorDamage extends HeatConductor {
    public float heatStartDamage = 80f; // Heat threshold for damage
    public float heatDamage = 1f; // Damage per tick per unit of overheat
    public Effect heatDamageEffect = new Effect(20f, e -> {
        Fx.smoke.at(e.x, e.y);
    }); // Effect when taking heat damage

    public HeatConductorDamage(String name) {
        super(name);
        // Configure block properties
        solid = true;
        update = true;
        destructible = true;
        group = BlockGroup.crafting;
    }

    public class HeatConductorDamageBuild extends HeatConductorBuild {
        @Override
        public void updateTile() {
            super.updateTile(); // Handle default heat conduction

            // Check for overheat and apply damage
            if (heat > heatStartDamage) {
                float overheat = heat - heatStartDamage;
                float damage = overheat * heatDamage * Time.delta;
                damage(damage);

                // Trigger damage effect at block's position
                if (damage > 0) {
                    heatDamageEffect.at(x, y);
                }
            }
        }
    }
}