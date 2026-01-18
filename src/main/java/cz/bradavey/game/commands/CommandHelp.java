package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

public class CommandHelp implements Command {
    @Override
    public String execute(Player player, String arg) {
        //TODO all
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
