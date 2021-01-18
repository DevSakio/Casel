package me.sakio.casel;

import lombok.Getter;
import me.sakio.casel.manager.PlayerData;
import org.bukkit.plugin.java.JavaPlugin;

public class Casel extends JavaPlugin {
    @Getter
    private static Casel instance;
    @Getter
    private PlayerData playerData;

    @Override
    public void onEnable() {
        instance = this;
        this.playerData = new PlayerData();
    }

    @Override
    public void onDisable() {
    }
}
