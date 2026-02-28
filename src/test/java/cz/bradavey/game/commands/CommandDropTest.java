package cz.bradavey.game.commands;

import cz.bradavey.game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests dropping
 * <li> author: brada (bradadavidcz@gmail.com)
 */
class CommandDropTest {

    Player player;

    /**
     * Sets up test parameters for {@code execute()}
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @BeforeEach
    void setUp(){
        this.player = new Player(
                new Room(null, null, null, new ArrayList<>(), null, null),
                new ArrayList<>(), false
        );
        player.addItem(new Item("testItem", null, true));
    }

    /**
     * Tests for correct and incorrect item name
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Test
    void execute() {
        CommandDrop drop = new CommandDrop(player);
        assertEquals("Dropped item: testItem", drop.execute("testItem"));
        assertThrows(InvalidParameterException.class, () -> {drop.execute("xyz");});
    }
}