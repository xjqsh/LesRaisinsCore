package me.xjqsh.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TitleSender {
    public static void sendCombatEndMessage(Player p,ChatColor color){
        if(p==null)return;
        String title;
        String subTitle=ChatColor.DARK_GREEN +"游戏结束！";
        switch (color){
            case YELLOW:
                title = ChatColor.YELLOW + "平局";break;
            case RED:
                title = ChatColor.RED + "红队胜利";break;
            case BLUE:
                title = ChatColor.BLUE + "蓝队胜利";break;
            default:
                title="非法参数";
        }
        p.sendTitle(title,subTitle,15,60,15);
    }
}
