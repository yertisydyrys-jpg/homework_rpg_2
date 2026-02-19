package com.narxoz.rpg.combat;

/**
 * Enemy ability contract.
 * Must support deep copy for Prototype.
 */
public interface Ability {

    enum Type {
        DAMAGE, DEFENSE, ULTIMATE, UTILITY
    }

    String getName();
    String getDescription();
    Type getType();

    /** For damage abilities (0 for shields/utility). */
    int getPower();

    /** Prototype deep copy. */
    Ability clone();
}
