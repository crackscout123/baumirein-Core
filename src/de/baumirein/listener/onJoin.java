package de.baumirein.listener;

import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.baumirein.commands.vanish;
import de.baumirein.commands.warps.cfg_gen;

public class onJoin implements Listener {
	

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e){
		vanish.vanished.remove(e.getPlayer());
	}
	
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		try {
			p.teleport(cfg_gen.loadLoc("spawn"));
		} catch (IOException | InvalidConfigurationException e1) {
			e1.printStackTrace();
		}
	}
}


/**
* @author JOE_
*
* @created 19.09.2019 (18:20:45)
*/
