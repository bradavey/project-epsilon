package cz.bradavey.game.commands;

import cz.bradavey.game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests Going
 * <li> author: brada (bradadavidcz@gmail.com)
 */
class CommandGoTest {

    Player player;
    Player player2;
    Player player3;
    Map<String, Room> rooms;
    Map<String, Room> rooms2;

    /**
     * Sets up test parameters for {@code execute()}
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @BeforeEach
    void setUp() {
        this.player = new Player(
                new Room(null, null, new String[]{"testRoom"}, null, null, null),
                new ArrayList<>(), false
        );
        this.player2 = new Player(
                new Room(null, null, new String[]{"testRoom"}, null, null, null),
                new ArrayList<>(), false
        );
        this.player3 = new Player(
                new Room(null, null, new String[]{"testRoom"}, null, null, null),
                new ArrayList<>(), false
        );
        player3.addItem(new Item("lockItem", null, true));
        this.rooms = new HashMap<>();
        this.rooms.put("testRoom", new Room("testRoom", null, null, null, null, null));
        this.rooms2 = new HashMap<>();
        this.rooms2.put("testRoom", new Room("testRoom", null, null, null, null, "lockItem"));
    }

    /**
     * Tests correct and incorrect room name, locked rooms
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Test
    void execute() {
        CommandGo go = new CommandGo(player, rooms);
        assertEquals("Relocated to: testRoom", go.execute("testRoom"));
        assertThrows(InvalidParameterException.class, () -> {go.execute("xyz");});

        CommandGo go1 = new CommandGo(player2, rooms2);
        assertThrows(IllegalStateException.class, () -> {go1.execute("testRoom");});

        CommandGo go2 = new CommandGo(player3, rooms2);
        assertEquals("Relocated to: testRoom", go2.execute("testRoom"));
    }
}