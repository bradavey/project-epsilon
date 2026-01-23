package cz.bradavey.game;

import java.util.Map;
import java.util.Scanner;

public class Console {
    private boolean gameOver = false;
    private Player player;
    private CommandRegistry registry;
    private Map<String, Room> rooms;

    public void run() {
        setGame();
        this.registry = new CommandRegistry(player, rooms);
        while(!gameOver) {
            scanString("Press Enter"); clearConsole();
            System.out.println(player.toString());
            try {
                processCommand(scanString(">> "));
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }

    private void processCommand(String input) {
        String command = input.trim().toLowerCase().split(" ")[0];
        String arg = null;
        try {
            arg = input.trim().substring(input.indexOf(' ') + 1);
        } catch (Exception _){}
        System.out.println(registry.getCommand(command).execute(arg));
        gameOver = registry.getCommand(command).exit();
    }

    private void setGame() {
        try {
            WorldData temp = JsonLoader.loadGameWorld("src/main/resources/world-eng.json");
            this.rooms = temp.getRooms();
            this.player = new Player(temp.getStartingRoom());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            gameOver = true;
        }
    }

    private void clearConsole() {
        String os = System.getProperty("os.name");
        try {
            if (os.startsWith("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.err.println("Error while clearing console: " + e.getMessage());

        }
    }

    public String scanString(String prompt) {
        if (!prompt.isEmpty()) System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
