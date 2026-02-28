package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

import java.security.InvalidParameterException;

/**
 * Handles using immovable objects/winning
 * <li> author: brada (bradadavidcz@gmail.com)
 */
public class CommandUse implements Command {
    private final Player player;
    private boolean win = false;

    public CommandUse(Player player) {
        this.player = player;
    }

    /**
     * Decides if player won
     * @param arg target immovable object
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Override
    public String execute(String arg) {
        if (player.getCurrentRoom().containsImmovableItem() && player.getCurrentRoom().hasItem(arg) && !player.getCurrentRoom().getItem(arg).portable()) {
            if (player.isHasCode()) {
                win = true;
                return "You've won";
            } else throw new IllegalStateException("You will need something more");
        }
        throw new InvalidParameterException("No usable item: " + arg);
    }

    /**
     * @return true of false dependant directly on {@code execute()}
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Override
    public boolean exit() {
        return win;
    }
}
