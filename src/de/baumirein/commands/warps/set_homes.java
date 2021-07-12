package de.baumirein.commands.warps;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class set_homes implements CommandExecutor{


	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
			if(s instanceof Player) {
				Player p = (Player)s;
				if(a.length == 1) {
					String path = a[0];
					try {
						cfg_gen.saveLoc(p, path.toLowerCase());
						Bukkit.broadcastMessage("§cMerkel: §7Neuer Ort hinzugefügt. §8- §7/go " + path);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		return false;
	}

}


/**
* @author JOE_
*
* @created 04.05.2019 (17:44:30)
*/
