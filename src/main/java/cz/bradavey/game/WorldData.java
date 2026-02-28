package cz.bradavey.game;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains game data
 * <li> author: brada (bradadavidcz@gmail.com)
 */
public class WorldData {
    private String startingRoom;
    private final Map<String, Room> rooms;


    public WorldData() {
        rooms = new HashMap<>();
    }

    public void setStartingRoom(String startingRoom) {
        this.startingRoom = startingRoom;
    }

    /**
     * adds room to rooms
     * @param room added room
     * <li> author: brada (bradadavidcz@gmail.com)
     */
    public void addRoom(Room room) {
        rooms.put(room.name().toLowerCase(), room);
    }

    public Room getStartingRoom() {
        return rooms.get(startingRoom);
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("starting room = ").append(startingRoom).append("\n");
        for (Map.Entry<String, Room> room : rooms.entrySet()) {
            sb.append(room.getKey()).append(" = ").append(room.getValue()).append("\n");
        }
        return sb + "";
    }
}
