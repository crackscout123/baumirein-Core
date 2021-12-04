package de.baumirein.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.baumirein.Main;

public class cmd_tpr implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			Player p = (Player)s;
			Player t = Bukkit.getPlayer(a[0]);
			if(Bukkit.getPlayer(a[0]) != null) {
				if(t.isOnline()) {
					Main.tpa.put(t,p);
					//putting p (command executer as value and & p [player] as key)
					p.sendMessage("§cMerkel: §7Teleportanfrage an §c" + t.getDisplayName()+ " §7wurde gesendet.");
					t.sendMessage("§cMerkel: §7Teleportanfrage von §c" + p.getDisplayName()+ " §7will zu dir §c/tpa §7zum annehmen & §c/tpd §7zum ablehnen.");
				} else {
					p.sendMessage("§cMerkel: §7Der Spieler §c" + a[0] + " §7wurde nicht gefunden.");
				}
			
			} else {
				p.sendMessage("§cMerkel: §7Der Spieler §c" + a[0] + " §7wurde nicht gefunden.");
			}
		}
		return false;
	}

}


/**
* @author JOE_
*
* @created 08.07.2021 (06:08:51)
*/
