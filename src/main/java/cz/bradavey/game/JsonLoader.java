package cz.bradavey.game;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JsonLoader {
    public static WorldData loadGameWorld(String filePath) {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            WorldDataDTO dto = gson.fromJson(reader, WorldDataDTO.class);

            WorldData worldData = new WorldData();
            worldData.setStartingRoom(dto.startingRoom);

            if (dto.rooms != null) {
                for (Room room : dto.rooms) {
                    worldData.addRoom(room);
                }
            }

            return worldData;

        } catch (IOException e) {
            System.err.println("Error loading JSON file: " + e.getMessage());
            return null;
        }
    }

    private static class WorldDataDTO {
        String startingRoom;
        List<Room> rooms;
    }
}
