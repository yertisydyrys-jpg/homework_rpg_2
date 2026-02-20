package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

public class DragonBoss implements Enemy {

    private final String name;
    private final int health;
    private final int damage;
    private final int defense;
    private final int speed;

    private final String element;
    private final List<Ability> abilities;
    private final Map<Integer, Integer> phases; // phase -> hp threshold
    private final LootTable lootTable;
    private final String aiBehavior;

    private final boolean canFly;
    private final boolean hasBreathAttack;
    private final int wingspan;

    /** Конструктор НЕ public: создаётся только Builder'ом. */
    public DragonBoss(String name, int health, int damage, int defense, int speed,
               String element, List<Ability> abilities, Map<Integer, Integer> phases,
               LootTable lootTable, String aiBehavior,
               boolean canFly, boolean hasBreathAttack, int wingspan) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;

        this.element = element;
        this.abilities = (abilities == null) ? List.of() : List.copyOf(abilities);
        this.phases = (phases == null) ? Map.of() : Map.copyOf(phases);

        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;

        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }

    @Override public List<Ability> getAbilities() { return abilities; }
    @Override public LootTable getLootTable() { return lootTable; }


    public String getElement() { return element; }
    public Map<Integer, Integer> getPhases() { return phases; }
    public String getAiBehavior() { return aiBehavior; }
    public boolean isCanFly() { return canFly; }
    public boolean isHasBreathAttack() { return hasBreathAttack; }
    public int getWingspan() { return wingspan; }

    @Override
    public void displayInfo() {
        System.out.println("== " + name + " (DragonBoss) ==");
        System.out.println("HP=" + health + ", DMG=" + damage + ", DEF=" + defense + ", SPD=" + speed);
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);
        System.out.println("CanFly=" + canFly + ", Breath=" + hasBreathAttack + ", Wingspan=" + wingspan);
        System.out.println("Abilities: " + (abilities.isEmpty() ? "none" : abilities.stream().map(Ability::getName).toList()));
        System.out.println("Phases: " + (phases.isEmpty() ? "none" : phases));
        System.out.println("Loot: " + (lootTable == null ? "none" : lootTable.getItems()));
    }


    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) clonedAbilities.add(a == null ? null : a.clone());

        Map<Integer, Integer> clonedPhases = new LinkedHashMap<>();
        clonedPhases.putAll(this.phases);

        LootTable clonedLoot = (lootTable == null) ? null : lootTable.clone();

        return new DragonBoss(
                this.name, this.health, this.damage, this.defense, this.speed,
                this.element,
                clonedAbilities,
                clonedPhases,
                clonedLoot,
                this.aiBehavior,
                this.canFly,
                this.hasBreathAttack,
                this.wingspan
        );
    }
}
