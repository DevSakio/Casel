package me.sakio.casel.utils;

import me.sakio.casel.Casel;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * Created by DevSakio
 * Project: FFA
 * Date: 07/01/2021 @ 12:16
 * Class: PlayerUtils
 */
public class PlayerUtils {
    public static void teleportToSpawn(Player player) {
        World world = Bukkit.getWorld(Casel.getInstance().getConfig().getString("SPAWN.WORLD-NAME"));

        int x = Casel.getInstance().getConfig().getInt("SPAWN.X");
        int y = Casel.getInstance().getConfig().getInt("SPAWN.Y");
        int z = Casel.getInstance().getConfig().getInt("SPAWN.Z");

        Location spawn = new Location(world, x, y, z);

        player.teleport(spawn);
    }

}
