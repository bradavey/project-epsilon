package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;
import cz.bradavey.game.Room;

import java.util.Map;

/**
 * Moves player to different room
 */
public class CommandGo implements Command {
    private Player player;
    private Map<String, Room> rooms;

    public CommandGo(Player player, Map<String, Room> rooms) {
        this.player = player;
        this.rooms = rooms;
    }

    /**
     * Moves player
     * @param arg room to be moved to
     */
    @Override
    public String execute(String arg) {
        if(rooms.containsKey(arg) && player.getCurrentRoom().containsExit(arg)) {
            if(rooms.get(arg).lockItemName() == null || player.hasItem(rooms.get(arg).lockItemName())) {
                player.setCurrentRoom(rooms.get(arg));
                return "Relocated to: " + player.getCurrentRoom().name();
            } else {
                return "You can't go there";
            }
        }
        return "Invalid room: " + arg;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
