package me.xjqsh.utils;

import me.xjqsh.lesraisinscore.LesRaisinsCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.List;

public class ScoreboardTeam {
    /**便捷初始化队伍并进行默认设置*/
    public static Team register(Scoreboard scoreboard, ChatColor color){
        Team team = scoreboard.registerNewTeam(color.name());//队伍名为颜色的名字
        team.setColor(color);//设置颜色
        team.setCanSeeFriendlyInvisibles(true);
        return team;
    }
    /**试图自动分队*/
    public static void autoDiv(Player player){
        if(player==null)return;
        LesRaisinsCore.plugin().getLogger().info("玩家"+player.getName()+"使用了随机分队.");
        ateam();
    }

    public static void autoDiv(){
        ateam();
    }

    private static void ateam() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        String[] s = {"teamred","teamblue"};
        int n = Bukkit.getOnlinePlayers().size();
        int[] num = {(n%2==0 ? n/2 : n/2+1),n/2};
        int i;
        for(Player p : Bukkit.getOnlinePlayers()){
            if(num[0]==0)i=1;
            else if(num[1]==0)i=0;
            else i=(int) (Math.random()+0.5);
            num[i]--;
            scoreboard.getTeam(s[i]).addEntry(p.getName());
        }
    }
}
