package de.baumirein.commands.warps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class cfg_gen {

	static File sfile = new File("plugins/LovlyCraft-Core/Warps", "homes.yml");
	static FileConfiguration locs = YamlConfiguration.loadConfiguration(sfile);
	
	public static void saveLoc(Player player, String path) throws IOException {
		Player p = player; 
		String world_pre = p.getWorld().getName();
		String world = world_pre.toLowerCase();
		Location loc = p.getLocation();
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		float yaw = loc.getYaw();
		float pitch = loc.getPitch();

		//locs.set("warps." + path, "");
		locs.set("warps." + path + ".world", world);
		locs.set("warps." + path + ".x", x);
		locs.set("warps." + path + ".y", y);
		locs.set("warps." + path + ".z", z);
		locs.set("warps." + path + ".yaw", yaw);
		locs.set("warps." + path + ".pitch", pitch);
		locs.save(sfile);
	}
	
	public static Location loadLoc(String path) throws FileNotFoundException, IOException, InvalidConfigurationException {

		locs.load(sfile);
		String w = locs.getString("warps." + path + ".world");
		double x = locs.getDouble("warps." + path + ".x");
		double y = locs.getDouble("warps." + path + ".y");
		double z = locs.getDouble("warps." + path+ ".z");
		float yaw = (float)locs.getDouble("warps." + path + ".yaw");
		float pitch = (float)locs.getDouble("warps." + path + "pitch");
		
		Location loc = new Location(Bukkit.getWorld(w), x, y, z, yaw, pitch);
		
		return loc;
		
	}
	
}


/**
* @author JOE_
*
* @created 06.05.2018 (19:04:38)
*/
