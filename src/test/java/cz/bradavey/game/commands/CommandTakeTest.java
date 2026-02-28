package cz.bradavey.game.commands;

import cz.bradavey.game.Item;
import cz.bradavey.game.Player;
import cz.bradavey.game.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests taking items
 * <li> author: brada (bradadavidcz@gmail.com)
 */
class CommandTakeTest {

    Player player;
    Player player2;

    /**
     * Sets up test parameters for {@code execute()}
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @BeforeEach
    void setUp() {
        this.player = new Player(
                new Room(null, null, null, new ArrayList<>(), null, null),
                new ArrayList<>(), false
        );
        this.player.getCurrentRoom().addItem(new Item("testPortable", null, true));
        this.player.getCurrentRoom().addItem(new Item("testNonPortable", null, false));
        this.player2 = new Player(
                new Room(null, null, null, new ArrayList<>(), null, null),
                new ArrayList<>(), false
        );
        this.player2.getCurrentRoom().addItem(new Item("testPortable", null, true));
        for (int i = 0; i < 3; i++) {
            this.player2.addItem(new Item(null, null, true));
        }
    }

    /**
     * Tests for item portability, correct name and inventory cap
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Test
    void execute() {
        CommandTake take = new CommandTake(player);
        assertEquals("Item added to inventory", take.execute("testPortable"));
        assertThrows(IllegalStateException.class, () -> {take.execute("testNonPortable");});
        assertThrows(InvalidParameterException.class, () -> {take.execute("xyz");});

        CommandTake take2 = new CommandTake(player2);
        assertThrows(IllegalStateException.class, () -> {take2.execute("testPortable");});
    }
}