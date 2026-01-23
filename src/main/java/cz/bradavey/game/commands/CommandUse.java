package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

public class CommandUse implements Command {
    private final Player player;
    private boolean win = false;

    public CommandUse(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String arg) {
        if (player.getCurrentRoom().containsImmovableItem() && player.getCurrentRoom().hasItem(arg) && !player.getCurrentRoom().getItem(arg).isPortable()) {
            if (player.isHasCode()) {
                win = true;
                return "You've won";
            }
        }
        return "";
    }

    @Override
    public boolean exit() {
        return win;
    }
}
