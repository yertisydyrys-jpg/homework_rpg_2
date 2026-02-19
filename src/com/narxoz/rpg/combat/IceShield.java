package com.narxoz.rpg.combat;

public class IceShield extends AbstractAbility {
    public IceShield() {
        super("Ice Shield", "Forms an ice barrier to reduce damage.", Type.DEFENSE, 0);
    }

    @Override
    public Ability clone() {
        return new IceShield();
    }
}
