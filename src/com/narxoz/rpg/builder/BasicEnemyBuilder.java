package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private final List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    @Override public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }

    @Override public EnemyBuilder setElement(String element) { return this; } // ignore for basic
    @Override public EnemyBuilder addAbility(Ability ability) { if (ability != null) abilities.add(ability); return this; }
    @Override public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities.clear();
        if (abilities != null) this.abilities.addAll(abilities);
        return this;
    }

    @Override public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) { return this; } // ignore for basic
    @Override public EnemyBuilder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }
    @Override public EnemyBuilder setAI(String aiBehavior) { return this; } // ignore for basic

    @Override public EnemyBuilder setCanFly(boolean canFly) { return this; }
    @Override public EnemyBuilder setHasBreathAttack(boolean hasBreathAttack) { return this; }
    @Override public EnemyBuilder setWingspan(int wingspan) { return this; }

    @Override
    public Enemy build() {
        // FACTORY METHOD: build() creates concrete Enemy (Goblin here).
        if (name == null || name.isBlank()) throw new IllegalStateException("Name is required");
        if (health <= 0) throw new IllegalStateException("Health must be positive");

        return new Goblin(name, health, damage, defense, speed, abilities, lootTable);
    }
}
