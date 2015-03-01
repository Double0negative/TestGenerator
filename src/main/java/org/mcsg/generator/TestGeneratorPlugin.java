package org.mcsg.generator;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class TestGeneratorPlugin extends JavaPlugin implements Listener{

	static Set<String> set = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());

	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return new TestGenerator();
	}
	
	
	
	@EventHandler
	public void load(ChunkPopulateEvent e){
		Chunk chunk = e.getChunk();
		
		boolean b = set.remove(chunk.getX() +":"+chunk.getZ());
		
		
		if(!b){
			System.out.println("Failed to populate"+ chunk.getX() +":"+chunk.getZ()+"..");
			
			set.remove(chunk.getX() +":"+chunk.getZ());
			
		}
		
	}
}
