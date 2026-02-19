package com.narxoz.rpg.loot;

import java.util.List;

public class FireLootTable extends AbstractLootTable {

    public FireLootTable() {
        super(List.of("Fire Gem", "Dragon Scale", "Flame Rune"), 250, 400);
    }

    @Override
    public LootTable clone() {
        // deep copy (новый объект, новый список внутри AbstractLootTable)
        return new FireLootTable();
    }
}
