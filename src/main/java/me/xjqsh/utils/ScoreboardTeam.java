package me.xjqsh.utils;

import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardTeam {
    /**便捷初始化队伍并进行默认设置*/
    public static void register(Scoreboard scoreboard, ChatColor color){
        Team team = scoreboard.registerNewTeam(color.name());
        team.setColor(color);
        team.setCanSeeFriendlyInvisibles(true);
    }
}
