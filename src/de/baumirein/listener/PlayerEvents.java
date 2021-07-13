package de.baumirein.listener;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTransformEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import de.baumireinde.api.TabListAPI;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

public class PlayerEvents implements Listener {

	// Villager to VillagerZombie infection rate
	private int infectionRate = 100;
	
	@EventHandler
	public void onDamage(FoodLevelChangeEvent e){
		e.setCancelled(false);
	}
	
	@EventHandler
	public void onWeather(WeatherChangeEvent e){
		e.setCancelled(false);
	}
	
	//Change zombie Villager spawnrate
//	@EventHandler
//	public void onVillagerDeath(EntityDamageByEntityEvent e) {
//		if(!(e.getEntity() instanceof org.bukkit.entity.Villager)) 
//			return;
//		if(e.getDamager() instanceof org.bukkit.entity.Zombie || e.getDamager() instanceof org.bukkit.entity.ZombieVillager) {
//			LivingEntity villager = (LivingEntity) e.getEntity();
//			if(villager.getHealth() <= e.getDamage()) {
//				Location loc = e.getEntity().getLocation();
//				loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE_VILLAGER);
//			}
//			return;
//		}
//	}
	
	//Turn Villager into ZOmbieVillager by a given percentage
	@EventHandler
	public void onKill(EntityTransformEvent e) {
		System.out.println("debug0");
		if (!e.getTransformReason().equals(EntityTransformEvent.TransformReason.INFECTION)) {
			return;
		}
		int random = (int)(Math.random() * 101.0D + 0.0D);
		if(random > this.infectionRate) {
			Damageable villager = (Damageable)e.getTransformedEntity();
			villager.setHealth(0.0D);
		}
	}
	
	//PlayerJoin Event
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = (Player)e.getPlayer();
		p.setHealth(20D);
		p.setMaxHealth(20.0D);
		p.sendMessage("§4ACHTUNG: §7/trade §cist buggy, Items können sich wegbuggen! Benutzen auf eigene Gefahr!");
		p.sendMessage("§cDieser bug tritt nur auf wenn mehrere Spieler gleichzeitig auf die §7Trade-Kiste §czugreifen.");
		
		
//		if(p.hasPermission("baumirein.tablist.admin")){
//			p.setPlayerListName("§7[§eA§7] §e" + e.getPlayer().getPlayerListName());
//		}else if(p.hasPermission("baumirein.tablist.manager")){
//			p.setPlayerListName("§7[§4M§7] §4" + e.getPlayer().getPlayerListName());
//		}else if(p.hasPermission("baumirein.tablist.developer")){
//			p.setPlayerListName("§7[§cD§7] §c" + e.getPlayer().getPlayerListName());
//		}else if(p.hasPermission("baumirein.tablist.content")){
//			p.setPlayerListName("§7[§1C§7] §1" + e.getPlayer().getPlayerListName());
//		}else if(p.hasPermission("baumirein.tablist.moderator")){
//			p.setPlayerListName("§7[§2M§7] §2" + e.getPlayer().getPlayerListName());
//		}else if(p.hasPermission("baumirein.tablist.supporter")){
//			p.setPlayerListName("§7[§aS§7] §a" + e.getPlayer().getPlayerListName());
//		}else if(p.hasPermission("baumirein.tablist.builder")){
//			p.setPlayerListName("§7[§9B§7] §9" + e.getPlayer().getPlayerListName());
//		}else if(p.hasPermission("baumirein.tablist.premium")){
//			p.setPlayerListName("§7[§bP§7] §b" + e.getPlayer().getPlayerListName());
//		}else if(p.hasPermission("baumirein.tablist.media")){
//			p.setPlayerListName("§7[§3M§7] §3" + e.getPlayer().getPlayerListName());
//		}else if(p.hasPermission("baumirein.tablist.mediaplus")){
//			p.setPlayerListName("§7[§5M+§7] §5" + e.getPlayer().getPlayerListName());
//		}else{
//			p.setPlayerListName("§7[§8S§7] §8" + e.getPlayer().getPlayerListName());
//		}
														 //§eAdmin §f| §4Manager §f| §cDeveloper §f| §1Content \n §2Moderator §f| §aSupporter §f| §9Builder §f| §5Media+ \n §3Media §f| §bPremium
		TabListAPI.set(e.getPlayer(), "§8§lbaumirein§7§l.de", "§ebaumirein.de \n §aDeine Kiffer zuflucht. ");
	}
	
	//PlayerCommandPreprocess Event
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlugin(PlayerCommandPreprocessEvent e){
		String args[] = e.getMessage().split(" ");
		if((args[0].equalsIgnoreCase("/pl")) || (args[0].equalsIgnoreCase("/plugins")) || (args[0].equalsIgnoreCase("/?")) || (args[0].equalsIgnoreCase("/help")) || (args[0].equalsIgnoreCase("/p")) || (args[0].equalsIgnoreCase("/ver")) || (args[0].equalsIgnoreCase("/version")) || (args[0].equalsIgnoreCase("/gc"))){
			Player p = e.getPlayer();

			TextComponent msg = new TextComponent("§eWebsite: §8§lbaumirein§7§l.de §r");
			msg.setClickEvent(new ClickEvent(Action.OPEN_URL, "http://baumirein.de"));
			@SuppressWarnings("unused")
			TextComponent Website = msg;
			
			if(p.isOp() || (p.hasPermission("baumirein.lobby.bypass"))){
				
			}else{				
				e.setCancelled(true);
				p.sendMessage("§cSystem: §eNein!");
				//p.spigot().sendMessage(" ");
			}
		}	
	}
	
}


/**
* @author JOE_
*
* @created 21.09.2019 (02:05:56)
*/
