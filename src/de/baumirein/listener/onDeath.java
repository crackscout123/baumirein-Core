package de.baumirein.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.baumirein.Main;

public class onDeath implements Listener{
	
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Entity et = e.getEntity();
		if(et instanceof Player) {			
			Player p = ((Player) et).getPlayer();

			//rest lastLocation onDeath
			if(Main.lastLocation.containsKey(p)) { Main.lastLocation.remove(p, p.getLocation()); }
		}
	}
	
}


/**
* @author JOE_
*
* @created 19.09.2019 (18:25:03)
*/
