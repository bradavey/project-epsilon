package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

import java.security.InvalidParameterException;

/**
 * Handles interactions with NPCs
 * <li> author: brada (bradadavidcz@gmail.com)
 */
public class CommandTalk implements Command {
    private Player player;

    public CommandTalk(Player player) {
        this.player = player;
    }

    /**
     * Talks to and NPC
     * @param arg target NPC
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Override
    public String execute(String arg) {
        if (player.getCurrentRoom().npc() != null && player.getCurrentRoom().npc().getName().equalsIgnoreCase(arg.trim())) {
            return player.getCurrentRoom().npc().talk(player);
        }
        throw new InvalidParameterException("No character: " + arg);
    }

    /**
     * @return false - no game cycle interruption
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    @Override
    public boolean exit() {
        return false;
    }
}
