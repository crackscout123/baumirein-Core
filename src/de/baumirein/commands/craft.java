package de.baumirein.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class craft implements CommandExecutor{
	
	

	@Override
	public boolean onCommand(CommandSender cs, Command c, String l, String[] a) {
		
		if(cs instanceof Player) {
			if(a.length == 0) {
				Player p = (Player)cs;
				if(!p.hasPermission("baumirein.command.craft") || p.hasPermission("baumirein.command.*")) {
	                p.openWorkbench(null, true);
				} else {

					cs.sendMessage("§cSystem: §7Du hast keine Berechtigung um diesen Befehl auszuführen.");
				}
				
			} else {
				Player p = (Player)cs;
				p.sendMessage("§cSyntax: §7/craft");
			}
		} else {
			cs.sendMessage("§cSystem: §7Du musst ein Spieler sein um diesen Befehl auszuführen.");
		}
		
		return false;
	}

	
	
}


/**
* @author JOE_
*
* @created 29.09.2019 (00:37:32)
*/
