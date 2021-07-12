package de.baumirein.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmd_invsee implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if(p.hasPermission("baumirein.command.invesee")) {
				if(a.length == 1) {
					Player t = Bukkit.getPlayer(a[0]);
					p.openInventory(t.getInventory());
				}				
			}
		}else {
			System.out.println("You need to be a player!");
		}
		return false;
	}

}


/**
* @author JOE_
*
* @created 11.07.2021 (17:52:17)
*/
