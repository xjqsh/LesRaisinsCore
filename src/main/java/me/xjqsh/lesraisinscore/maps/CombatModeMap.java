package me.xjqsh.lesraisinscore.maps;

import org.bukkit.Location;

public class CombatModeMap extends LesMap {
    private Location redSpawn;
    private Location blueSpawn;

    public CombatModeMap(int mapID, String displayName) {
        super(mapID, displayName);
    }

    public Location getRedSpawn() {
        return redSpawn;
    }

    public void setRedSpawn(Location redSpawn) {
        this.redSpawn = redSpawn;
    }

    public Location getBlueSpawn() {
        return blueSpawn;
    }

    public void setBlueSpawn(Location blueSpawn) {
        this.blueSpawn = blueSpawn;
    }

}
