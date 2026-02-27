package cz.bradavey.game;

/**
 * Scheme for commands
 */
public interface Command {
    /**
     * @param arg inputted parameter
     * @return command output
     */
    String execute(String arg);

    /**
     * @return true to exit game
     */
    boolean exit();
}
