package me.xjqsh.lesraisinscore;

import me.xjqsh.lesraisinscore.command.LesCommandExecutor;
import me.xjqsh.limit.LesLimit;
import me.xjqsh.teamchat.TeamChat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LesRaisinsCore extends JavaPlugin{

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new TeamChat(),this);
        Bukkit.getPluginManager().registerEvents(new LesLimit(),this);
        Bukkit.getPluginCommand("lesraisins").setExecutor(new LesCommandExecutor());
    }

    @Override
    public void onDisable() {

    }

    public static LesRaisinsCore plugin(){
        return (LesRaisinsCore)Bukkit.getPluginManager().getPlugin("LesRaisinsCore");
    }

}
