package de.baumirein.commands;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class cmd_trade implements CommandExecutor, Listener{

	
	public static Inventory inv;
	

	static File ifile = new File("plugins/LovlyCraft-Core/Chest", "tradechest.yml");
	static FileConfiguration icfg = YamlConfiguration.loadConfiguration(ifile);
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		inv = Bukkit.createInventory((InventoryHolder) Bukkit.getOfflinePlayer("Notch"), 45, "§bTRADECHEST"); 
		if(s instanceof Player) {
			Player p = (Player)s;
			if (a.length == 0){
				open(p, inv);
			}else {
				//save(p.getInventory());
				p.sendMessage("§cMerkel: §7/trade");
			}
		}
		return false;
	}

	  
    public static void save(Inventory inv) {
        icfg.set("inventory.content", inv.getContents());
        try {
			icfg.save(ifile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    @SuppressWarnings("unchecked")
	public static void open(Player p, Inventory inv) {
    	try {
			icfg.load(ifile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
        ItemStack[] content = ((List<ItemStack>) icfg.get("inventory.content")).toArray(new ItemStack[0]);
        inv.setContents(content);
	    p.openInventory(inv);
    }
    
    
	@EventHandler
    public static void closeInv(InventoryCloseEvent e) {
    	if(e.getView().getTitle().equals("§bTRADECHEST")){
			cmd_trade.save(inv);
    	}
    	
    }
	
	@EventHandler
	public static void putInventory(InventoryMoveItemEvent e) {
		
		if(e.getDestination().getType().equals(InventoryType.PLAYER)){
			//Inventory p_inv = e.getDestination();
			Inventory trade = e.getSource();
			if(e.getDestination() == inv) {
				save(trade);
				System.out.println("saved!");
			}			
			
		}
		
	}
	
//	@EventHandler
//	public static void itemMove(InventoryClickEvent e) {
//
//		Inventory target = e.getClickedInventory();
//    	if(e.getView().getTitle().equals("§bTRADECHEST")){
//    		if(e.getClickedInventory().getType() == InventoryType.CHEST) {
//    			System.out.println("dd");
//    			ItemStack clicked = e.getCurrentItem();
//    			
//    		}
//    	}
//		
//		
//	}
}


/**
* @author JOE_
*
* @created 08.07.2021 (10:33:08)
*/
