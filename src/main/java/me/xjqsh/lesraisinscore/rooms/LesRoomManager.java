package me.xjqsh.lesraisinscore.rooms;

import me.xjqsh.lesraisinscore.LesRaisinsCore;
import me.xjqsh.lesraisinscore.maps.LesMap;
import me.xjqsh.lesraisinscore.modes.LesMode;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**房间的管理器,用于房间的统筹管理*/
public class LesRoomManager {
    /**房间列表*/
    private Map<Integer,LesRoom> roomList;
    /**玩家对应的房间id*/
    private Map<String,Integer> players;
    /**下一个id*/
    private int curID = 0;
    private final LesRaisinsCore plugin = LesRaisinsCore.getPlugin();
    /**向房间管理器注册一个新的房间
     * @param mode 房间的模式
     * @param mapID 选择的地图
     * @return LesRoom 如果注册成功
     * null 如果地图不可用或者超过房间上限或者模式与地图不匹配
     * */
    public synchronized LesRoom registerRoom(@NotNull LesMode mode, int mapID){
        if(roomList.size()>2048)return null;
//        LesMap map = plugin.getMapManager().getMap(mapID);
//        if(map==null || !map.isAvailable() || !mode.mapType.equals(map.getMapType()))return null;
//        map.setAvailable(false);
        LesRoom room = new LesRoom(curID);
        roomList.put(curID,room);
        curID++;
        return room;
    }

    public boolean unregisterRoom(int roomID){
        LesRoom room = roomList.get(roomID);
        if(room==null)return false;
        else{
            room.unregister();
            roomList.remove(roomID);
            return true;
        }
    }

    public boolean addPlayer(int roomID, Player player){
        LesRoom room = roomList.get(roomID);
        if(room==null || players.containsKey(player.getName()))return false;
        if(room.addPlayer(player)){
            players.put(player.getName(),roomID);
            return true;
        }else return false;
    }

    public boolean removePlayer(Player player){
        if(!players.containsKey(player.getName()))return false;
        LesRoom room = roomList.get(players.get(player.getName()));
        if(room==null)return false;
        if(room.removePlayer(player)){
            players.remove(player.getName());
            return true;
        }else return false;
    }
}
