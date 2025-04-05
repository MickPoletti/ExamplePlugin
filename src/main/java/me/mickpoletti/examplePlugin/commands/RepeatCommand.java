package me.mickpoletti.examplePlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepeatCommand implements CommandExecutor {
    /*
        /repeat bob is really cool
    */
    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args ) {
        if (sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();
            if (args.length == 0) {
                p.sendMessage("I'm sorry I can't do that Dave.");
                p.sendMessage("Example: /repeat arg1 arg2 ... argX");
            } else {
                // My C++ style solution
                String message = "";
                for (int i = 0; i < args.length; i++) {
                   message += " " + args[i];
                }
                /* The Java style solution
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    builder.append(args[i] + " ");
                }
                message = builder.toString();
                */
                p.sendMessage("Message: " + message);
            }
        }
        return true;
    }
}
