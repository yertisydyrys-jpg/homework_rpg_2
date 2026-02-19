package com.narxoz.rpg.combat;

public class FlameBreath extends AbstractAbility {
    public FlameBreath() {
        super("Flame Breath", "Breathes fire to burn enemies.", Type.DAMAGE, 120);
    }

    @Override
    public Ability clone() {
        return new FlameBreath();
    }
}
