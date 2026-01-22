package cz.bradavey.game;

import cz.bradavey.game.commands.*;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private Player player;
    private final Map<String, Command> commands;

    public CommandRegistry(Player player) {
        this.player = player;
        this.commands = initialize();
    }

    private Map<String, Command> initialize() {
        Map<String, Command> result = new HashMap<>();
        result.put("drop", new CommandDrop());
        result.put("go", new CommandGo(player));
        result.put("help", new CommandHelp());
        result.put("hint", new CommandHint());
        result.put("inspect", new CommandInspect());
        result.put("quit", new CommandQuit());
        result.put("take", new CommandTake());
        result.put("talk", new CommandTalk());
        result.put("use", new CommandUse());
        return result;
    }

    public Command getCommand(String name) {
        String corrected = name.trim().toLowerCase();
        if(commands.containsKey(corrected)) {
            return commands.get(corrected);
        } else throw new InvalidParameterException("Unrecognized command");
    }
}
