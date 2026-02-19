package com.narxoz.rpg.combat;

public class FrostBreath extends AbstractAbility {
    public FrostBreath() {
        super("Frost Breath", "Breathes frost to freeze enemies.", Type.DAMAGE, 100);
    }

    @Override
    public Ability clone() {
        return new FrostBreath();
    }
}
