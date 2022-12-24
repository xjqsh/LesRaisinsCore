package me.xjqsh.lesraisinscore.room.modes;

import me.xjqsh.lesraisinscore.LesRaisinsCore;
import me.xjqsh.lesraisinscore.map.LesMap;
import me.xjqsh.lesraisinscore.room.LesRoom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Team;

public class CombatMode extends LesRoom implements Listener {

    public static String mode = "Combat";
    private final LesMap map;
    private Team red;
    private Team blue;

    protected CombatMode(int roomId,LesMap map) {
        super(roomId);
        this.map=map;
        this.red=registerNewTeam(ChatColor.RED);
        this.blue=registerNewTeam(ChatColor.BLUE);
        Bukkit.getPluginManager().registerEvents(this, LesRaisinsCore.plugin());
    }

    @Override
    public void start() {

    }

    @Override
    public boolean canStart() {
        //两队都至少需要一名玩家
        if(red.getEntries().isEmpty() || blue.getEntries().isEmpty())return false;
        //如果有玩家没有加入队伍
        for(String player : getPlayerList()){
            if(getScoreboard().getEntryTeam(player)==null)return false;
        }
        return true;
    }

    @Override
    public void end() {

    }
}
