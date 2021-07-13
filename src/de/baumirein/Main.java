package de.baumirein;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.baumirein.commands.cmd_invsee;
import de.baumirein.commands.cmd_tpa;
import de.baumirein.commands.cmd_tpd;
import de.baumirein.commands.cmd_tpr;
import de.baumirein.commands.cmd_trade;
import de.baumirein.commands.craft;
import de.baumirein.commands.enderchest;
import de.baumirein.commands.fly;
import de.baumirein.commands.gamemode;
import de.baumirein.commands.heal;
import de.baumirein.commands.home;
import de.baumirein.commands.sethome;
import de.baumirein.commands.troll;
import de.baumirein.commands.vanish;
import de.baumirein.commands.warps.go_homes;
import de.baumirein.commands.warps.set_homes;
import de.baumirein.commands.warps.warps;
import de.baumirein.debug.ping;
import de.baumirein.listener.PlayerEvents;
import de.baumirein.listener.VillagerKilledEvent;
import de.baumirein.listener.onDeath;
import de.baumirein.listener.onExplode;

public class Main extends JavaPlugin implements Listener{
	

	public static HashMap<Player, Player> tpa = new HashMap<Player, Player>();

    
	@Override
	public void onEnable() {
		getCommand("invsee").setExecutor(new cmd_invsee());
		getCommand("trade").setExecutor(new cmd_trade());
		getCommand("tpd").setExecutor(new cmd_tpd());
		getCommand("tpa").setExecutor(new cmd_tpa());
		getCommand("tpr").setExecutor(new cmd_tpr());
		getCommand("home").setExecutor(new home());
		getCommand("sethome").setExecutor(new sethome());
		getCommand("go").setExecutor(new go_homes());
		getCommand("set").setExecutor(new set_homes());
		getCommand("troll").setExecutor(new troll());
		getCommand("warps").setExecutor(new warps());
		getCommand("ping").setExecutor(new ping());
		getCommand("heal").setExecutor(new heal());
		getCommand("gamemode").setExecutor(new gamemode());
		getCommand("fly").setExecutor(new fly());
		getCommand("vanish").setExecutor(new vanish());
		getCommand("craft").setExecutor(new craft());
		getCommand("enderchest").setExecutor(new enderchest());
		Bukkit.getPluginManager().registerEvents(new onDeath(), this);
		//Bukkit.getPluginManager().registerEvents(new onJoin(), this);
		Bukkit.getPluginManager().registerEvents(new cmd_trade(), this);
		Bukkit.getPluginManager().registerEvents(new onExplode(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
		Bukkit.getPluginManager().registerEvents(new VillagerKilledEvent(), this);
	}
	
	@Override
	public void onDisable() {
	
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(a.length == 0) {
			if(s instanceof Player) {
				//Player p = (Player)s;
				
				if(c.getName().equalsIgnoreCase("sun")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "time set day");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "weather clear 999999");
				}
				
			}
		}
		return true;
	}
	

	


}


/**
* @author JOE_
*
* @created 04.05.2019 (17:11:29)
*/
