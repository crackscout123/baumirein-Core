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
		System.out.println("debug2");
		if(random > this.infectionRate) {
			Damageable villager = (Damageable)e.getTransformedEntity();
			villager.setHealth(0.0D);
			System.out.println("debug3");
		}
	}

}


/**
* @author JOE_
*
* @created 13.07.2021 (19:29:29)
*/
