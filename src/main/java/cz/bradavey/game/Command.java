package cz.bradavey.game;

/**
 * Scheme for commands
 * <li> author: brada (bradadavidcz@gmail.com)
 */
public interface Command {
    /**
     * @param arg inputted parameter
     * @return command output
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    String execute(String arg);

    /**
     * @return true to exit game
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    boolean exit();
}
