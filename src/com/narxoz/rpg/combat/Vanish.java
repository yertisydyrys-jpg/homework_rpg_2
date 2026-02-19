package com.narxoz.rpg.combat;

public class Vanish extends AbstractAbility {
    public Vanish() {
        super("Vanish", "Disappears to avoid attacks.", Type.UTILITY, 0);
    }

    @Override
    public Ability clone() {
        return new Vanish();
    }
}
