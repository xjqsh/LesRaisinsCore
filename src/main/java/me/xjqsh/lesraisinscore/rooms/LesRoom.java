package me.xjqsh.lesraisinscore.rooms;

import me.xjqsh.lesraisinscore.maps.LesMap;
import me.xjqsh.lesraisinscore.modes.LesMode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;
/**房间类*/
public class LesRoom {
    private LesMode mode;
    private LesMap map;
    private boolean isPlaying;
    private final List<String> playerList = new ArrayList<>();
    private final Scoreboard scoreboard;
    private final int id;

    protected LesRoom(LesMode mode,LesMap map,int id){
        assert Bukkit.getScoreboardManager()!=null;
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.id=id;
    }

    public LesMode getMode() {
        return mode;
    }

    public void setMode(LesMode mode) {
        if(isPlaying)return;
        this.mode = mode;
    }

    public LesMap getMap() {
        return map;
    }

    public void setMap(LesMap map) {
        if(isPlaying)return;
        this.map = map;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public Scoreboard getScoreboard(){
        return this.scoreboard;
    }
    /**向房间添加玩家,该方法应该由room manager调用
     * @param player 玩家
     * @return true 如果添加成功；false 如果玩家为null或者已经在房间中
     * */
    protected boolean addPlayer(Player player){
        if(player==null || playerList.contains(player.getName()))return false;
        playerList.add(player.getName());
        return true;
    }
    /**从房间删除玩家,该方法应该由room manager调用
     * @param player 玩家
     * @return true 如果删除成功；false 如果玩家为null或者不在房间中
     * */
    protected boolean removePlayer(Player player){
        if(player==null || !playerList.contains(player.getName()))return false;
        playerList.remove(player.getName());
        return true;
    }

    protected void unregister(){
        mode.end();
        map.setAvailable(true);
        mode=null;
        map=null;
        playerList.clear();
        for(Team team : scoreboard.getTeams())team.unregister();
        for(Objective obj : scoreboard.getObjectives())obj.unregister();
    }
}
