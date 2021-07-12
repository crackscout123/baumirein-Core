package de.baumirein.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class onExplode implements Listener {

	@EventHandler
	public void onCreeperPrime(EntityExplodeEvent e) {
		if(e.getEntityType() == EntityType.CREEPER) {
			e.setCancelled(true);
		}
	}
	
//	public void onEntityDamage(EntityDamageByBlockEvent e) {
//		if(e.getEntity() == null && e.getCause() == DamageCause.BLOCK_EXPLOSION) {
//			if(troll.enexev == false) {
//				e.setDamage(0D);
//			}
//		}
//	}
	
		//comming soon!
}


/**
* @author JOE_
*
* @created 19.09.2019 (19:39:24)
*/
