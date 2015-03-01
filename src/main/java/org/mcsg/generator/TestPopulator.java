package org.mcsg.generator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class TestPopulator extends BlockPopulator{

	@Override
	public void populate(World arg0, Random arg1, Chunk chunk) {
		try{
			TestGeneratorPlugin.set.add(chunk.getX()+": "+chunk.getZ());
		} catch (Exception e){
			e.printStackTrace(); //To be sure no exceptions are being throw
		}
	}

}
