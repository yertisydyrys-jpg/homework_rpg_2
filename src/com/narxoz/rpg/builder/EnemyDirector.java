package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

import java.util.List;

public class EnemyDirector {

    private final EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion(EnemyComponentFactory factory) {
        return builder
                .setName("Minion")
                .setHealth(50)
                .setDamage(10)
                .setDefense(5)
                .setSpeed(20)
                .setAbilities(factory != null ? factory.createAbilities() : List.of())
                .setLootTable(factory != null ? factory.createLootTable() : null)
                .build(); // Factory Method call polymorphically
    }

    public Enemy createElite(EnemyComponentFactory factory) {
        return builder
                .setName("Elite")
                .setHealth(250)
                .setDamage(40)
                .setDefense(20)
                .setSpeed(30)
                .setAbilities(factory != null ? factory.createAbilities() : List.of())
                .setLootTable(factory != null ? factory.createLootTable() : null)
                .setAI(factory != null ? factory.createAIBehavior() : null)
                .build();
    }

    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Mini Boss")
                .setHealth(5000)
                .setDamage(150)
                .setDefense(80)
                .setSpeed(35)
                .setAbilities(factory != null ? factory.createAbilities() : List.of())
                .setLootTable(factory != null ? factory.createLootTable() : null)
                .setAI(factory != null ? factory.createAIBehavior() : null)
                .addPhase(1, 5000)
                .addPhase(2, 2500)
                .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Raid Boss")
                .setHealth(100_000)
                .setDamage(1000)
                .setDefense(300)
                .setSpeed(40)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .addPhase(1, 100_000)
                .addPhase(2, 50_000)
                .addPhase(3, 25_000)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(25)
                .build();
    }
}
