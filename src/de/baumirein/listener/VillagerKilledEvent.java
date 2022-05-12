 package de.baumirein.listener;

import org.bukkit.entity.Damageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTransformEvent;

public class VillagerKilledEvent implements Listener {
	
	private int infectionRate = 100;
	
	@EventHandler
	public void onKill(EntityTransformEvent e) {
		if (!e.getTransformReason().equals(EntityTransformEvent.TransformReason.INFECTION)) {
			System.out.println("debug1");
			return;
		}
		int random = (int)(Math.random() * 101.0D + 0.0D);
		System.out.println("debug2 " +random);
		if(random > this.infectionRate) {
			Damageable villager = (Damageable)e.getTransformedEntity();
			villager.setHealth(0.0D);
			System.out.println("debug3");
		}
	}
	
//	@EventHandler 
//	public void onEntityDamage(EntityDamageByEntityEvent e) {
//		if(e.getEntity() instanceof org.bukkit.entity.Villager) {
//			Damageable villager = (Damageable) e.getEntity();
//			World world = e.getEntity().getWorld();
//			
//			ZombieVillager vz;
//			vz.getPersistentDataContainer().set(villager.getPersistentDataContainer().getKeys(), villager.getPersistentDataContainer(), null);
//			
//			
//		}
//	}

}


/**
* @author JOE_
*
* @created 13.07.2021 (19:29:29)
*/
