package me.xjqsh.teamchat.runnable;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TeamChatRelayTask extends BukkitRunnable {

    private final String player;
    private final String msg;

    public TeamChatRelayTask(String player, String msg){
        this.player=player;
        this.msg=msg;
    }
    @Override
    public void run(){
        if(Bukkit.getPlayer(player)==null)return;
        Bukkit.getPlayer(player).performCommand("teammsg "+msg);
    }
}
