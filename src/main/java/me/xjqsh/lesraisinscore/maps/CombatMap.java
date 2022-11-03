package me.xjqsh.lesraisinscore.maps;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**两队对抗的地图*/
public class CombatMap extends LesMap{
    /**两队的复活点*/
    private Map<ChatColor,Location> respawns;

    protected CombatMap(int id, String name,@NotNull Location red,@NotNull Location blue){
        super(id,name);
    }

    public Location getRespawn(@NotNull ChatColor color) {
        return respawns.get(color);
    }

    public boolean setRespawn(@NotNull Location respawn,@NotNull ChatColor color) {
       if(!respawns.containsKey(color))return false;
       respawns.replace(color,respawn);
       return true;
    }

    @Override
    public String getMapType() {
        return "combat";
    }
}
