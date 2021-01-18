package me.sakio.casel;

import lombok.Getter;
import me.sakio.casel.manager.PlayerData;
import me.sakio.casel.manager.provide.ChatColor;
import me.sakio.casel.manager.provide.Tags;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.logging.Logger;

@Getter
public class Casel extends JavaPlugin {
    @Getter
    private static Casel instance;
    private PlayerData playerData;
    private static Chat chat = null;
    Logger logger = Logger.getLogger("Casel");

    @Override
    public void onEnable() {
        instance = this;
        this.playerData = new PlayerData();
        setupChat();
        logger.info("Casel Start:");
        logger.info("TAGS:");
        logger.info(Arrays.toString(Tags.values()));
        logger.info("COLOR:");
        logger.info(Arrays.toString(ChatColor.values()));
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
