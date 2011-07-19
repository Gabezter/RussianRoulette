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
	
	public void onEnable()
	{
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
	              usePermissions = true;
	          } else {
	              usePermissions = false;
	          }
	      }
	  }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
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
						if(count == whoToKick)
						{
							p.sendMessage(ChatColor.YELLOW + ((Player) sender).getDisplayName() + " hands you a gun...");
							p.kickPlayer("You were killed!");
							count++;
						}
						else
						{
							p.sendMessage(ChatColor.YELLOW + ((Player) sender).getDisplayName() + " hands you a gun...");
							p.sendMessage(ChatColor.YELLOW + "*click*");
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
				    		  p.sendMessage(ChatColor.YELLOW + ((Player) sender).getDisplayName() + " hands you a gun...");
				    		  p.kickPlayer("You were killed!");
				    		  count++;
				    	  }
				    	  else
				    	  {
				    		  p.sendMessage(ChatColor.YELLOW + ((Player) sender).getDisplayName() + " hands you a gun...");
				    		  p.sendMessage(ChatColor.GRAY + "*click*");
				    		  count++;
				    	  }
					}
				}
				else
				{
					sender.sendMessage("You don't have permission!");
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
					sender.sendMessage("You don't have permission!");
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
					sender.sendMessage("You don't have permission!");
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
