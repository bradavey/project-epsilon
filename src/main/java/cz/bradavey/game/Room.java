package cz.bradavey.game;

import java.util.Arrays;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private String[] exits;
    private List<Item> items;
    private NPC npc;

    public Room(String name, String description, String[] exits, List<Item> items, NPC npc) {
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.items = items;
        this.npc = npc;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", exits=" + Arrays.toString(exits) +
                ", items=" + Arrays.toString(items.toArray()) +
                ", npc=" + npc +
                '}';
    }
}
