package cz.bradavey.game.commands;

import cz.bradavey.game.Item;
import cz.bradavey.game.Player;
import cz.bradavey.game.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests inspections
 * <li> author: brada (bradadavidcz@gmail.com)
 */
class CommandInspectTest {

    Player player;
    Map<String, Room> rooms;

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
        this.player.addItem(new Item("playerItem", "testPlayerItemDescription", true));
        this.rooms = new HashMap<>();
        this.rooms.put(null, new Room("room", "testRoomDescription", null, new ArrayList<>(), null, null));
        this.rooms.get(null).addItem(new Item("roomItem", "testRoomItemDescription", false));
    }

    /**
     * Tests inspections on items in player inventory and in rooms, rooms
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Test
    void execute() {
        CommandInspect inspect = new CommandInspect(player, rooms);
        assertEquals("testPlayerItemDescription", inspect.execute("playerItem"));
        assertEquals("testRoomDescription", inspect.execute("room"));
        assertEquals("testRoomItemDescription", inspect.execute("roomItem"));
        assertThrows(InvalidParameterException.class, () -> {inspect.execute("xyz");});
    }
}