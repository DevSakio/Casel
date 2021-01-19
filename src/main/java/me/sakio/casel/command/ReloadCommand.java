package me.sakio.casel.command;

import me.sakio.casel.Casel;
import me.sakio.casel.utils.Color;
import me.sakio.casel.utils.DataFile;
import me.sakio.casel.utils.commands.Command;
import me.sakio.casel.utils.commands.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by DevSakio
 * Project: Casel
 * Date: 19/01/2021 @ 21:11
 * Class: ReloadCommand
 */
public class ReloadCommand {
    @Command(name = "reload", permission = "manager.reload")
    public void OnCommand(CommandArgs cmd){
        Player player = cmd.getPlayer();
        DataFile.getConfig().reload();
        Casel.getInstance().reloadConfig();
        player.sendMessage(Color.translate("&3Casel config has been reset!"));
    }
}
