package n0devx.scoreboard_ethria;

import n0devx.scoreboard_ethria.Scoreboard.PlayerJoinListener;
import n0devx.scoreboard_ethria.Scoreboard.ScoreboardHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.NotNull;


public final class Scoreboard_Ethria extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        new ScoreboardHandler().startAnimation();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                @NotNull Scoreboard scoreboard = null;
                e.getPlayer().setScoreboard(scoreboard);
            }
        }, 0, 20);
    }
}
