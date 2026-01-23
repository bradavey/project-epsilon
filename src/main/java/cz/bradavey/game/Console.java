package cz.bradavey.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Console {
    private boolean gameOver = false;
    private Player player;
    private CommandRegistry registry;

    public void run() {
        setGame();
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
            arg = input.trim().substring(input.indexOf(' ') + 1).toLowerCase();
        } catch (Exception _){}
        System.out.println(registry.getCommand(command).execute(arg));
        gameOver = registry.getCommand(command).exit();
    }

    private void setGame() {
        try {
            WorldData temp = JsonLoader.loadGameWorld("src/main/resources/world-eng.json");
            Map<String, Room> rooms = temp.getRooms();
            this.player = new Player(temp.getStartingRoom());
            this.registry = new CommandRegistry(player, rooms);
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

    public static String scanString(String prompt) {
        if (!prompt.isEmpty()) System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String[] getTXT(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        return br.readAllLines().toArray(new String[0]);
    }
}
