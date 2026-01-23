package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;
import cz.bradavey.game.Room;

import java.security.InvalidParameterException;
import java.util.Map;

public class CommandGo implements Command {
    private Player player;
    private Map<String, Room> rooms;

    public CommandGo(Player player, Map<String, Room> rooms) {
        this.player = player;
        this.rooms = rooms;
    }

    @Override
    public String execute(String arg) {
        if(rooms.containsKey(arg) && player.getCurrentRoom().containsExit(arg)) {
            if(rooms.get(arg).getLockItemName() == null || player.hasItem(rooms.get(arg).getLockItemName())) {
                player.setCurrentRoom(rooms.get(arg));
                return "Relocated to: " + player.getCurrentRoom().getName();
            } else {
                return "You can't go there";
            }
        }
        throw new InvalidParameterException("Invalid room: " + arg);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
