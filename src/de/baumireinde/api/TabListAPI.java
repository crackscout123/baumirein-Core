/**
 * 
 */
package de.baumireinde.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * @author Jooooel
 *
 * @date 28.05.2017 (21:04:54)
 *
 */
public class TabListAPI {
	
	public static boolean maintanance = true;
	
	public static Class<?> getNmsClass(String nmsClassName) throws ClassNotFoundException {
		return Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + nmsClassName);
	}

	
	public static void set(Player p, String header, String footer){
		if(maintanance) { return; }
		try {
			Object tabheader = getNmsClass("IChatBaseComponent.ChatSerializer").getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{'text': '" + header + "'}" });
	        Object tabfooter = getNmsClass("IChatBaseComponent.ChatSerializer").getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{'text': '" + footer + "'}" });
	        
	        Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[] { getNmsClass("IChatBaseComponent") }).newInstance(new Object[] { tabheader });
	        
	        Field f = ppoplhf.getClass().getDeclaredField("b");
	        f.setAccessible(true);
	        f.set(ppoplhf, tabfooter);
	        
	        Object nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);
	        Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);
	        
	        pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppoplhf });
	        
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException | InstantiationException | NoSuchFieldException e) {
			Bukkit.getConsoleSender().sendMessage("§cERROR: §8[§bbaumirein.de§8] §7Die Tabliste konnte nicht geladen werden! \n Fehlermeldung:");
			e.printStackTrace();
		}
				
	}
	
	public static void load(Player p, String header, String footer){
		set(p, header, footer);
	}
}
