package de.baumirein.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
			if(s instanceof Player) {
				Player p = (Player)s;
				if(a.length == 0) {
					if(!p.hasPermission("baumirein.command.fly") || p.hasPermission("baumirein.command.*")) {
						if(p.getAllowFlight()) {
							p.setFlying(false);
							p.setAllowFlight(false);
							p.sendMessage("§cSystem: §7Fliegen wurde deaktiviert.");
						}else {
							p.setAllowFlight(true);
							p.setFlying(true);
							p.setFlySpeed(0.1F);
							p.sendMessage("§cSystem: §7Fliegen wurde aktiviert.");
						}
					}else {
						p.sendMessage("§cSystem: §7Du hast keine Berechtigung um diesen Befehel auszuführen.");
					}
				}else {
					s.sendMessage("§cSyntax: §7/fly");
				}
			}else {
				s.sendMessage("§cSystem: §7Du musst ein Spieler sein um diesen Befehl auszuführen.");
			}
		return false;
	}
	
}


/**
* @author JOE_
*
* @created 19.09.2019 (19:54:33)
*/
