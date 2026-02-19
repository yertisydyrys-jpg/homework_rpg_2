package com.narxoz.rpg.prototype;

import com.narxoz.rpg.enemy.Enemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EnemyRegistry {

    private final Map<String, Enemy> templates = new HashMap<>();

    public void registerTemplate(String key, Enemy template) {
        templates.put(key, template);
    }

    public Enemy createFromTemplate(String key) {
        Enemy template = templates.get(key);
        if (template == null) throw new IllegalArgumentException("Unknown template: " + key);
        return template.clone();
    }

    public Set<String> listTemplates() {
        return templates.keySet();
    }
}
