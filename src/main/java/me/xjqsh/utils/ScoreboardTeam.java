package me.xjqsh.utils;

import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardTeam {
    /**便捷初始化队伍并进行默认设置*/
    public static void register(Scoreboard scoreboard, ChatColor color){
        Team team = scoreboard.registerNewTeam(color.name());//队伍名为颜色的名字
        team.setColor(color);//设置颜色
        team.setCanSeeFriendlyInvisibles(true);
    }
}
