package com.texasgamer.russianroulette;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

public class Config 
{
	
	private static RussianRoulette plugin;
	public static final Logger logger = Logger.getLogger("Minecraft");
	
	public Config(RussianRoulette instance) {
		plugin = instance;
	}
	
	public static String directory = "plugins" + File.separator +"RussianRoulette";
	static File file = new File(directory + File.separator + "config.yml");
	
	public void configCheck() {
		new File(directory).mkdir();
		if(!file.exists()){
			try {
				file.createNewFile();
				addDefaults();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
		}
	}
	
	public void addDefaults() {
		logger.info("Bedtime: Generating config file...");
		
		plugin.getConfig().options().copyDefaults(true);
		
		String idleTime = "ignore-ops";
		String idleCommand = "target-across-worlds";
		
		plugin.getConfig().addDefault(idleTime, true);
		plugin.getConfig().addDefault(idleCommand, true);
		plugin.saveConfig();
	}
	
	public static Boolean readBoolean(String root){
		return plugin.getConfig().getBoolean(root);
	}
	
	public static Double readDouble(String root){
		return plugin.getConfig().getDouble(root);
	}
	
	public static int readInt(String root) {
		return plugin.getConfig().getInt(root);
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> readList(String root){
		return (List<String>) plugin.getConfig().getList(root);
	}
	
	public static String readString(String root){
		return plugin.getConfig().getString(root);
	}
}