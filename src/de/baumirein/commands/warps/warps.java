package de.baumirein.commands.warps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class warps implements CommandExecutor{


	static File sfile = new File("plugins/LovlyCraft-Core/Warps", "homes.yml");
	static FileConfiguration locs = YamlConfiguration.loadConfiguration(sfile);
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if(a.length == 0) {
				try {
					locs.load(sfile);
					p.sendMessage("§cMerkel: §7Verfügbare Warp-Punkte: ");
					List<String> team = new ArrayList<String>();
					for (String x : locs.getConfigurationSection("warps").getKeys(false)) {
					  team.add(x);
					}
					String message = team.toString();
					message = message.replace("[", "");
					message = message.replace("]", "");
					p.sendMessage("§cMerkel: §b"+message);
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
* @created 05.05.2019 (15:38:34)
*/
