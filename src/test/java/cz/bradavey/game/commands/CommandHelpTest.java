package cz.bradavey.game.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests help command
 * <li> author: brada (bradadavidcz@gmail.com)
 */
class CommandHelpTest {

    /**
     * Checks correct output and that arg does nothing
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Test
    void execute() {
        CommandHelp help = new CommandHelp();
        assertEquals("Available commands: drop, go, help, hint, inspect, quit, take, talk, use", help.execute(null));
        assertEquals("Available commands: drop, go, help, hint, inspect, quit, take, talk, use", help.execute("xyz"));
    }
}