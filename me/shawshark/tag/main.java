package me.shawshark.tag;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.kitteh.tag.PlayerReceiveNameTagEvent;
import org.kitteh.tag.TagAPI;

public class main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
	}
	
	@EventHandler
    public void onPlayerTag(PlayerReceiveNameTagEvent e) {
		Player p = e.getNamedPlayer();
		if (p.hasPermission("craftshark.donor")) {
            e.setTag(ChatColor.DARK_PURPLE + p.getName());  
		}
		if (p.hasPermission("craftshark.supporter")) { 
            e.setTag(ChatColor.RED + p.getName());
		}
		if (p.hasPermission("craftshark.vip")) { 
            e.setTag(ChatColor.GREEN + p.getName());
		}
		if (p.hasPermission("craftshark.elite")) {
            e.setTag(ChatColor.BLUE + p.getName());
		}
		if (p.hasPermission("craftshark.emperor")) {
            e.setTag(ChatColor.YELLOW + p.getName());
		}
		if (p.hasPermission("craftshark.god")) { 
            e.setTag(ChatColor.AQUA + p.getName());
		} 
    }
 
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
            if (!(sender instanceof Player)) {
                    return true;
            }
            Player p = (Player) sender;
         
           if (p.hasPermission("craftshark.donator")) {
            if (cmd.getName().equalsIgnoreCase("tag")) {
                    TagAPI.refreshPlayer(p);
            }
           }
            return true;
    }
    
    public void playerjoinevent(PlayerJoinEvent e) {
    	Player p = e.getPlayer();
    	p.performCommand("tag");
    }
}
