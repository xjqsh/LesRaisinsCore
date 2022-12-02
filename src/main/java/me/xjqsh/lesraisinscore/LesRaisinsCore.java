package me.xjqsh.lesraisinscore;

import me.xjqsh.lesraisinscore.commands.LesCommandExecutor;
import me.xjqsh.lesraisinscore.maps.LesMapManager;
import me.xjqsh.lesraisinscore.rooms.LesRoomManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LesRaisinsCore extends JavaPlugin {

    private LesRoomManager roomManager;
    private LesMapManager mapManager;

    @Override
    public void onEnable() {
        mapManager = new LesMapManager();
        roomManager = new LesRoomManager();
        //noinspection ConstantConditions
        Bukkit.getPluginCommand("lesraisins").setExecutor(new LesCommandExecutor());
    }

    @Override
    public void onDisable() {

    }

    public static LesRaisinsCore getPlugin(){
        return (LesRaisinsCore)Bukkit.getPluginManager().getPlugin("LesRaisinsCore");
    }

    public LesRoomManager getRoomManager(){
        return this.roomManager;
    }

    public LesMapManager getMapManager(){
        return this.mapManager;
    }
}
