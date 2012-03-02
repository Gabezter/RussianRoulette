package com.texasgamer.russianroulette;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.texasgamer.russianroulette.hooks.RussianRouletteMetrics;

public class RussianRoulette extends JavaPlugin{
	
	public static final Logger logger = Logger.getLogger("Minecraft");
	private Config config = new Config(this);
	private RussianRouletteStats stats;
	
	public void onEnable()
	{
		stats = new RussianRouletteStats();
		RussianRouletteMetrics.setupMetrics(this, stats);
		config.configCheck();
		logger.info("[RussianRoulette] " + getDescription().getName() + " " + getDescription().getVersion() + " enabled");
	}

	public void onDisable()
	{
	    logger.info("[RussianRoulette] " + getDescription().getName() + " " + getDescription().getVersion() + " disabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(commandLabel.equalsIgnoreCase("roulette"))
		{
			sender.sendMessage(ChatColor.LIGHT_PURPLE + getDescription().getName() + " " + getDescription().getVersion());
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "http://www.texasgamer.co.cc");
			return true;
		}
		
		if(commandLabel.equalsIgnoreCase("rr"))
		{
			if (sender.hasPermission("roulette.rr") || sender.isOp()) {
				int count = 0;
				int numPlayers = sender.getServer().getOnlinePlayers().length;
				Random chooser = new Random();
				int whoToKick = chooser.nextInt(numPlayers);
				
				for (Player p : sender.getServer().getOnlinePlayers()) {
					boolean ignore = false;
					
					if(Config.readBoolean("ignore-ops") && p.isOp())
					{
						ignore = true;
					}
					if(Config.readBoolean("target-across-worlds") && ((Player) sender).getWorld() != p.getWorld())
					{
						ignore = true;
					}
					if(p.hasPermission("roulette.safe"))
					{
						ignore = true;
					}
				
						
					if(count == whoToKick && ignore == false)
					{
						p.sendMessage(ChatColor.YELLOW + ((Player) sender).getDisplayName() + " hands you a gun...");
						p.kickPlayer("You were killed!");							
						count++;
						ignore = false;
						stats.increaseRevolvers();
					}
					else
					{
						p.sendMessage(ChatColor.YELLOW + ((Player) sender).getDisplayName() + " hands you a gun...");
						p.sendMessage(ChatColor.YELLOW + "*click*");
						count++;
						ignore = false;
					}
						
						
				    }
					return true;
				}
				else
				{	
					error("You don't have permission!", sender);
					return true;
				}
		}
		
		if(commandLabel.equalsIgnoreCase("moab") || sender.isOp())
		{
			if (sender.hasPermission("roulette.moab")) {
				int count = 0;
				int numPlayers = sender.getServer().getOnlinePlayers().length;
				Random chooser = new Random();
				int whoToKick = chooser.nextInt(numPlayers);
				
				for (Player p : sender.getServer().getOnlinePlayers()) {
					boolean ignore = false;
					
					if(Config.readBoolean("ignore-ops") && p.isOp())
					{
						ignore = true;
					}
					if(Config.readBoolean("target-across-worlds") && ((Player) sender).getWorld() != p.getWorld())
					{
						ignore = true;
					}
					if(p.hasPermission("roulette.safe"))
					{
						ignore = true;
					}
					
					
					if(count == whoToKick && ignore == false)
					{
						p.sendMessage(ChatColor.YELLOW + "The sky darkens...");
						p.kickPlayer("You were killed!");
						count++;
						ignore = false;
						stats.increaseMOABS();
					}
					else
					{
						p.sendMessage(ChatColor.YELLOW + "The sky darkens...");
						p.sendMessage(ChatColor.YELLOW + "*thud*");
						count++;
						ignore = false;
					}
										
				    }
					return true;
				}
				else
				{	
					error("You don't have permission!", sender);
					return true;
				}
			}
		
		if(commandLabel.equalsIgnoreCase("nuke"))
		{
			if (sender.hasPermission("roulette.nuke") || sender.isOp()) {
				int count = 0;
				int numPlayers = sender.getServer().getOnlinePlayers().length;
				Random chooser = new Random();
				int whoToKick = chooser.nextInt(numPlayers);
				
				for (Player p : sender.getServer().getOnlinePlayers()) {
					boolean ignore = false;
					
					if(Config.readBoolean("ignore-ops") && p.isOp())
					{
						ignore = true;
					}
					if(Config.readBoolean("target-across-worlds") && ((Player) sender).getWorld() != p.getWorld()){
						ignore = true;
					}
					if(p.hasPermission("roulette.safe"))
					{
						ignore = true;
					}
					
					if(count == whoToKick && ignore == false)
					{
						p.sendMessage(ChatColor.YELLOW + "The sky darkens...");
						p.kickPlayer("You were killed!");
						count++;
						ignore = false;
						stats.increaseNukes();
					}
					else
					{
						p.sendMessage(ChatColor.YELLOW + "The sky darkens...");
						p.sendMessage(ChatColor.YELLOW + "*thud*");
						count++;
						ignore = false;
					}
				}
				return true;
			}
			else
			{	
				error("You don't have permission!", sender);
				return true;
			}
		}
		
		return true;	
	}
	
	public static void error(String error, CommandSender sender)
	{
		sender.sendMessage(ChatColor.RED + error);
	}
}
