package me.sakio.casel.manager;

import me.sakio.casel.manager.provide.ChatColor;
import me.sakio.casel.manager.provide.Tags;
import me.sakio.casel.utils.DataFile;
import org.bukkit.Color;
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
            DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".COLOR", ChatColor.RED.getName_color());
            DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".TAG", Tags.DEFAULT.getName());
            DataFile.getConfig().saveAll();
        }
    }
    public String getColor(Player player) {
        return DataFile.getConfig().getString("PLAYER-DATA." + player.getUniqueId() + ".COLOR");
    }

    public void setColor(Player player, Color color) {
        DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".COLOR", color);
        DataFile.getConfig().saveAll();
    }
    public String getTags(Player player) {
        return DataFile.getConfig().getString("PLAYER-DATA." + player.getUniqueId() + ".TAG");
    }

    public void setTags(Player player, Tags tags) {
        DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".TAG", tags.getName());
        DataFile.getConfig().saveAll();
    }
}
