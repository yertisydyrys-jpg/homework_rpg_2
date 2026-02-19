package com.narxoz.rpg.loot;

import java.util.List;

public class IceLootTable extends AbstractLootTable {

    public IceLootTable() {
        super(List.of("Ice Gem", "Frost Scale", "Ice Rune"), 220, 380);
    }

    @Override
    public LootTable clone() {
        return new IceLootTable();
    }
}
