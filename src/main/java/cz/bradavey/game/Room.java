package cz.bradavey.game;

import java.util.Arrays;
import java.util.List;

public class Room {
    private final String name;
    private final String description;
    private final String[] exits;
    private final List<Item> items;
    private final NPC npc;
    private final String lockItemName;

    public Room(String name, String description, String[] exits, List<Item> items, NPC npc, String lockItemName) {
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.items = items;
        this.npc = npc;
        this.lockItemName = lockItemName;
    }

    public String getName() {
        return name;
    }

    public String getLockItemName() {
        return lockItemName;
    }

    public String getDescription() {
        return description;
    }

    public boolean containsExit(String name) {
        for (String exit : exits) {
            if(exit.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsImmovableItem() {
        for (Item item : items) {
            if (!item.isPortable()) return true;
        }
        return false;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                return items.remove(i);
            }
        }
        return null;
    }

    public Item getItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }

    public boolean hasItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public NPC getNpc() {
        return npc;
    }

    public String[] getExits() {
        return exits;
    }

    public List<Item> getItems() {
        return items;
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
