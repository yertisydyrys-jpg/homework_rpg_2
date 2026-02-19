package com.narxoz.rpg.combat;

public class FireShield extends AbstractAbility {
    public FireShield() {
        super("Fire Shield", "Creates a protective shield of fire.", Type.DEFENSE, 0);
    }

    @Override
    public Ability clone() {
        return new FireShield();
    }
}
