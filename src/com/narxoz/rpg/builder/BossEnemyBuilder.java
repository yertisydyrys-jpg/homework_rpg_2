package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

public class BossEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;

    private final List<Ability> abilities = new ArrayList<>();
    private final Map<Integer, Integer> phases = new LinkedHashMap<>();

    private LootTable lootTable;
    private String aiBehavior;

    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    @Override public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }

    @Override public EnemyBuilder setElement(String element) { this.element = element; return this; }

    @Override public EnemyBuilder addAbility(Ability ability) { if (ability != null) abilities.add(ability); return this; }
    @Override public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities.clear();
        if (abilities != null) this.abilities.addAll(abilities);
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        phases.put(phaseNumber, healthThreshold);
        return this;
    }

    @Override public EnemyBuilder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }
    @Override public EnemyBuilder setAI(String aiBehavior) { this.aiBehavior = aiBehavior; return this; }

    @Override public EnemyBuilder setCanFly(boolean canFly) { this.canFly = canFly; return this; }
    @Override public EnemyBuilder setHasBreathAttack(boolean hasBreathAttack) { this.hasBreathAttack = hasBreathAttack; return this; }
    @Override public EnemyBuilder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }

    @Override
    public Enemy build() {
        // FACTORY METHOD: build() creates concrete Enemy (DragonBoss here).
        if (name == null || name.isBlank()) throw new IllegalStateException("Name is required");
        if (health <= 0) throw new IllegalStateException("Health must be positive");

        // defensive copies to keep boss immutable after build
        List<Ability> abilitiesCopy = new ArrayList<>(abilities);
        Map<Integer, Integer> phasesCopy = new LinkedHashMap<>(phases);

        return new DragonBoss(
                name, health, damage, defense, speed,
                element,
                abilitiesCopy,
                phasesCopy,
                lootTable,
                aiBehavior,
                canFly,
                hasBreathAttack,
                wingspan
        );
    }
}
