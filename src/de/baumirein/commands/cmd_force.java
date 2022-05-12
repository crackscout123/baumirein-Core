package de.baumirein.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmd_force implements CommandExecutor{
	 
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if (p.isOp() || p.hasPermission("baumirein.admin.force")) {
				if(a.length == 0) {
					p.sendMessage("§cSystem: §7/force <player> <content>");
				}
				
				Player target = Bukkit.getPlayer(a[0]);
				if(target != null && target.isOnline()) {
					String content = "";
					for(int i = 1; i < a.length; i++) {
						content += a[i] + " ";
					}
					content = content.trim();
					if(content.startsWith("/")) {
						content = content.replaceFirst("/", "");
						target.performCommand(content);
						p.sendMessage("§cSystem: §7Forced §c" + target.getName() + " §7to perform: §c''/"+ content +"''§7.");
					} else {
						target.chat(content);
						p.sendMessage("§cSystem: §7Forced §c" + target.getName() + " §7to say: §c''"+ content +"''§7.");
					}
					
				} else {
					p.sendMessage("§cSystem: §7/force <player> <content>");
				}
						
			
				
			}
			
		}
		return false;
	}

}


/**
* @author JOE_
*
* @created 05.05.2022 (23:06:43)
*/
