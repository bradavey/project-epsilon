package cz.bradavey.game.commands;

import cz.bradavey.game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommandDropTest {

    Player player;

    @BeforeEach
    void setUp() throws IOException {
        this.player = new Player(
                new Room(null, null, null, new ArrayList<>(), null, null),
                new ArrayList<>(), false
        );
        player.addItem(new Item("testItem", null, true));
    }

    @Test
    void execute() {
        CommandDrop drop = new CommandDrop(player);
        assertEquals("Dropped item: testItem", drop.execute("testItem"));
        assertThrows(InvalidParameterException.class, () -> {drop.execute("xyz");});
    }
}