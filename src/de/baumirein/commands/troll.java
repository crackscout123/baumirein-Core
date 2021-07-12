package de.baumirein.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class troll implements CommandExecutor{
	
	public static HashMap<Player, Boolean> trolls = new HashMap<>();
	public static boolean enexev = false;
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {

		if(s.hasPermission("baumirein.core.troll")) {
			if(s instanceof Player) {
				Player p = (Player)s;
				if(enexev == false && !trolls.containsKey(p)) {
					p.sendMessage("§cSystem: §eTrollmdous aktiviert!");
					enexev = true;
					trolls.put(p, enexev);
				}else {
					p.sendMessage("§cSystem: §eTrollmdous deaktiviert!");
					enexev = false;
					trolls.remove(p);
				}
				
			} else {
				s.sendMessage("§cYou have to be a player in order to execute this command.");
			}
		}
		
		
		return false;
	}

}


/**
* @author JOE_
*
* @created 19.09.2019 (19:32:36)
*/
