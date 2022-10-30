package me.xjqsh.lesraisinscore.rooms;

import me.xjqsh.lesraisinscore.maps.LesMap;
import me.xjqsh.lesraisinscore.modes.LesMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
/**房间类*/
public class LesRoom {
    private LesMode mode;
    private LesMap map;
    private boolean isPlaying;
    private final List<String> playerList = new ArrayList<>();
    private LesRoomManager panel;

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
    /**向房间添加玩家
     * @return true 如果添加成功；false 如果玩家为null或者已经在房间中
     * */
    protected boolean addPlayer(Player player){
        if(player==null || playerList.contains(player.getName()))return false;
        playerList.add(player.getName());
        return true;
    }
    /**从房间删除玩家
     * @return true 如果删除成功；false 如果玩家为null或者不在房间中
     * */
    protected boolean removePlayer(Player player){
        if(player==null || !playerList.contains(player.getName()))return false;
        playerList.remove(player.getName());
        return true;
    }
}
