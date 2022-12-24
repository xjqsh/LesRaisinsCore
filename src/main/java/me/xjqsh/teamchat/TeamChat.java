package me.xjqsh.teamchat;

import me.xjqsh.lesraisinscore.LesRaisinsCore;
import me.xjqsh.teamchat.runnable.TeamChatRelayTask;
import me.xjqsh.utils.ModeInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TeamChat implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent chatEvent){
        if(chatEvent.isCancelled())return;
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Player player = chatEvent.getPlayer();
        if(scoreboard.getObjective("tick")==null)return;
        if(ModeInfo.getMode()==9 &&
                player.getGameMode()==GameMode.SPECTATOR &&
                !chatEvent.getPlayer().hasPermission("lesraisinscore.chat.bypass")){
            chatEvent.setCancelled(true);
            player.sendMessage(ChatColor.RED + "爆破模式 观战请不要发言！");
            return;
        }
        Team team=scoreboard.getEntryTeam(player.getName());
        if(team==null || !(team.getName().equals("teamred") || team.getName().equals("teamblue")))return;
        if(chatEvent.getMessage().charAt(0)=='#' && chatEvent.getMessage().length()>1) {
            chatEvent.setMessage(chatEvent.getMessage().substring(1));
            return;
        }
        chatEvent.setCancelled(true);
        new TeamChatRelayTask(player.getName(),chatEvent.getMessage()).runTask(LesRaisinsCore.plugin());
    }
}

