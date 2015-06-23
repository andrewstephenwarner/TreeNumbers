package com.andrewstephenwarner.TreeNumbers;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TreeNumbers extends JavaPlugin implements Listener {
	public void onEnable() {
		new PlayerListener(this);
		
		Bukkit.getServer().getPluginManager().registerEvents( new PlayerListener(this), this);
		
		File file = new File(getDataFolder() + File.separator + "config.yml");
		
		if (!file.exists()) {
			this.getLogger().info("Generating config.yml...");
			
			this.getConfig().addDefault("logs", 3);
			this.getConfig().options().copyDefaults(true);
			this.saveConfig();
		}
	}

}
