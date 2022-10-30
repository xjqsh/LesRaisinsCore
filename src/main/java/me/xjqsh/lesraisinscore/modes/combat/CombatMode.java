package me.xjqsh.lesraisinscore.modes.combat;

import me.xjqsh.lesraisinscore.modes.LesMode;
import me.xjqsh.utils.ScoreboardTeam;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;

public abstract class CombatMode extends LesMode {
    public static String mapType = "combat";
    private final Scoreboard combatScoreboard;

    public CombatMode(){
        assert Bukkit.getScoreboardManager()!=null;
        this.combatScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        ScoreboardTeam.register(combatScoreboard, ChatColor.RED);
        ScoreboardTeam.register(combatScoreboard, ChatColor.BLUE);
    }
}
