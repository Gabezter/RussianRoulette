package main.java.com.texasgamer.russianroulette;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.util.config.Configuration;

public class Config 
{
	private static RussianRoulette plugin;
	public static final Logger logger = Logger.getLogger("Minecraft.RussianRoulette");
	public Config(RussianRoulette instance) 
	{
		plugin = instance;
	}

	public static String directory = "plugins" + File.separator +"RussianRoulette";
	static File file = new File(directory + File.separator + "config.yml");
	
	public void configCheck(){
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
	private void write(String root, Object x){
		Configuration config = load();
		config.setProperty(root, x);
		config.save();
	}
	public static Boolean readBoolean(String root){
		Configuration config = load();
		return config.getBoolean(root, true);
	}
	static Double readDouble(String root){
		Configuration config = load();
		return config.getDouble(root, 0);
	}
	private List<String> readStringList(String root){
		Configuration config = load();
		return config.getKeys(root);
	}
	public static String readString(String root){
		Configuration config = load();
		return config.getString(root);
	}
	private static Configuration load(){
		try {
			Configuration config = new Configuration(file);
			config.load();
			return config;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private void addDefaults(){
		logger.info("RussianRoulette: Generating Config File...");
		write("ignore-ops",true);
		write("target-across-worlds",true);
	}
}