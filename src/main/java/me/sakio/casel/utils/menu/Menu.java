package me.sakio.casel.utils.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;

public interface Menu extends InventoryHolder {

    default void open(Player player) {
        player.openInventory(this.getInventory());
    }

    void onInventoryClick(InventoryClickEvent event);

    default void onInventoryDrag(InventoryDragEvent event) {
        if (clickedTopInventory(event)) event.setCancelled(true);
    }

    default void onInventoryClose(InventoryCloseEvent event) { }

    static boolean clickedTopInventory(InventoryDragEvent event) {
        InventoryView view = event.getView();
        Inventory topInventory = view.getTopInventory();
        if (topInventory == null) {
            return false;
        }
        boolean result = false;
        int size = topInventory.getSize();
        for (Integer entry : event.getNewItems().keySet()) {
            if (entry >= size) continue;
            result = true;
            break;
        }
        return result;
    }

}
