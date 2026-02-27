package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

/**
 * Handles interactions with NPCs
 */
public class CommandTalk implements Command {
    private Player player;

    public CommandTalk(Player player) {
        this.player = player;
    }

    /**
     * Talks to and NPC
     * @param arg target NPC
     * @return
     */
    @Override
    public String execute(String arg) {
        if (player.getCurrentRoom().npc() != null && player.getCurrentRoom().npc().getName().equalsIgnoreCase(arg.trim())) {
            return player.getCurrentRoom().npc().talk(player);
        }
        return "No character: " + arg;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
