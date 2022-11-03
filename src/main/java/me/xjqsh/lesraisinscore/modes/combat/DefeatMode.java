package me.xjqsh.lesraisinscore.modes.combat;

import me.xjqsh.lesraisinscore.maps.CombatMap;
import me.xjqsh.lesraisinscore.rooms.LesRoom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class DefeatMode extends CombatMode{
    public DefeatMode(LesRoom room) {
        super(room);
    }

    @Override
    public boolean start() {
        if(!canStart())return false;
        room.setPlaying(true);
        for(String playerName : room.getPlayers()){
            Player player = Bukkit.getPlayer(playerName);
            if(player==null)continue;

            Team team = room.getScoreboard().getEntryTeam(playerName);
            if (team == null) throw new NullPointerException();
            ChatColor color = team.getColor();
            CombatMap map = (CombatMap) room.getMap();

            player.teleport(map.getRespawn(color));
        }
        //todo
        return true;
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
