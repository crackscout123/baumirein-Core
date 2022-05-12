package de.baumirein.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.baumirein.ActionBar.ActionBarAPI;

public class vanish implements CommandExecutor {

	public static ArrayList<Player> vanished = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
			if(s instanceof Player) {
				final Player p = (Player)s;
				if(a.length == 0  && p.isOp()) {
						if(vanished.contains(p)) {
							for(Player team : Bukkit.getServer().getOnlinePlayers()) {
								team.showPlayer(p);
								vanished.remove(p);
								p.setGameMode(GameMode.SURVIVAL);
							}
							p.sendMessage("§cSystem: §7Du befindest dich nicht mehr im §cVanish§7.");
						}else {
							for(Player team : Bukkit.getOnlinePlayers()) {
								team.hidePlayer(p);
								vanished.add(p);
								p.setGameMode(GameMode.SPECTATOR);
							}
							p.sendMessage("§cSystem: §7Du befindest dich nun im §cVanish§7.");
						}
						
					}
			}
		return false;
	}
	
	
	public void actionBar(Player player, String message, int duration) { ActionBarAPI.sendActionBar(player, message.replace("&", "§"), duration); }
}


/**
* @author JOE_
*
* @created 19.09.2019 (19:54:11)
*/
