package cz.bradavey.game.commands;

import cz.bradavey.game.Command;

public class CommandHelp implements Command {
    @Override
    public String execute(String arg) {
        return "Available commands: drop, go, help, hint, inspect, quit, take, talk, use";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
