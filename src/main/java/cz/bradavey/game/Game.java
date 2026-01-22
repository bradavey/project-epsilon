package cz.bradavey.game;

import java.util.Map;
import java.util.Scanner;

public class Game {
    private boolean gameOver = false;
    private Player player;
    private CommandRegistry registry;
    private Map<String, Room> rooms;

    public void run() {
        setGame();
        this.registry = new CommandRegistry(player);
        while(!gameOver) {
            try {
                processCommand(scanString(">> "));
            } catch (Exception _) {
                System.out.println("E");
            }
        }
    }

    private void processCommand(String input) {
        String command = input.trim().toLowerCase().split(" ")[0];
        System.out.println(registry.getCommand(command).execute(input));
        gameOver = registry.getCommand(command).exit();
    }

    public void setGame() {
        try {
            WorldData temp = JsonLoader.loadGameWorld("src/main/resources/world.json");
            this.rooms = temp.getRooms();
            this.player = new Player(temp.getStartingRoom());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            gameOver = true;
        }
    }

    public String scanString(String prompt) {
        if (!prompt.isEmpty()) System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
