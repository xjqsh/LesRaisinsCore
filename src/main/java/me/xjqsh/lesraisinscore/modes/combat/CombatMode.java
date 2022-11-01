package me.xjqsh.lesraisinscore.modes.combat;

import me.xjqsh.lesraisinscore.modes.LesMode;
import me.xjqsh.lesraisinscore.rooms.LesRoom;
import me.xjqsh.utils.ScoreboardTeam;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;

public abstract class CombatMode extends LesMode {
    public static String mapType = "combat";

    private LesRoom room;

    public CombatMode(LesRoom room){
        this.room=room;
        Scoreboard combatScoreboard = room.getScoreboard();
        //为计分板初始化两个队伍
        ScoreboardTeam.register(combatScoreboard, ChatColor.RED);
        ScoreboardTeam.register(combatScoreboard, ChatColor.BLUE);
    }
}
