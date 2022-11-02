package me.xjqsh.lesraisinscore.maps;

/**最基础的地图类**/
public abstract class LesMap {
    private final int mapID;
    private final String mapName;
    private boolean isAvailable;
    public static String mapType;

    protected LesMap(int id, String name){
        this.mapID=id;
        this.mapName=name;
    }

    public String getMapType(){return mapType;}

    public int getMapID(){
        return mapID;
    }

    public String getMapName() {
        return mapName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status) {
        isAvailable = status;
    }

}
