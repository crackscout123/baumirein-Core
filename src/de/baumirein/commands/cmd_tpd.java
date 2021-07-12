package de.baumirein.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.baumirein.Main;

public class cmd_tpd implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if(Main.tpa.containsKey(p)) {
				Player t = Main.tpa.get(p);
				p.sendMessage("§cMerkel: §7Die Teleportanfrage von §c" + t.getDisplayName() + " §7wurde entfernt.");
				Main.tpa.remove(p);
				t.sendMessage("§cMerkel: §7Die Teleportanfrage an §c" + p.getDisplayName() + " §7wurde abgelehnt.");
			}
		}
		
		return false;
	}


	
}





/**
* @author JOE_
*
* @created 08.07.2021 (06:24:14)
*/
