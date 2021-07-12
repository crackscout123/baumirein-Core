package de.baumirein.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class enderchest implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender cs, Command c, String l, String[] a) {
		
		if(cs instanceof Player) {
			if(a.length == 0) {
				Player p = (Player)cs;
				if(!p.hasPermission("baumirein.command.enderchest") || p.hasPermission("baumirein.command.*")) {
					p.openInventory(p.getEnderChest());
				} else {

					cs.sendMessage("§cSystem: §7Du hast keine Berechtigung um diesen Befehl auszuführen.");
				}
			} else if(a.length == 1){
				if(cs instanceof Player) {
					Player p = (Player)cs;
					if(p.hasPermission("baumirein.command.enderchest.others") || p.hasPermission("baumirein.command.*")) {
						if(Bukkit.getPlayer(a[0]).isOnline()) {
							p.openInventory(Bukkit.getPlayer(a[0]).getEnderChest());
						}else {
							p.sendMessage("§cPlayer not found!");
						}
					} else {
						p.sendMessage("§cSystem: §7Du hast keine Berechtigung um diesen Befehl auszuführen.");
					}
				} else {
					cs.sendMessage("§cSystem: §7Du musst ein Spieler sein um diesen Befehl auszuführen.");
				}
				
			} else {
				Player p = (Player)cs;
				p.sendMessage("§cSyntax: §7/ec");
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
* @created 29.09.2019 (00:58:23)
*/
