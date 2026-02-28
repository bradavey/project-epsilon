package cz.bradavey.game.commands;

import cz.bradavey.game.Item;
import cz.bradavey.game.NPC;
import cz.bradavey.game.Player;
import cz.bradavey.game.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommandTalkTest {

    Player player;

    @BeforeEach
    void setUp() {
        this.player = new Player(
                new Room(
                        null, null, null, null,
                        new NPC("testNPC", "init", null, "testItem", false),
                        null
                ),
                new ArrayList<>(), false
        );
    }

    @Test
    void execute() {
        CommandTalk talk = new CommandTalk(player);
        assertEquals("init", talk.execute("testNPC"));
        this.player.getCurrentRoom().npc().setQuestComplete(true);
        assertEquals("Quest already complete", talk.execute("testNPC"));
        assertThrows(InvalidParameterException.class, () -> {talk.execute("xyz");});
    }
}