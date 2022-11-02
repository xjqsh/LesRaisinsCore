package me.xjqsh.lesraisinscore.rooms;

import me.xjqsh.lesraisinscore.LesRaisinsCore;
import me.xjqsh.lesraisinscore.maps.LesMap;
import me.xjqsh.lesraisinscore.modes.LesMode;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**房间的管理器,用于房间的统筹管理*/
public class LesRoomManager {
    private Map<Integer,LesRoom> rooms;
    private int id=0;
    private final LesRaisinsCore plugin = LesRaisinsCore.getPlugin();
    /**向房间管理器注册一个新的房间
     * @param mode 房间的模式
     * @param mapID 选择的地图
     * @return LesRoom 如果注册成功
     * null 如果地图不可用或者超过房间上限或者模式与地图不匹配
     * */
    public synchronized LesRoom registerRoom(@NotNull LesMode mode, int mapID){
        if(rooms.size()>2048)return null;
        LesMap map = plugin.getMapManager().getMap(mapID);
        if(map==null || !map.isAvailable())return null;
        if(!mode.mapType.equals(map.getMapType()))return null;
        map.setAvailable(false);
        LesRoom room = new LesRoom(mode,plugin.getMapManager().getMap(mapID),id);
        rooms.put(id,room);
        id++;
        return room;
    }

    public boolean unregisterRoom(int roomId){
        LesRoom room = rooms.get(roomId);
        if(room==null)return false;
        else{
            room.unregister();
            rooms.remove(roomId);
            return true;
        }
    }

}
