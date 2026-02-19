package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractLootTable implements LootTable {

    private final List<String> items;
    private final int goldDrop;
    private final int experienceDrop;

    protected AbstractLootTable(List<String> items, int goldDrop, int experienceDrop) {
        this.items = new ArrayList<>(items);
        this.goldDrop = goldDrop;
        this.experienceDrop = experienceDrop;
    }

    @Override
    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    @Override public int getGoldDrop() { return goldDrop; }
    @Override public int getExperienceDrop() { return experienceDrop; }

    /** Удобно для наследников, когда делаем clone() */
    protected List<String> copyItems() {
        return new ArrayList<>(items);
    }

    @Override
    public String toString() {
        return getLootInfo();
    }
}
