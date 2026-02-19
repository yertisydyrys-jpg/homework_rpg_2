package com.narxoz.rpg.combat;

public class MeteorStorm extends AbstractAbility {
    public MeteorStorm() {
        super("Meteor Storm", "Calls meteors from the sky.", Type.ULTIMATE, 500);
    }

    @Override
    public Ability clone() {
        return new MeteorStorm();
    }
}
