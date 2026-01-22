package cz.bradavey.game.commands;

import cz.bradavey.game.Command;
import cz.bradavey.game.Player;

public class CommandGo implements Command {
    Player player;

    public CommandGo(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String arg) {
        //TODO all
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
