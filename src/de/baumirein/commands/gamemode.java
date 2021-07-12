package de.baumirein.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemode implements CommandExecutor {

	//gamemode <0|1|2|3> [player]
	//   0		  1       2
	
	public static String syntax = "&cSyntax: &7/gamemode <0|1|2|3> [player]".replace('&', '§'); 
	public static String changed_self = "&cSystem: &7Dein Spielmodus wurde zu&c xxx &7geändert.".replace('&', '§'); 
	public static String changed = "&cSystem: &7Dein Spielmodus von&c yyy &7wurde zu&c xxx &7geändert.".replace('&', '§');
	public static String done = "&cSystem: &7Du hast den Spielmodus von&c xxx &7auf&c yyy &7gesetzt.".replace('&', '§');
	
	//null?err=2XX
	public static String gameode(GameMode gm) {
		if(gm != null) {
			if(gm == GameMode.SURVIVAL) {
				return "SURVIVAL";
			}
			if(gm == GameMode.CREATIVE) {
				return "CREATIVE";
			}
			if(gm == GameMode.ADVENTURE) {
				return "ADVENTURE";
			}
			if(gm == GameMode.SPECTATOR) {
				return "SPECTATOR";
			}
		}else {
			return "null?err=202";
		}
		return "null?err=201";
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {

		if(a.length == 1) {
			if(s instanceof Player) {
				Player p = (Player)s;
				if(p.hasPermission("baumirein.command.gm") || p.hasPermission("baumirein.command.*")) {
					if(a[0].equalsIgnoreCase("0")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(changed_self.replace("xxx", gameode(GameMode.SURVIVAL)));
					}
					if(a[0].equalsIgnoreCase("1")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(changed_self.replace("xxx", gameode(GameMode.CREATIVE)));
					}
					if(a[0].equalsIgnoreCase("2")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage(changed_self.replace("xxx", gameode(GameMode.ADVENTURE)));
					}
					if(a[0].equalsIgnoreCase("3")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage(changed_self.replace("xxx", gameode(GameMode.SPECTATOR)));
					}
				} else {

					p.sendMessage("§cSystem: §7Du hast keine Berechtigung um diesen Befehl auszuführen.");
				}

				
			}
			
		} else if(a.length == 2) {
			if(Bukkit.getPlayer(a[1]).isOnline()) {
				Player t = Bukkit.getPlayer(a[1]);
					Player p = (Player)s;
					if(p.hasPermission("baumirein.command.gm.others") || p.hasPermission("baumirein.command.*")) {
						if(s instanceof Player) {
						if(a[0].equalsIgnoreCase("0")) {
							t.setGameMode(GameMode.SURVIVAL);
							t.sendMessage(changed.replace("xxx", gameode(GameMode.SURVIVAL)).replace("yyy", p.getDisplayName()));
							p.sendMessage(done.replace("xxx", t.getDisplayName().replace("yyy", gameode(GameMode.SURVIVAL))));
						}
						if(a[0].equalsIgnoreCase("1")) {
							t.setGameMode(GameMode.CREATIVE);
							t.sendMessage(changed.replace("xxx", gameode(GameMode.CREATIVE)).replace("yyy", p.getDisplayName()));
							p.sendMessage(done.replace("xxx", t.getDisplayName().replace("yyy", gameode(GameMode.CREATIVE))));
						}
						if(a[0].equalsIgnoreCase("2")) {
							t.setGameMode(GameMode.ADVENTURE);
							t.sendMessage(changed.replace("xxx", gameode(GameMode.ADVENTURE)).replace("yyy", p.getDisplayName()));
							p.sendMessage(done.replace("xxx", t.getDisplayName()).replace("yyy", gameode(GameMode.ADVENTURE)));
						}
						if(a[0].equalsIgnoreCase("3")) {
							t.setGameMode(GameMode.SPECTATOR);
							t.sendMessage(changed.replace("xxx", gameode(GameMode.SPECTATOR)).replace("yyy", p.getDisplayName()));
							p.sendMessage(done.replace("xxx", t.getDisplayName()).replace("yyy", gameode(GameMode.SPECTATOR)));
						}
					}else {
						if(a[0].equalsIgnoreCase("0")) {
							t.setGameMode(GameMode.SURVIVAL);
							t.sendMessage(changed.replace("xxx", gameode(GameMode.SURVIVAL)).replace("yyy", "§7dem §cSystem"));
							s.sendMessage(done.replace("xxx", t.getDisplayName()).replace("yyy", gameode(GameMode.SURVIVAL)));
						}
						if(a[0].equalsIgnoreCase("1")) {
							t.setGameMode(GameMode.CREATIVE);
							t.sendMessage(changed.replace("xxx", gameode(GameMode.CREATIVE)).replace("yyy", "§7dem §cSystem"));
							s.sendMessage(done.replace("xxx", t.getDisplayName()).replace("yyy", gameode(GameMode.CREATIVE)));
						}
						if(a[0].equalsIgnoreCase("2")) {
							t.setGameMode(GameMode.ADVENTURE);
							t.sendMessage(changed.replace("xxx", gameode(GameMode.ADVENTURE)).replace("yyy", "§7dem §cSystem"));
							s.sendMessage(done.replace("xxx", t.getDisplayName()).replace("yyy", gameode(GameMode.ADVENTURE)));
						}
						if(a[0].equalsIgnoreCase("3")) {
							t.setGameMode(GameMode.SPECTATOR);
							t.sendMessage(changed.replace("xxx", gameode(GameMode.SPECTATOR)).replace("yyy", "§7dem §cSystem"));
							s.sendMessage(done.replace("xxx", t.getDisplayName()).replace("yyy", gameode(GameMode.SPECTATOR)));
						}
					}
				} else {
					p.sendMessage("§cSystem: §7Du hast keine Berechtigung um diesen Befehl auszuführen.");
				}
			}

		} else {
			
			s.sendMessage(syntax);
			
			
		}
		
			
			
		return false;
	}

}


/**
* @author JOE_
*
* @created 19.09.2019 (19:03:11)
*/
