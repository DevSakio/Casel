package me.sakio.casel;

import lombok.Getter;
import me.sakio.casel.manager.PlayerData;
import me.sakio.casel.manager.provide.Tags;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
@Getter
public class Casel extends JavaPlugin {
    @Getter
    private static Casel instance;
    private PlayerData playerData;
    private static Chat chat = null;

    @Override
    public void onEnable() {
        instance = this;
        this.playerData = new PlayerData();
        setupChat();
        Bukkit.getServer().getConsoleSender().sendMessage("Casel start with" + Arrays.toString(Tags.values()));
    }

    @Override
    public void onDisable() { }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
    public static Chat getChat() {
        return chat;
    }
}
