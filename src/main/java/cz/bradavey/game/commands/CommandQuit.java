package cz.bradavey.game.commands;

import cz.bradavey.game.Command;

/**
 * Handles exiting
 * <li> author: brada (bradadavidcz@gmail.com)
 */
public class CommandQuit implements Command {
    /**
     * @param arg null (/ignored)
     * @return Acknowledgment of exit
     */
    @Override
    public String execute(String arg) {
        return "Quitting...";
    }

    /**
     * @return true - game cycle interruption
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Override
    public boolean exit() {
        return true;
    }
}
