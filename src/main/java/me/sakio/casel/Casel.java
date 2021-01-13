package me.sakio.casel;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Casel extends JavaPlugin {
    @Getter
    private static Casel instance;

    @Override
    public void onEnable() {
        instance = this;

    }

    @Override
    public void onDisable() {
    }
}
