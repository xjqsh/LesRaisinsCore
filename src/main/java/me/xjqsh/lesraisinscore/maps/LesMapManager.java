package me.xjqsh.lesraisinscore.maps;

import java.util.HashMap;
import java.util.Map;

/**地图管理器，用于地图的统筹管理*/
public class LesMapManager {
    private final Map<Integer,LesMap> mapList = new HashMap<>();
    private int id=0;

    public synchronized void registerMap(LesMap map){
        if(id>2048)return;
        mapList.put(id,map);
        id++;
    }

    public LesMap getMap(int id){
        return mapList.get(id);
    }


}
