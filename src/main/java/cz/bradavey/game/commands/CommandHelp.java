package cz.bradavey.game.commands;

import cz.bradavey.game.Command;

/**
 * Provides all commands
 * <li> author: brada (bradadavidcz@gmail.com)
 */
public class CommandHelp implements Command {

    /**
     * @param arg null (/ignored)
     * @return available commands
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Override
    public String execute(String arg) {
        return "Available commands: drop, go, help, hint, inspect, quit, take, talk, use";
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
