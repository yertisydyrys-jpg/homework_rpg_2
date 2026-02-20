package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Goblin implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private final List<Ability> abilities;
    private LootTable lootTable;

    /** Простой конструктор по ТЗ: дефолтные статы. */
    public Goblin(String name) {
        this(name, 100, 15, 5, 30, new ArrayList<>(), null);
    }

    /** Полный конструктор (package-private) — удобно для Builder/clone. */
    public Goblin(String name, int health, int damage, int defense, int speed,
           List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = (abilities == null) ? new ArrayList<>() : new ArrayList<>(abilities);
        this.lootTable = lootTable;
    }

    // --- getters ---
    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }

    @Override
    public List<Ability> getAbilities() {
        return Collections.unmodifiableList(abilities);
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public void displayInfo() {
        System.out.println("== " + name + " (Goblin) ==");
        System.out.println("HP=" + health + ", DMG=" + damage + ", DEF=" + defense + ", SPD=" + speed);
        System.out.println("Abilities: " + (abilities.isEmpty() ? "none" : abilities.stream().map(Ability::getName).toList()));
        System.out.println("Loot: " + (lootTable == null ? "none" : lootTable.getItems()));
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            clonedAbilities.add(a == null ? null : a.clone());
        }
        LootTable clonedLoot = (lootTable == null) ? null : lootTable.clone();

        return new Goblin(
                this.name,
                this.health,
                this.damage,
                this.defense,
                this.speed,
                clonedAbilities,
                clonedLoot
        );
    }

    // --- Methods for variants (modify clone safely) ---
    public void multiplyStats(double factor) {
        if (factor <= 0) throw new IllegalArgumentException("factor must be > 0");
        this.health = (int) Math.round(this.health * factor);
        this.damage = (int) Math.round(this.damage * factor);
        this.defense = (int) Math.round(this.defense * factor);
        this.speed = (int) Math.round(this.speed * factor);
    }

    public void addAbility(Ability a) {
        if (a != null) this.abilities.add(a);
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }
}
