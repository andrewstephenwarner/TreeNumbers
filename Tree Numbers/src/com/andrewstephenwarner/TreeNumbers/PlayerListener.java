package com.andrewstephenwarner.TreeNumbers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Tree;

public class PlayerListener implements Listener {
	
	static TreeNumbers plugin;
	
	public PlayerListener(TreeNumbers iawwh){
		plugin = i;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		
		if (event.getBlock().getType() == Material.LOG) {
			
			Tree log = (Tree) event.getBlock().getState().getData();
			
            if (log.getSpecies() == TreeSpecies.GENERIC) {
            	
    			Location location = event.getBlock().getLocation();
    			event.getBlock().getWorld().dropItem(location, new ItemStack(Material.LOG, plugin.getConfig().getInt("logs"), (short)0));
            }
            
            if (log.getSpecies() == TreeSpecies.BIRCH) {
            	
    			Location location = event.getBlock().getLocation();
    			event.getBlock().getWorld().dropItem(location, new ItemStack(Material.LOG, plugin.getConfig().getInt("logs"), (short)2));
            }

		}
	}
}
