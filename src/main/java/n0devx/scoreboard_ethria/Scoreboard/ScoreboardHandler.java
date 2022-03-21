package n0devx.scoreboard_ethria.Scoreboard;

import n0devx.scoreboard_ethria.Scoreboard_Ethria;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;0


public class ScoreboardHandler {

    private static Integer animationCount;

    private String[] animation = new String[]{
            "§1§1§1§6§lEthria.de§1§1§1"
    };

    public void setScoreboard(final Player player) throws InterruptedException {
        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective objective = scoreboard.registerNewObjective("main-content", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(animation[animationCount]);
        objective.getScore("§1 ").setScore(14);
        objective.getScore("§7Rang:").setScore(13);
        objective.getScore("§8  ➥ >rang<").setScore(12);
        objective.getScore("§1 ").setScore(11);
        objective.getScore("§7Clan:").setScore(10);
        objective.getScore("§8  ➥ §3Clan").setScore(9);
        objective.getScore("§1").setScore(8);
        objective.getScore("§7Coins:").setScore(7);
        objective.getScore("§8  ➥ §e1.000,00").setScore(6);
        objective.getScore("§1 ").setScore(5);
        objective.getScore("§7Spielzeit:").setScore(4);
        //PlaceHolderAPI
        objective.getScore("x").setScore(3);
        objective.getScore("§1 ").setScore(2);


        player.setScoreboard(scoreboard);

    }

    private void setScore(int i) {
    }


    public void startAnimation() {
        animationCount = 0;
        Bukkit.getScheduler().runTaskTimer(Scoreboard_Ethria.getPlugin(Scoreboard_Ethria.class), new Runnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(current -> {

                    current.getScoreboard();

                    current.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(animation[animationCount]);
                });

                animationCount ++;

                if (animationCount == animation.length)
                    animationCount = 0;

            }
        }, 0, 3);
    }



}
