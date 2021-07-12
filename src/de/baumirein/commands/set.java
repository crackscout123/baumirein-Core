package de.baumirein.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.baumirein.commands.warps.cfg_gen;

public class set implements CommandExecutor{
	
	
	//set spawn
	//set <xxxx <xxxx
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if(p.hasPermission("baumirein.command.set") || p.hasPermission("baumirein.command.*")) {
				if(a[0].equalsIgnoreCase("spawn")){
					try { //save location
						cfg_gen.saveLoc(p, "spawn");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		
		}
		return false;
	}
}

/**
* @author JOE_
*
* @created 26.06.2021 (18:45:07)
*/
