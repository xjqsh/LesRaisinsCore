package me.xjqsh.lesraisinscore.modes.combat;

import me.xjqsh.lesraisinscore.modes.LesMode;
import me.xjqsh.lesraisinscore.rooms.LesRoom;
import me.xjqsh.utils.ScoreboardTeam;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Objects;

public abstract class CombatMode extends LesMode {
    public static String mapType = "combat";

    protected final LesRoom room;

    public CombatMode(LesRoom room){
        this.room=room;
        Scoreboard combatScoreboard = room.getScoreboard();
        //为计分板初始化两个队伍
        ScoreboardTeam.register(combatScoreboard, ChatColor.RED);
        ScoreboardTeam.register(combatScoreboard, ChatColor.BLUE);
    }

    public boolean teamJoin(String player,ChatColor color){
        if(color != ChatColor.RED && color!=ChatColor.BLUE)return false;
        if(!room.isInRoom(player))return false;
        Scoreboard scoreboard = room.getScoreboard();
        if(scoreboard.getEntryTeam(player)!=null) Objects.requireNonNull(scoreboard.getEntryTeam(player)).removeEntry(player);
        Objects.requireNonNull(scoreboard.getTeam(color.name())).addEntry(player);
        return true;
    }

    public boolean teamLeave(String player){
        if(!room.isInRoom(player))return false;
        Scoreboard scoreboard = room.getScoreboard();
        if(scoreboard.getEntryTeam(player)==null)return false;
        else Objects.requireNonNull(scoreboard.getEntryTeam(player)).removeEntry(player);
        return true;
    }
}
