package me.xjqsh.lesraisinscore.modes;

import me.xjqsh.lesraisinscore.LesRaisinsCore;
import me.xjqsh.lesraisinscore.maps.CombatModeMap;
import me.xjqsh.utils.TitleSender;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class CombatMode extends LesMode implements Listener {
    private int score_red=0;
    private int score_blue=0;
    private final int max_kill;
    private ChatColor winner;
    private boolean isEnd;
    public CombatMode(int max_kill){
        this.max_kill=max_kill;
        this.winner=null;
        this.isEnd=false;
    }
    //所有人加入队伍且每队至少有一个人才能开始
    @Override
    public void start(){
        if(canStart())return;
        //注册监听器
        Bukkit.getPluginManager().registerEvents(this, LesRaisinsCore.getPlugin());
        //todo 把人tp到双方初始点发装备
        Scoreboard scb = room.getScoreboard();
        Team red = scb.getTeam(ChatColor.RED.name());
        Team blue = scb.getTeam(ChatColor.BLUE.name());
        if(red==null || blue==null){throw new NullPointerException();}
        for(String playerName : red.getEntries()){
            Player p = Bukkit.getPlayer(playerName);
            if(p==null)continue;
            p.teleport(((CombatModeMap) room.getMap()).getRedSpawn());
        }
        for(String playerName : blue.getEntries()){
            Player p = Bukkit.getPlayer(playerName);
            if(p==null)continue;
            p.teleport(((CombatModeMap) room.getMap()).getRedSpawn());
        }
    }

    @Override
    public boolean canStart(){
        Scoreboard scb = room.getScoreboard();
        Team red = scb.getTeam(ChatColor.RED.name());
        Team blue = scb.getTeam(ChatColor.BLUE.name());
        if(red==null || blue==null){throw new NullPointerException();}
        //todo 检测地图是否可用
        if(!(room.getMap() instanceof CombatModeMap))return false;

        if(red.getEntries().isEmpty() || blue.getEntries().isEmpty())return false;
        for(String playerName : room.getPlayers()){
            if(scb.getTeam(playerName)==null)return false;
        }
        return true;
    }

    @Override
    public void end(){
        if(isEnd)return;
        this.isEnd=true;
        //todo 改变地图可用标记
        if(winner==null){
            if(score_red==score_blue)winner=ChatColor.YELLOW;
            else winner=(score_red>score_blue ? ChatColor.RED : ChatColor.BLUE);
        }
        for(String playerName : room.getPlayers()){
            Player p = Bukkit.getPlayer(playerName);
            if(p==null)continue;
            TitleSender.sendCombatEndMessage(p,winner);
            p.performCommand("/cmi spawn");
        }
        this.unregister();
    }

    @Override
    public void unregister(){
        super.unregister();
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        if(!room.isInRoom(player.getName()))return;
        Team team = room.getScoreboard().getEntryTeam(player.getName());
        if(team!=null && team.getColor()==ChatColor.BLUE)score_red++;
        else score_blue++;
        if(score_blue>=max_kill) {
            winner=ChatColor.BLUE;
        }else if(score_red>=max_kill) {
            winner=ChatColor.RED;
        }
        end();
    }
}
