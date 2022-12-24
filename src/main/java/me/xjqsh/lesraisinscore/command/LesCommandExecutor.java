package me.xjqsh.lesraisinscore.command;

import me.xjqsh.utils.ScoreboardTeam;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LesCommandExecutor implements CommandExecutor {
    /**
     * 执行传入的命令，返回它的执行结果.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args[0].equals("random")){
            if(sender instanceof Player){
                ScoreboardTeam.autoDiv(((Player) sender).getPlayer());
            }else{
                ScoreboardTeam.autoDiv();
            }
            return true;
        }
        sender.sendMessage("错误的指令");
        return true;
    }
}
