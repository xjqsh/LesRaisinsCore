package me.xjqsh.lesraisinscore.maps;

import org.bukkit.Location;

/**两队对抗的地图*/
public class CombatMap extends LesMap{
    /**两队的复活点*/
    private Location respawnRed;
    private Location respawnBlue;
    public static String mapType = "combat";
    /**应由map manager调用*/
    protected CombatMap(int id,String name,Location red,Location blue){
        super(id,name);
    }

    public Location getRespawnRed() {
        return respawnRed;
    }

    public void setRespawnRed(Location respawnRed) {
        this.respawnRed = respawnRed;
    }

    public Location getRespawnBlue() {
        return respawnBlue;
    }

    public void setRespawnBlue(Location respawnBlue) {
        this.respawnBlue = respawnBlue;
    }

    public static LesMap register(int id,String name,Location red,Location blue) {
        return null;
    }
}
