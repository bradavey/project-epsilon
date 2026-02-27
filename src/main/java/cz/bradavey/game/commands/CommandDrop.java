package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Item;
import cz.bradavey.game.Player;

/**
 * Handles dropping an item
 */
public class CommandDrop implements Command {
    private final Player player;

    public CommandDrop(Player player) {
        this.player = player;
    }

    /**
     * Drops item
     * @param arg name of dropped item
     */
    @Override
    public String execute(String arg) {
        Item temp = player.removeItem(arg);
        player.getCurrentRoom().addItem(temp);
        return "Dropped item: " + temp.name();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
