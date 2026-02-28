package cz.bradavey.game;

import cz.bradavey.game.commands.*;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * Saves the commands
 * <li> author: brada (bradadavidcz@gmail.com)
 */
public class CommandRegistry {
    private Player player;
    private Map<String, Room> rooms;
    private final Map<String, Command> commands;

    public CommandRegistry(Player player, Map<String, Room> rooms) throws IOException {
        this.player = player;
        this.rooms = rooms;
        this.commands = initialize();
    }

    /**
     * Sets the commands
     * @return Map of commands
     * @throws IOException
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    private Map<String, Command> initialize() throws IOException {
        Map<String, Command> result = new HashMap<>();
        result.put("drop", new CommandDrop(player));
        result.put("go", new CommandGo(player, rooms));
        result.put("help", new CommandHelp());
        result.put("hint", new CommandHint(player, rooms));
        result.put("inspect", new CommandInspect(player, rooms));
        result.put("quit", new CommandQuit());
        result.put("take", new CommandTake(player));
        result.put("talk", new CommandTalk(player));
        result.put("use", new CommandUse(player));
        return result;
    }

    /**
     * @param name name of wanted command
     * @return wanted command
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    public Command getCommand(String name) {
        String corrected = name.trim().toLowerCase();
        if(commands.containsKey(corrected)) {
            return commands.get(corrected);
        } else throw new InvalidParameterException("Unrecognized command");
    }
}
