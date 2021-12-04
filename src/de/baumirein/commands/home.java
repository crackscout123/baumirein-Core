package de.baumirein.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import de.baumirein.commands.warps.cfg_gen;

public class home implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			if(a.length == 0) {
				Player p = (Player)s;
				try {
					p.teleport(cfg_gen.loadLoc(p.getName()));
					p.sendMessage("§cMerkel: §7Du wurdest zu deinem §cHome §7gebracht.");
				} catch (IOException | InvalidConfigurationException e) {
					System.out.println("something went wrong!");
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
* @created 28.06.2021 (23:00:44)
*/
