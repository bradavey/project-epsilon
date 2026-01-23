package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Item;
import cz.bradavey.game.Player;
import cz.bradavey.game.Room;

import java.util.HashMap;
import java.util.Map;

public class CommandInspect implements Command {
    private final Map<String, String> descriptions;

    public CommandInspect(Player player, Map<String, Room> rooms) {
        HashMap<String, String> result = new HashMap<>();
        for (Item item : player.getInventory()) {
            result.put(item.getName().toLowerCase(), item.getDescription());
        }
        for (Room room : rooms.values()) {
            result.put(room.getName().toLowerCase(),room.getDescription());
            for (Item item : room.getItems()) {
                result.put(item.getName().toLowerCase(), item.getDescription());
            }
        }
        descriptions = result;
    }

    @Override
    public String execute(String arg) {
        if (descriptions.containsKey(arg.toLowerCase().trim())) {
            return descriptions.get(arg.toLowerCase().trim());
        } else return arg + " doesn't have a description";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
