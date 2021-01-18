package me.sakio.casel.listener;

import me.sakio.casel.Casel;
import me.sakio.casel.manager.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by DevSakio
 * Project: Casel
 * Date: 13/01/2021 @ 15:55
 * Class: PlayerListener
 */
public class PlayerListener implements Listener {
    @EventHandler
    public void firstPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerData playerData = Casel.getInstance().getPlayerData();

    }
}
