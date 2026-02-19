package com.narxoz.rpg.loot;

import java.util.List;

public interface LootTable {

    List<String> getItems();
    int getGoldDrop();
    int getExperienceDrop();

    default String getLootInfo() {
        return "Items=" + getItems() + ", gold=" + getGoldDrop() + ", exp=" + getExperienceDrop();
    }

    /** Prototype deep copy. */
    LootTable clone();
}
