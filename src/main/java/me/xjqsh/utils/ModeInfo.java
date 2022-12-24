package me.xjqsh.utils;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;

public class ModeInfo {
    public static int getMode(){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if(scoreboard.getObjective("tick")==null)return -1;
        else return scoreboard.getObjective("tick").getScore("mode").getScore();
    }
}
