package cz.bradavey.game.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandHelpTest {

    @Test
    void execute() {
        CommandHelp help = new CommandHelp();
        assertEquals("Available commands: drop, go, help, hint, inspect, quit, take, talk, use", help.execute(null));
        assertEquals("Available commands: drop, go, help, hint, inspect, quit, take, talk, use", help.execute("xyz"));
    }
}