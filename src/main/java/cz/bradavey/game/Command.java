package cz.bradavey.game;

public interface Command {
    String execute(String arg);
    boolean exit();
}
