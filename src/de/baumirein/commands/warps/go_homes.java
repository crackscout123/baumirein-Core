package de.baumirein.commands.warps;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

public class go_homes implements CommandExecutor{


	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
			if(s instanceof Player) {
				Player p = (Player)s;
				if(a.length == 1) {
					String path = a[0];
					try {
						p.teleport(cfg_gen.loadLoc(path.toLowerCase()));
						p.sendMessage("§cMerkel: §7Du wurdest zu §b"+path+" §7gebracht.");
					} catch (IOException | InvalidConfigurationException e) {
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
* @created 04.05.2019 (18:14:45)
*/
