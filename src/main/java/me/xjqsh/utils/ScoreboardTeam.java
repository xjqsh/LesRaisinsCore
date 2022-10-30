package me.xjqsh.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardTeam {
    public static void register(Scoreboard scoreboard, ChatColor color){
        Team team = scoreboard.registerNewTeam(color.name());
        team.setColor(color);
    }
}
