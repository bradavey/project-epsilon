package cz.bradavey.game;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Handles JSON resources
 */
public class JsonLoader {
    /**
     * Loads game data from JSON
     * @param filePath name of the JSON in resource folder
     * @return game data
     * @throws IOException
     */
    public static WorldData loadGameWorld(String filePath) throws IOException {
        Gson gson = new Gson();

        try (InputStream in = JsonLoader.class.getResourceAsStream(filePath)) {

            if (in == null) {
                throw new FileNotFoundException("World data file not found: " + filePath);
            }

            try (InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {

                WorldDataDTO dto = gson.fromJson(reader, WorldDataDTO.class);

                if (dto == null) {
                    throw new IllegalStateException("Resource file is empty or invalid JSON");
                }

                WorldData worldData = new WorldData();
                worldData.setStartingRoom(dto.startingRoom);

                if (dto.rooms != null) {
                    for (Room room : dto.rooms) {
                        worldData.addRoom(room);
                    }
                }

                if (!worldData.getRooms().isEmpty() || worldData.getStartingRoom() != null) {
                    return worldData;
                } else {
                    throw new IllegalStateException("Invalid resource file contents");
                }
            }
        }
    }

    /**
     * Middle point between JSON and game data
     */
    private static class WorldDataDTO {
        String startingRoom;
        List<Room> rooms;
    }
}
