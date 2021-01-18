package me.sakio.casel.manager.provide;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Color;

@AllArgsConstructor
@Getter
public enum ChatColor {
    RED("RED", "color.test", Color.RED);

    private final String name_color;
    private final String permissions;
    private final Color color;



}
