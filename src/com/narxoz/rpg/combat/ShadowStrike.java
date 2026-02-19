package com.narxoz.rpg.combat;

public class ShadowStrike extends AbstractAbility {
    public ShadowStrike() {
        super("Shadow Strike", "Strikes from the shadows.", Type.DAMAGE, 110);
    }

    @Override
    public Ability clone() {
        return new ShadowStrike();
    }
}
