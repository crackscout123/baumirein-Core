package de.baumirein.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class repair implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command c, String l, String[] a) {
		
		if(cs instanceof Player) {
			if(a.length == 0) {
				Player p = (Player)cs;
				if(!p.hasPermission("baumirein.command.repair") || p.hasPermission("baumirein.command.*")) {
					repairAll(p);
				} else {
					cs.sendMessage("§cSystem: §7Du hast keine Berechtigung um diesen Befehl auszuführen.");
				}
			} else if(a.length == 1){
				if(cs instanceof Player) {
					Player p = (Player)cs;
					if(!p.hasPermission("baumirein.command.repair.others") || p.hasPermission("baumirein.command.*")) {
						if(Bukkit.getPlayer(a[0]).isOnline()) {
							repairAll(Bukkit.getPlayer(a[0]));
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
				p.sendMessage("§cSyntax: §7/fix");
			}
		} else {
			cs.sendMessage("§cSystem: §7Du musst ein Spieler sein um diesen Befehl auszuführen.");
		}
		
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public void repairAll(Player p) {


	        List<ItemStack> repairQueue = new ArrayList<>();

	        for (ItemStack stack : p.getInventory().getContents()) {
	            if (stack != null && !stack.getType().isBlock() && stack.getDurability() != 0) {
	                repairQueue.add(stack);
	            }
	        }

	        if (repairQueue.isEmpty()) {
	            return;
	        }

	        for (ItemStack stack : repairQueue) stack.setDurability((short) 0);

	        p.updateInventory();
	    }
		
}


/**
* @author JOE_
*
* @created 29.09.2019 (01:06:00)
*/
