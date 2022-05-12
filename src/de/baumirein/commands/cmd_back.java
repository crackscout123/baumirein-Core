package de.baumirein.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.baumirein.Main;

public class cmd_back implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if (a.length == 0){
				if(Main.lastLocation.containsKey(p)) {
					p.teleport(Main.lastLocation.get(p));
					p.sendMessage("§cMerkel: §7Du wurdest Teleportiert.");
				} else {
					p.sendMessage("§cNullPointerExeption: lastLocation is empty for §c" + p.getName());
				}
			} else {
				p.sendMessage("§cMerkel: §7/back");
			}
		}
		return false;
	}

}


/**
* @author JOE_
*
* @created 05.05.2022 (22:39:59)
*/
