package me.sakio.casel.menu;

import me.sakio.casel.Casel;
import me.sakio.casel.manager.PlayerData;
import me.sakio.casel.manager.provide.ChatColor;
import me.sakio.casel.manager.provide.Tags;
import me.sakio.casel.utils.Color;
import me.sakio.casel.utils.ItemMaker;
import me.sakio.casel.utils.menu.type.ChestMenu;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DevSakio
 * Project: Casel
 * Date: 19/01/2021 @ 20:46
 * Class: ColorMenu
 */
public class ColorMenu extends ChestMenu<Casel> {

    private Player player;
    private final PlayerData playerData = Casel.getInstance().getPlayerData();
    private ChatColor color;

    public ColorMenu(Player player) {
        super("Choose a color", 9 * 4);
        this.player = player;
        this.update();
    }

    private void update() {
        this.inventory.setItem(0, new ItemMaker(Material.SIGN).setTitle("&aRed ").build());
        this.inventory.setItem(4, new ItemMaker(Material.INK_SACK).setTitle("&cReset Color").build());
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Inventory topInventory = event.getView().getTopInventory();

        if (!topInventory.equals(this.inventory)) return;

        if (topInventory.equals(clickedInventory)) {
            event.setCancelled(true);

            ItemStack item = event.getCurrentItem();
            if (item == null || item.getType() == Material.AIR) return;

            Player player = (Player) event.getWhoClicked();

            if (event.getRawSlot() == 4) {
                Casel.getInstance().getPlayerData().setColor(player, ChatColor.DEFAULT.getColor());
                player.closeInventory();
                player.sendMessage(Color.translate(Casel.getInstance().getConfig().getString("COLOR.MESSAGE.RESET")));
                player.playSound(player.getLocation(),
                        Sound.valueOf(Casel.getInstance().getConfig().getString("COLOR.SOUNDS.RESET")),
                        2.0f, (float)1.0);
            }
            if (!player.hasPermission(color.getPermissions())) {
                player.sendMessage(Color.translate(Casel.getInstance().getConfig().getString("COLOR.MESSAGE.DENIED")));
                player.playSound(player.getLocation(),
                        Sound.valueOf(Casel.getInstance().getConfig().getString("COLOR.SOUNDS.DENIED")),
                        2.0f, (float)1.0);
                return;
            }
            switch (event.getRawSlot()) {
                case 9:
                        playerData.setColor(player, ChatColor.RED.getColor());
                        player.closeInventory();
                        player.sendMessage(Color.translate(Casel.getInstance().getConfig().getString("COLOR.MESSAGE.DENIED"))
                                .replace("<color>", playerData.getColor(player)));
                        player.playSound(player.getLocation(),
                                Sound.valueOf(Casel.getInstance().getConfig().getString("COLOR.SOUNDS.APPLY")),
                                2.0f, (float) 1.0);
                        event.setCancelled(true);
                        break;
            }
        }
    }
}
