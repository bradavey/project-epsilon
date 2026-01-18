package cz.bradavey.game;

import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private List<Item> items;
    private NPC npc;

    public String getName() {
        //TODO all
        return null;
    }

    public Room getExit(String name) {
        //TODO all
        return null;
    }

    public void addItem(Item item) {
        //TODO all
    }

    public Item removeItem(String itemName) {
        //TODO all
        return null;
    }

    public NPC getNpc() {
        //TODO all
        return null;
    }
}
