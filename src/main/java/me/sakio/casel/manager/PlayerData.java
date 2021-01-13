package me.sakio.casel.manager;

import me.sakio.casel.utils.DataFile;
import org.bukkit.entity.Player;

/**
 * Created by DevSakio
 * Project: Casel
 * Date: 13/01/2021 @ 15:57
 * Class: PlayerData
 */
public class PlayerData {
    public void createData(Player player){
        if (!DataFile.getConfig().getConfigurationSection("PLAYER-DATA").getKeys(false).contains(player.getUniqueId().toString())) {
            DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".NAME", player.getName());
            DataFile.getConfig().saveAll();
        }
    }
    public String getFirstJoin(Player player) {
        return DataFile.getConfig().getString("PLAYER-DATA." + player.getUniqueId() + ".FIRST-JOIN");
    }

    public void setFirstJoin(Player player, boolean status) {
        DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".FIRST-JOIN", status);
        DataFile.getConfig().saveAll();
    }
}
