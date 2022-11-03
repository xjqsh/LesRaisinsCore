package me.xjqsh.lesraisinscore.modes.combat;

import me.xjqsh.lesraisinscore.rooms.LesRoom;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class DefeatMode extends CombatMode{
    public DefeatMode(LesRoom room) {
        super(room);
    }

    @Override
    public boolean start() {
        return false;
    }

    @Override
    public boolean end() {
        return false;
    }

    @Override
    public boolean canStart() {
        Scoreboard scoreboard = room.getScoreboard();
        if(scoreboard==null)return false;
        for(Team team : scoreboard.getTeams()){
            if(team.getSize()==0)return false;
        }
        for(String player : room.getPlayers()){
            if(scoreboard.getEntryTeam(player)==null)return false;
        }
        return true;
    }
}
