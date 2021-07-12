package de.baumirein.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onDeath implements Listener{

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Entity et = e.getEntity();
		if(et instanceof Player) {
			Player p = ((Player) et).getPlayer();
			if(p.getKiller() instanceof Player) {
				e.setDeathMessage(p.getDisplayName() + " §rwurde von §c" + p.getKiller().getDisplayName() + " §rexicutiert!");
			} else {
				//Bukkit.broadcastMessage(e.getDeathMessage());
				if(p.getLastDamageCause() == null) {
					System.out.println(e.getDeathMessage());
				}
				e.setDeathMessage("§7>>§c " + e.getDeathMessage());
				
			}
		}
	}
	
}


/**
* @author JOE_
*
* @created 19.09.2019 (18:25:03)
*/
