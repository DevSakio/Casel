package me.sakio.casel.utils;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class Color {
	
	public static String translate(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}

	public static List<String> translate(List<String> text) {
		return text.stream().map(Color::translate).collect(Collectors.toList());
	}

	public static String noPerms(){
		return Color.translate("&cYou dont have perms to use this command!");
	}
}
