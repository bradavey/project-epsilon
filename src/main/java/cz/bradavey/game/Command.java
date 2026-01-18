package cz.bradavey.game;

public interface Command {
    String execute(Player player, String arg);
    boolean exit();
}
