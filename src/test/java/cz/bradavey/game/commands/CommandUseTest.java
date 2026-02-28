package cz.bradavey.game.commands;

import cz.bradavey.game.Item;
import cz.bradavey.game.Player;
import cz.bradavey.game.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommandUseTest {

    Player player;
    Player player2;
    Player player3;

    @BeforeEach
    void setUp() {
        this.player = new Player(
                new Room(null, null, null, new ArrayList<>(), null, null),
                null, true
        );
        this.player.getCurrentRoom().addItem(new Item("testItem", null, false));
        this.player2 = new Player(
                new Room(null, null, null, new ArrayList<>(), null, null),
                null, false
        );
        this.player2.getCurrentRoom().addItem(new Item("testItem", null, false));
        this.player3 = new Player(
                new Room(null, null, null, new ArrayList<>(), null, null),
                null, true
        );
        this.player3.getCurrentRoom().addItem(new Item("testItem", null, true));
    }

    @Test
    void execute() {
        CommandUse use = new CommandUse(player);
        assertEquals("You've won", use.execute("testItem"));
        assertThrows(InvalidParameterException.class, () -> {use.execute("xyz");});

        CommandUse use2 = new CommandUse(player2);
        assertThrows(IllegalStateException.class, () -> {use2.execute("testItem");});

        CommandUse use3 = new CommandUse(player3);
        assertThrows(InvalidParameterException.class, () -> {use3.execute("testItem");});
    }
}