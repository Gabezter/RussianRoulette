package main.java.com.texasgamer.russianroulette;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class RussianRoulette extends JavaPlugin{
	
	public static final Logger logger = Logger.getLogger("Minecraft.RussianRoulette");
	static boolean usePermissions = false;
	public static PermissionHandler permissionHandler;
	Config config = new Config(this);
	
	public void onEnable()
	{
		config.configCheck();
		setupPermissions();
		logger.info(getDescription().getName() + " " + getDescription().getVersion() + " enabled!");
	}

	public void onDisable()
	{
		setupPermissions();
		// Goodbye!
	    logger.info(getDescription().getName() + " " + getDescription().getVersion() + " disabled!");
	}
	
	private void setupPermissions() {
	      Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");

	      if (RussianRoulette.permissionHandler == null) {
	          if (permissionsPlugin != null) {
	              RussianRoulette.permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	              logger.info("RussianRoulette: Will use "+((Permissions)permissionsPlugin).getDescription().getFullName() + " for permissions.");
	              usePermissions = true;
	          } else {
	        	  logger.info("RussianRoulette: Permission system not detected, defaulting to ops");
	              usePermissions = false;
	          }
	      }
	  }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(commandLabel.equalsIgnoreCase("roulette"))
		{
			sender.sendMessage(ChatColor.LIGHT_PURPLE + getDescription().getName() + " " + getDescription().getVersion());
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "http://www.texasgamer.co.cc");
			if(usePermissions)
			{
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "Permissions: " + ChatColor.GREEN + "Yes");
			}
			else
			{
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "Permissions: " + ChatColor.RED + "No");
			}
		}
		
		if(commandLabel.equalsIgnoreCase("rr"))
		{
			if(usePermissions)
			{
				if (!RussianRoulette.permissionHandler.has((Player) sender, "roulette.rr")) {
					error("You don't have permission!", sender);
				}
				else
				{	
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
						
						
						if(count == whoToKick && RussianRoulette.permissionHandler.has((Player) sender, "roulette.safe") && ignore == false)
						{
							p.sendMessage(ChatColor.YELLOW + ((Player) sender).getDisplayName() + " hands you a gun...");
							p.kickPlayer("You were killed!");
							count++;
							ignore = false;
						}
						else
						{
							p.sendMessage(ChatColor.YELLOW + ((Player) sender).getDisplayName() + " hands you a gun...");
							p.sendMessage(ChatColor.YELLOW + "*click*");
							count++;
							ignore = false;
						}
						
						
				    }
				}
			}
			else
			{
				if(sender.isOp())
				{
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
						
						if(count == whoToKick && ignore == false)
						{
							p.sendMessage(ChatColor.YELLOW + ((Player) sender).getDisplayName() + " hands you a gun...");
							p.kickPlayer("You were killed!");
							count++;
							ignore = false;
						}
						else
						{
							p.sendMessage(ChatColor.YELLOW + ((Player) sender).getDisplayName() + " hands you a gun...");
							p.sendMessage(ChatColor.YELLOW + "*click*");
							count++;
							ignore = false;
						}
						
						
				    }
				}
				else
				{
					error("You don't have permission!",sender);
				}
			}
		}
		
		if(commandLabel.equalsIgnoreCase("moab"))
		{
			if(usePermissions)
			{
				if (!RussianRoulette.permissionHandler.has((Player) sender, "roulette.moab")) {
					error("You don't have permission!", sender);
				}
				else
				{	
					int count = 0;
					int numPlayers = sender.getServer().getOnlinePlayers().length;
					Random chooser = new Random();
					int whoToKick = chooser.nextInt(numPlayers);
					
					for (Player p : sender.getServer().getOnlinePlayers()) {
						if(count == whoToKick)
						{
							p.sendMessage(ChatColor.YELLOW + "As a large object appears, the sky darkens...");
							p.kickPlayer("You were killed!");
							count++;
						}
						else
						{
							p.sendMessage(ChatColor.YELLOW + "As a large object appears, the sky darkens...");
							p.sendMessage(ChatColor.YELLOW + "It's a dud!");
							count++;
						}
				    }
				}
			}
			else
			{
				if(sender.isOp())
				{
					int count = 0;
					int numPlayers = sender.getServer().getOnlinePlayers().length;
					Random chooser = new Random();
					int whoToKick = chooser.nextInt(numPlayers);
					
					for (Player p : sender.getServer().getOnlinePlayers()) {
				    	  if(count == whoToKick)
				    	  {
				    		  p.sendMessage(ChatColor.YELLOW + "As a large object appears, the sky darkens...");
				    		  p.kickPlayer("You were killed!");
				    		  count++;
				    	  }
				    	  else
				    	  {
				    		  p.sendMessage(ChatColor.YELLOW + "As a large object appears, the sky darkens...");
				    		  p.sendMessage(ChatColor.GRAY + "It's a dud!");
				    		  count++;
				    	  }
					}
				}
				else
				{
					error("You don't have permission!",sender);
				}
			}
		}
		
		if(commandLabel.equalsIgnoreCase("nuke"))
		{
			if(usePermissions)
			{
				if (!RussianRoulette.permissionHandler.has((Player) sender, "roulette.nuke")) {
					error("You don't have permission!", sender);
				}
				else
				{	
					int count = 0;
					int numPlayers = sender.getServer().getOnlinePlayers().length;
					Random chooser = new Random();
					int whoToKick = chooser.nextInt(numPlayers);
					
					for (Player p : sender.getServer().getOnlinePlayers()) {
						if(count == whoToKick)
						{
							p.sendMessage(ChatColor.YELLOW + "As a large object appears, the sky darkens...");
							p.kickPlayer("You were killed!");
							count++;
						}
						else
						{
							p.sendMessage(ChatColor.YELLOW + "As a large object appears, the sky darkens...");
							p.sendMessage(ChatColor.YELLOW + "It's a dud!");
							count++;
						}
				    }
				}
			}
			else
			{
				if(sender.isOp())
				{
					int count = 0;
					int numPlayers = sender.getServer().getOnlinePlayers().length;
					Random chooser = new Random();
					int whoToKick = chooser.nextInt(numPlayers);
					
					for (Player p : sender.getServer().getOnlinePlayers()) {
				    	  if(count == whoToKick)
				    	  {
				    		  p.sendMessage(ChatColor.YELLOW + "As a large object appears, the sky darkens...");
				    		  p.kickPlayer("You were killed!");
				    		  count++;
				    	  }
				    	  else
				    	  {
				    		  p.sendMessage(ChatColor.YELLOW + "As a large object appears, the sky darkens...");
				    		  p.sendMessage(ChatColor.GRAY + "It's a dud!");
				    		  count++;
				    	  }
					}
				}
				else
				{
					error("You don't have permission!",sender);
				}
			}
		}
		
		return true;	
	}
	
	public static void error(String error, CommandSender sender)
	{
		sender.sendMessage(ChatColor.RED + error);
	}
}
