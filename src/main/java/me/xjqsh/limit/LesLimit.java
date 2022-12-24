package me.xjqsh.limit;

import me.xjqsh.utils.ModeInfo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Arrays;
import java.util.List;


public class LesLimit implements Listener {
    private final List<Integer> lockedHotBars = Arrays.asList(0,1,2,8,40);

    @EventHandler
    public void onPlayerClickGuns(InventoryClickEvent event){
        if (event.getWhoClicked().hasPermission("lesraisinscore.limit.bypass"))return;

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if(scoreboard.getObjective("tick")==null)return;

        int slot = event.getSlot();
        if(lockedHotBars.contains(slot) && ModeInfo.getMode()==9) event.setCancelled(true);
        if(event.getClick().isKeyboardClick() && lockedHotBars.contains(event.getHotbarButton()))event.setCancelled(true);
    }

//    @EventHandler
//    public void onPlayerDragItems(InventoryDragEvent event){
//        if (event.getWhoClicked().hasPermission("lesraisinscore.limit.bypass"))return;
//
//        for(int i : lockedHotBars)
//            if(event.getInventorySlots().contains(i))event.setCancelled(true);
//    }
}
