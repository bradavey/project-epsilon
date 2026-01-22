package cz.bradavey.game;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JsonLoader {
    public static WorldData loadGameWorld(String filePath) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        WorldDataDTO dto = gson.fromJson(reader, WorldDataDTO.class);

        WorldData worldData = new WorldData();
        worldData.setStartingRoom(dto.startingRoom);

        if (dto.rooms != null) {
            for (Room room : dto.rooms) {
                worldData.addRoom(room);
            }
        }

        if (!worldData.getRooms().isEmpty() || worldData.getStartingRoom() != null) {
            return worldData;
        } else throw new IllegalStateException("Invalid resource file contents");
    }

    private static class WorldDataDTO {
        String startingRoom;
        List<Room> rooms;
    }
}
