package me.sakio.casel.menu;

import me.sakio.casel.Casel;
import me.sakio.casel.manager.PlayerData;
import me.sakio.casel.manager.provide.Tags;
import me.sakio.casel.utils.Color;
import me.sakio.casel.utils.ItemMaker;
import me.sakio.casel.utils.menu.type.ChestMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by DevSakio
 * Project: Casel
 * Date: 13/01/2021 @ 15:57
 * Class: PlayerData
 */
public class TagMenu extends ChestMenu<Casel> {

    private final PlayerData playerData = Casel.getInstance().getPlayerData();
    private Tags tag;

    public TagMenu(Player player) {
        super("Tag Selector", 9 * 3);
        this.update(player);
    }

    private void update(Player player) {
        this.inventory.setItem(4, new ItemMaker(Material.INK_SACK).setTitle("&cReset Prefix").build());
        AtomicInteger index = new AtomicInteger(10);
        Arrays.stream(Tags.values()).filter(tag -> !tag.getName().equalsIgnoreCase(tag.getName())).forEach(tag -> {
            if (index.get() == 17) index.set(19);
            this.inventory.setItem(index.getAndIncrement(), new ItemMaker(Material.NAME_TAG)
                    .setTitle(ChatColor.YELLOW + tag.getName()).build());
        });
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
            String itemName = ChatColor.stripColor(item.getItemMeta().getDisplayName());

 
            if (event.getRawSlot() == 4) {
                Casel.getInstance().getPlayerData().setTags(player, Tags.DEFAULT);
                player.closeInventory();
                player.sendMessage(Color.translate("&aYou have been sucessfully reset your prefix!"));
            }

            for (Tags value : Tags.values()) {
                if (value.getName().contains(itemName)) tag = value;
            }

            if (tag == null) return;

            if (!player.hasPermission(tag.getPermission())) {
                player.sendMessage(Color.translate("&cYou don't have permissions to select this prefix!"));
                return;
            }

            switch (tag) {
                case CASE_1:
                    playerData.setTags(player, Tags.CASE_1);
                    player.sendMessage(Color.translate("&cNew tag <tag>").replace("<tag>", playerData.getTags(player)));
                    player.closeInventory();
                    break;
                    //Copy this code and replace Tags.CASE_1 for other name tag
                    //And make case %NAME_TAG% to get the tag when you click
            }
        }
    }
}
