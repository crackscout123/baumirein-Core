package de.baumirein.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class onTimber implements Listener {
	
	// define all valid blocks
	public static HashSet<String> validLogMaterials = new HashSet<>(Arrays.asList(new String[] { "LOG", "LOG_2", "LEGACY_LOG", 
	      "LEGACY_LOG_2", "ACACIA_LOG", "BIRCH_LOG", "DARK_OAK_LOG", "JUNGLE_LOG", "OAK_LOG", "SPRUCE_LOG" }));
	  
	// define all valid tools
	public static HashSet<String> validAxeMaterials = new HashSet<>(Arrays.asList(new String[] { "DIAMOND_AXE", "GOLDEN_AXE", 
	      "IRON_AXE", "STONE_AXE", "WOODEN_AXE", "GOLD_AXE", "WOOD_AXE", "NETHERITE_AXE" }));
	  
	public static HashSet<Material> logMaterials = new HashSet<>();
	public static HashSet<Material> axeMaterials = new HashSet<>();
	
	public static ArrayList<Player> disabled = new ArrayList<>();
	  
	
    public static void initTimberHashSet() {
		byte b;
		int i;
		Material[] arrayOfMaterial;
		for (i = (arrayOfMaterial = Material.values()).length, b = 0; b < i; ) {
			Material material = arrayOfMaterial[b];
			if (validLogMaterials.contains(material.name())) 
				logMaterials.add(material); 
			if (validAxeMaterials.contains(material.name())) 
				axeMaterials.add(material); 
		b++;
		} 
		Bukkit.getLogger().log(Level.INFO, "Timber Log Materials: " + logMaterials.toString());
		Bukkit.getLogger().log(Level.INFO, "Timber Axe Materials: " + axeMaterials.toString());
    }
    

    @SuppressWarnings("deprecation")
	private void cutTree(Location loc, ItemStack handItem) {
    	LinkedList<Block> blocks = new LinkedList<>();
    	for(int i = loc.getBlockY(); i < loc.getWorld().getHighestBlockYAt(loc.getBlockX(), loc.getBlockZ()); ) {
    		Location target = loc.add(0.0D, 1.0D, 0.0D);
    		Block block = target.getBlock();
    		if(logMaterials.contains(block.getType())) {
    			blocks.add(target.getBlock());
    			target = null;
    			i++;
    			continue;
    		}
    		break;
    	}
    	for(Block block : blocks ) {
    		if(block.breakNaturally(handItem)) {
    			handItem.setDurability((short)(handItem.getDurability() + 1));
    			if(handItem.getType().getMaxDurability() == handItem.getDurability()) {
    				handItem.setType(Material.AIR);
    				return;
    			}
    		}
    	}
    	blocks = null;
    	
    }
    

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.MONITOR)
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(!p.isSneaking() && (!disabled.contains(p))) {
			ItemStack handItem = p.getItemInHand();
			if(axeMaterials.contains(handItem.getType())) {
				Block block = e.getBlock();
				if(logMaterials.contains(block.getType())) {
					cutTree(block.getLocation(), (p.getGameMode() == GameMode.CREATIVE) ? handItem.clone() : handItem);
				}
			}
			
		}
	}
	

}


/**
* @author JOE_
*
* @created 05.05.2022 (21:34:12)
*/
