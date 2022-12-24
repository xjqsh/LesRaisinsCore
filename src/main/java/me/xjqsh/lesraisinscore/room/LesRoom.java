package me.xjqsh.lesraisinscore.room;

import me.xjqsh.lesraisinscore.LesRaisinsCore;
import me.xjqsh.utils.ScoreboardTeam;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class LesRoom {
    private static String mode = null;

    private final LesRaisinsCore lesRaisinsCore = LesRaisinsCore.plugin();

    private final Scoreboard scoreboard;
    private final List<String> playerList = new ArrayList<>();
    private final int roomId;

    private boolean isPlaying;

    protected LesRoom(int roomId){
        this.isPlaying=false;
        this.roomId=roomId;
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    }

    public Scoreboard getScoreboard(){
        return this.scoreboard;
    }
    /**
     * 向房间注册一个新的队伍
     * */
    public Team registerNewTeam(ChatColor color){
        return ScoreboardTeam.register(scoreboard,color);
    }

    protected void unregisterRoom(){
        for(Team team : scoreboard.getTeams())team.unregister();
        playerList.clear();
        isPlaying=false;
    }

    public abstract void start();

    public abstract boolean canStart();

    public abstract void end();

    protected void setPlaying(boolean status){
        this.isPlaying=status;
    }
    /**向房间添加玩家,该方法应该由room manager调用
     * @param player 要添加的玩家
     * @return true 如果添加成功;
     *         false 如果玩家已经在(其他)房间中,或者游戏已经开始.
     * */
    protected boolean addPlayer(@NotNull Player player){
        if(isPlaying)return false;
        //玩家已经在房间中
        if(player.hasMetadata("lesroom"))return false;
        if(playerList.contains(player.getName()))return false;
        //给玩家打上元数据标签
        player.setMetadata("lesroom",new FixedMetadataValue(lesRaisinsCore,roomId));
        //放进列表
        playerList.add(player.getName());
        return true;
    }
    /**从房间删除玩家,该方法应该由room manager调用
     * @param player 要添加的玩家
     * @return true 如果删除成功;
     *         false 如果玩家不在该房间中.
     * */
    protected boolean removePlayer(@NotNull Player player){
        String name = player.getName();
        //玩家不在该房间中
        if(!playerList.contains(name))return false;
        if(!player.hasMetadata("lesroom"))throw new NullPointerException("player应具有元数据");
        //移除元数据
        player.removeMetadata("lesroom",lesRaisinsCore);
        //从列表删除
        playerList.remove(name);
        //也从房间队伍中删除
        Team team = scoreboard.getEntryTeam(name);
        if(team!=null)team.removeEntry(name);
        return true;
    }

    public List<String> getPlayerList(){
        return playerList;
    }
}


