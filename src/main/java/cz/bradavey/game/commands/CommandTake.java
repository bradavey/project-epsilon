package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

/**
 * Handles item pick up
 */
public class CommandTake implements Command {
    private final Player player;

    public CommandTake(Player player) {
        this.player = player;
    }

    /**
     * Picks up an item
     * @param arg item available in current room
     */
    @Override
    public String execute(String arg) {
        if (!player.isInventoryFull()) {
            if (player.getCurrentRoom().hasItem(arg.trim())) {
                if (!player.getCurrentRoom().getItem(arg.trim()).portable()) {
                    return "You can't move item: " + arg;
                }
                player.addItem(player.getCurrentRoom().removeItem(arg.trim()));
                return "Item added to inventory";
            } else return "No such item found";
        } else return "Full inventory";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
