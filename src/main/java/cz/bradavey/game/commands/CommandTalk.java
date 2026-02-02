package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

public class CommandTalk implements Command {
    private Player player;

    public CommandTalk(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String arg) {
        if (player.getCurrentRoom().getNpc() != null && player.getCurrentRoom().getNpc().getName().equalsIgnoreCase(arg.trim())) {
            return player.getCurrentRoom().getNpc().talk(player);
        }
        return "No character: " + arg;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
