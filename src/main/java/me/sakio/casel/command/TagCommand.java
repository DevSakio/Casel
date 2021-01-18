package me.sakio.casel.command;

import me.sakio.casel.utils.commands.Command;
import me.sakio.casel.utils.commands.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by DevSakio
 * Project: Casel
 * Date: 14/01/2021 @ 19:25
 * Class: TagCommand
 */
public class TagCommand {
    @Command(name = "tag", permission = "tag.command", inGameOnly = true)
    public void OnCommand(CommandArgs cmd){
        Player player = cmd.getPlayer();
        String[] args = cmd.getArgs();
    }
}
