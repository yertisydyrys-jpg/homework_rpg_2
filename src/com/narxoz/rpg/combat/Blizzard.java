package com.narxoz.rpg.combat;

public class Blizzard extends AbstractAbility {
    public Blizzard() {
        super("Blizzard", "Summons a freezing storm.", Type.ULTIMATE, 450);
    }

    @Override
    public Ability clone() {
        return new Blizzard();
    }
}
