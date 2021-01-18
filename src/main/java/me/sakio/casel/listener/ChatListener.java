package me.sakio.casel.listener;

import me.sakio.casel.Casel;
import me.sakio.casel.utils.Color;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by DevSakio
 * Project: Casel
 * Date: 18/01/2021 @ 18:51
 * Class: ChatListener
 */
public class ChatListener implements Listener {
    private final Chat chat = null;
    private boolean found;
    @EventHandler
    // implements other chat format to see the tag and color when player write
    public void chatFormat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String format = Color.translate(Casel.getInstance().getConfig().getString("PREFIX.CHAT")
                .replace("%ign%", player.getName())
                .replace("%message%",  event.getMessage())
                .replace("%color%", String.valueOf(Casel.getInstance().getPlayerData().getColor(player)))
                .replace("%tag%", String.valueOf(Casel.getInstance().getPlayerData().getTags(player)))
                .replace("%rank_prefix%", String.valueOf(Casel.getChat().getPlayerPrefix(player)))
                .replace("%rank_suffix%", String.valueOf(Casel.getChat().getPlayerSuffix(player))));
        event.setFormat(format);
    }
    public String getRankName(Player player) {
        if (!this.found|| this.chat == null)
            return "Default";
        return this.chat.getPrimaryGroup(player);
    }
}
