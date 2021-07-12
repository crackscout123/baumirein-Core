package de.baumirein.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.baumirein.Main;

public class cmd_tpa implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if(Main.tpa.containsKey(p)) {
			Player t = Main.tpa.get(p);
				if(t.isOnline()) {
					t.teleport(p.getLocation());
					t.sendMessage("§cMerkel: §7Du wurdest zu §c"+ p.getDisplayName() +"§7 gebracht.");
					Main.tpa.remove(p);
				} else {
					p.sendMessage("§cMerkel: §7Der Spieler §c" + t.getDisplayName() + " §7wurde nicht gefunden.");
				}
			} else {
				p.sendMessage("§cMerkel: §7Keine Anfrage gefunden.");
			}
		}
		return false;
	}
	
}


/**
* @author JOE_
*
* @created 08.07.2021 (06:00:40)
*/
