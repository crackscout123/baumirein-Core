package de.baumirein.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.baumirein.commands.warps.cfg_gen;

public class sethome implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if(a.length == 0) {
				try {
					cfg_gen.saveLoc(p, p.getName());
					p.sendMessage("§cMerkel: §7Home erfolgreich gesetzt.");
				} catch (IOException e) {
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
* @created 28.06.2021 (23:01:24)
*/
