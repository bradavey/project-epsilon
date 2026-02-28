package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Item;
import cz.bradavey.game.Player;
import cz.bradavey.game.Room;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles descriptions of items / rooms
 */
public class CommandInspect implements Command {
    private final Map<String, String> descriptions;

    public CommandInspect(Player player, Map<String, Room> rooms) {
        HashMap<String, String> result = new HashMap<>();
        for (Item item : player.getInventory()) {
            result.put(item.name().toLowerCase(), item.description());
        }
        for (Room room : rooms.values()) {
            result.put(room.name().toLowerCase(),room.description());
            for (Item item : room.items()) {
                result.put(item.name().toLowerCase(), item.description());
            }
        }
        descriptions = result;
    }

    /**
     * Gives a description
     * @param arg item/room to be described
     */
    @Override
    public String execute(String arg) {
        if (descriptions.containsKey(arg.toLowerCase().trim())) {
            return descriptions.get(arg.toLowerCase().trim());
        } else throw new InvalidParameterException(arg + " doesn't have a description");
    }

    @Override
    public boolean exit() {
        return false;
    }
}
