package me.sakio.casel;

import lombok.Getter;
import me.sakio.casel.command.ReloadCommand;
import me.sakio.casel.listener.ChatListener;
import me.sakio.casel.listener.PlayerListener;
import me.sakio.casel.manager.PlayerData;
import me.sakio.casel.manager.provide.ChatColor;
import me.sakio.casel.manager.provide.Tags;
import me.sakio.casel.utils.commands.CommandFramework;
import me.sakio.casel.utils.menu.MenuListener;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
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

    @Override
    public void onEnable() {
        instance = this;
        this.playerData = new PlayerData();
        setupChat();
        Bukkit.getServer().getConsoleSender().sendMessage("Ready");
        this.registerCommands();
        this.registerListeners();
    }

    @Override
    public void onDisable() { }

    //Event and Command
    public void registerCommands() {
        this.registerCommands(
                new ReloadCommand()
        );
        this.registerListeners(
                new PlayerListener(),
                new ChatListener(),
                new MenuListener()

        );
    }

    private void registerCommands(Object... command) {
        CommandFramework commandFramework = new CommandFramework(this);
        Arrays.stream(command).forEach(commandFramework::registerCommands);

    }

    private void registerListeners(Listener... listeners) {
        Arrays.stream(listeners).forEach(l -> Bukkit.getServer().getPluginManager().registerEvents(l, this));
    }
    //Event and Command

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
    public static Chat getChat() {
        return chat;
    }
}
