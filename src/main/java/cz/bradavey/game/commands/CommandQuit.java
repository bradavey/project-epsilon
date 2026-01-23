package cz.bradavey.game.commands;

import cz.bradavey.game.Command;

public class CommandQuit implements Command {
    @Override
    public String execute(String arg) {
        return "Quitting...";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
