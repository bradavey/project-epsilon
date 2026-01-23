package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Console;
import cz.bradavey.game.Player;
import cz.bradavey.game.Room;

import java.io.IOException;
import java.util.Map;

public class CommandHint implements Command {
    private final Player player;
    private final Map<String, Room> rooms;
    private final String[] hints;

    public CommandHint(Player player, Map<String, Room> rooms) throws IOException{
        this.player = player;
        this.rooms = rooms;
        this.hints = Console.getTXT("src/main/resources/hints-eng.txt");
    }

    @Override
    public String execute(String arg) {
        if (!rooms.get(hints[hints.length-1]).getNpc().hasBeenTalkedTo()) {
            return hints[0];
        } else if (!player.hasItem(rooms.get(hints[hints.length-1]).getNpc().getRequiredItemName()) && !rooms.get(hints[hints.length-1]).getNpc().isQuestComplete()) {
            return hints[1];
        } else if (!rooms.get(hints[hints.length-1]).getNpc().isQuestComplete()) {
            return hints[2];
        } else if (!player.hasItem(rooms.get(hints[hints.length-2]).getLockItemName())) {
            return hints[3];
        } else if (!player.hasItem(rooms.get(hints[hints.length-3]).getLockItemName())) {
            return hints[4];
        } else return hints[5];
    }

    @Override
    public boolean exit() {
        return false;
    }
}
