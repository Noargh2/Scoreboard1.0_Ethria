package n0devx.scoreboard_ethria.Scoreboard;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin (final PlayerJoinEvent event) throws InterruptedException {
        new ScoreboardHandler().setScoreboard(event.getPlayer());

    }
}
