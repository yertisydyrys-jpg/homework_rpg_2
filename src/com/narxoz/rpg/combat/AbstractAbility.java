package com.narxoz.rpg.combat;

public abstract class AbstractAbility implements Ability {

    private final String name;
    private final String description;
    private final Type type;
    private final int power;

    protected AbstractAbility(String name, String description, Type type, int power) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.power = power;
    }

    @Override public String getName() { return name; }
    @Override public String getDescription() { return description; }
    @Override public Type getType() { return type; }
    @Override public int getPower() { return power; }

    @Override
    public String toString() {
        return name + " [" + type + ", power=" + power + "]";
    }
}
