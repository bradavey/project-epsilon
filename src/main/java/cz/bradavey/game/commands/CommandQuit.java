package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

public class CommandQuit implements Command {
    @Override
    public String execute(String arg) {
        //TODO all
        return "";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
