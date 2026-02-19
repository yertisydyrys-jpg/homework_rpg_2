package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.prototype.EnemyRegistry;

public class Main {

    public static void main(String[] args) {

        // -------------------------------
        // Part 1 — Abstract Factory
        // -------------------------------
        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("=== Part 1: Abstract Factory ===");
        displayFactoryOutput("FIRE", fireFactory);
        displayFactoryOutput("ICE", iceFactory);
        displayFactoryOutput("SHADOW", shadowFactory);

        // -------------------------------
        // Part 2 — Builder (+ Factory Method inside build())
        // -------------------------------
        System.out.println("\n=== Part 2: Builder (+ Factory Method) ===");

        // FACTORY METHOD: build() produces Enemy; concrete builder chooses concrete product.
        Enemy dragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(50_000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .addPhase(1, 50_000)
                .addPhase(2, 30_000)
                .addPhase(3, 15_000)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(20)
                .build();

        dragon.displayInfo();

        EnemyDirector basicDirector = new EnemyDirector(new BasicEnemyBuilder());
        Enemy minion = basicDirector.createMinion(iceFactory);
        minion.displayInfo();

        // -------------------------------
        // Part 3 — Prototype (Registry + deep copy)
        // -------------------------------
        System.out.println("\n=== Part 3: Prototype (Deep Copy) ===");
        EnemyRegistry registry = new EnemyRegistry();

        Goblin goblinTemplate = new Goblin("Goblin");
        registry.registerTemplate("goblin", goblinTemplate);
        registry.registerTemplate("fire-dragon", dragon);

        Enemy goblinClone = registry.createFromTemplate("goblin");

        // Модифицируем КЛОН (допустим каст — это демо Prototype)
        Goblin elite = (Goblin) goblinClone;
        elite.multiplyStats(2.0);
        elite.setLootTable(fireFactory.createLootTable());
        // добавим способность (любую из фабрики)
        Ability extra = fireFactory.createAbilities().get(0).clone();
        elite.addAbility(extra);

        System.out.println("\n--- TEMPLATE (original) ---");
        goblinTemplate.displayInfo();

        System.out.println("\n--- CLONE (modified) ---");
        elite.displayInfo();

        // -------------------------------
        // Part 4 — Together (full pipeline)
        // -------------------------------
        System.out.println("\n=== Part 4: Full pipeline ===");

        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord")
                .setHealth(80_000)
                .setDamage(900)
                .setDefense(350)
                .setSpeed(45)
                .setElement("SHADOW")
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .setAI(shadowFactory.createAIBehavior())
                .addPhase(1, 80_000)
                .addPhase(2, 40_000)
                .addPhase(3, 20_000)
                .build();

        registry.registerTemplate("demon-lord", demonLord);

        Enemy demonClone = registry.createFromTemplate("demon-lord");
        System.out.println("\n--- Demon Lord TEMPLATE ---");
        demonLord.displayInfo();
        System.out.println("\n--- Demon Lord CLONE ---");
        demonClone.displayInfo();
    }

    private static void displayFactoryOutput(String title, EnemyComponentFactory factory) {
        System.out.println("\n[" + title + "]");
        System.out.println("AI: " + factory.createAIBehavior());
        System.out.println("Abilities: " + factory.createAbilities().stream().map(Ability::getName).toList());
        System.out.println("Loot: " + factory.createLootTable().getItems());
    }
}
