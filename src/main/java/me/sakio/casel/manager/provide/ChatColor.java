package me.sakio.casel.manager.provide;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Color;

@AllArgsConstructor
@Getter
public enum ChatColor {
    //You can change null for other color if you want a other default color for example:
    // DEFAULT("DEFAULT", "color.test", Color.GREEN),
    DEFAULT("DEFAULT", "color.test", null),
    RED("RED", "color.test1", Color.RED);

    private final String name_color; //The name of color
    private final String permissions; //The color permissions to use
    private final Color color; //The color to write in the chat



}
