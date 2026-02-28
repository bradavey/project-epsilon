package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

import java.security.InvalidParameterException;

/**
 * Handles item pick up
 * <li> author: brada (bradadavidcz@gmail.com)
 */
public class CommandTake implements Command {
    private final Player player;

    public CommandTake(Player player) {
        this.player = player;
    }

    /**
     * Picks up an item
     * @param arg item available in current room
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Override
    public String execute(String arg) {
        if (!player.isInventoryFull()) {
            if (player.getCurrentRoom().hasItem(arg.trim())) {
                if (!player.getCurrentRoom().getItem(arg.trim()).portable()) {
                    throw new IllegalStateException("You can't move item: " + arg);
                }
                player.addItem(player.getCurrentRoom().removeItem(arg.trim()));
                return "Item added to inventory";
            } else throw new InvalidParameterException("Item " + arg + " not found");
        } else throw new IllegalStateException("Full inventory");
    }

    /**
     * @return false - no game cycle interruption
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Override
    public boolean exit() {
        return false;
    }
}
