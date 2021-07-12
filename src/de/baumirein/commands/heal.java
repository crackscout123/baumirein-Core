/**
 * 
 */
package de.baumirein.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class heal implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if(a.length == 1) {
				Player target = Bukkit.getPlayer(a[0]);
				if(p.hasPermission("baumirein.command.heal.others") || p.hasPermission("baumirein.command.*")) {
					if (target.isOnline()) {
						target.setHealth(20.0D);
						target.setFoodLevel(20);
						p.sendMessage("§cMerkel: §7Das Vaterland hat dich geheilt!.");
					}
				} else {

					p.sendMessage("§cSystem: §7Du hast keine Berechtigung um diesen Befehl auszuführen.");
				}
			}else{
				
				if(p.hasPermission("baumirein.command.heal") || p.hasPermission("baumirein.command.*")) {
					p.setHealth(20.0D);
					p.setFoodLevel(20);
					p.sendMessage("§cMerkel: §7Das Vaterland hat dich geheilt!.");
				} else {
					p.sendMessage("§cSystem: §7Du hast keine Berechtigung um diesen Befehl auszuführen.");
				}
			}
				
		}
		
		return false;
	}

}


/**
* @author JOE_
*
* @created 14.09.2019 (00:12:57)
*/
