package com.narxoz.rpg.combat;

public class DarkNova extends AbstractAbility {
    public DarkNova() {
        super("Dark Nova", "Unleashes a burst of dark energy.", Type.ULTIMATE, 480);
    }

    @Override
    public Ability clone() {
        return new DarkNova();
    }
}
