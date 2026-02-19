package com.narxoz.rpg.loot;

import java.util.List;

public class ShadowLootTable extends AbstractLootTable {

    public ShadowLootTable() {
        super(List.of("Shadow Gem", "Dark Essence", "Shadow Rune"), 300, 450);
    }

    @Override
    public LootTable clone() {
        return new ShadowLootTable();
    }
}
