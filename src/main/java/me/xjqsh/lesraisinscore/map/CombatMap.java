package me.xjqsh.lesraisinscore.map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class CombatMap implements LesMap{
    private String name;
    private Location redSpawn;
    private Location blueSpawn;

    private CombatMap(Location redSpawn,Location blueSpawn){

    }

    @Override
    public String getName() {
        return name;
    }

    public static CombatMap initMap(String world,double x1,double y1,double z1,double x2,double y2,double z2){
        World w = Bukkit.getWorld(world);
        if(w==null)return null;
        Location red = new Location(w,x1,y1,z1);
        Location blue = new Location(w,x1,y1,z1);
        return null;
    }
}
