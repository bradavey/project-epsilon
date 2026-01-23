package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

public class CommandTake implements Command {
    private final Player player;

    public CommandTake(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String arg) {
        if (!player.isInventoryFull()) {
            if (player.getCurrentRoom().hasItem(arg.trim())) {
                if (!player.getCurrentRoom().getItem(arg.trim()).isPortable()) {
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
