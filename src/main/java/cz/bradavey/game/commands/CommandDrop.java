package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Item;
import cz.bradavey.game.Player;

public class CommandDrop implements Command {
    private Player player;

    public CommandDrop(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String arg) {
        Item temp = player.removeItem(arg);
        player.getCurrentRoom().addItem(temp);
        return "Dropped item: " + temp.getName();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
