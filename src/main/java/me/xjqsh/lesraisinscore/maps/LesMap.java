package me.xjqsh.lesraisinscore.maps;

public abstract class LesMap {
    private final int mapID;
    private String displayName;
    private boolean isAvailable;

    public LesMap(int mapID,String displayName){
        this.mapID=mapID;
        this.displayName=displayName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
