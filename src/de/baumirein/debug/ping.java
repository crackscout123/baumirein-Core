package de.baumirein.debug;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ping implements CommandExecutor{
	
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(a.length == 0) {
			if(s instanceof Player) {
				Player p = (Player)s;
				p.sendMessage("§cMerkel: §7Dein Ping beträgt §b"+getPing(p)+"§7ms.");
			}
		}else if(a.length == 1) {
			if(Bukkit.getPlayer(a[0]) != null && Bukkit.getPlayer(a[0]).isOnline()) {
				Player target = Bukkit.getPlayer(a[0]);
				s.sendMessage("§cMerkel: §7Der Ping von §b"+target.getName()+" §7beträgt §b"+getPing(target)+"§7ms.");
			}else{
				s.sendMessage("§cMerkel: §7Der Spieler §b"+a[0]+" §7ist nicht Online.");
			}
			
		}
		return false;
	}
	

	public static int getPing(Player p){
		String v = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		try{
			Class<?> CraftPlayerClass = Class.forName("org.bukkit.craftbukkit." + v + ".entity.CraftPlayer");
			Object CraftPlayer = CraftPlayerClass.cast(p);
			Method getHandle = CraftPlayer.getClass().getMethod("getHandle", new Class[0]);
			Object EntityPlayer = getHandle.invoke(CraftPlayer, new Object[0]);
			Field ping = EntityPlayer.getClass().getDeclaredField("ping");
			return ping.getInt(EntityPlayer);
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}


	
}


/**
* @author JOE_
*
* @created 04.05.2019 (21:29:02)
*/
