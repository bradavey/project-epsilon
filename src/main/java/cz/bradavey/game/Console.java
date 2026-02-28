package cz.bradavey.game;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;

/**
 * Handles game cycle, loading and variables
 * <li> author: brada (bradadavidcz@gmail.com), gemini (gemini.google.com)
 */
public class Console {
    private boolean gameOver = false;
    private Player player;
    private CommandRegistry registry;

    /**
     * Does game cycle
     * <li> author: brada (bradadavidcz@gmail.com)
     */
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

    /**
     * Processes command
     * @param input whole user entered line
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    private void processCommand(String input) throws Exception {
        String command;
        String arg = null;
        try {
            command = input.trim().toLowerCase().split(" ")[0];
        } catch (Exception e) {
            throw new Exception(e);
        }
        try {
            arg = input.trim().substring(input.indexOf(' ') + 1).toLowerCase();
        } catch (Exception _){}
        System.out.println(registry.getCommand(command).execute(arg));
        gameOver = registry.getCommand(command).exit();
    }

    /**
     * Loads game data
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    private void setGame() {
        try {
            WorldData temp = JsonLoader.loadGameWorld("/world-eng.json");
            Map<String, Room> rooms = temp.getRooms();
            this.player = new Player(temp.getStartingRoom());
            this.registry = new CommandRegistry(player, rooms);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            gameOver = true;
        }
    }

    /**
     * Clears console
     * <li> author: gemini (gemini.google.com)
     */
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

    /**
     * Scans for user input
     * @param prompt prints if not null
     * @return scanned input
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    public static String scanString(String prompt) {
        if (!prompt.isEmpty()) System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Loads txt resource
     * @param path name of the file in resource folder
     * @return array of loaded strings
     * @throws IOException
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    public static String[] getTXT(String path) throws IOException {
        try (InputStream in = Console.class.getResourceAsStream(path)) {

            if (in == null) {
                throw new FileNotFoundException("Resource not found: " + path);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
                return br.lines().toArray(String[]::new);
            }
        }
    }
}
