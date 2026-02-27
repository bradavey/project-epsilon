package cz.bradavey.game;

import java.util.Arrays;
import java.util.List;

public record Room(String name, String description, String[] exits, List<Item> items, NPC npc, String lockItemName) {

    /**
     * Checks for exit
     * @param name exit name
     * @return true if exit exists
     */
    public boolean containsExit(String name) {
        for (String exit : exits) {
            if (exit.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return true if room contains immovable item
     */
    public boolean containsImmovableItem() {
        for (Item item : items) {
            if (!item.portable()) return true;
        }
        return false;
    }

    /**
     * Adds item to available items
     * @param item added item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes from available items
     * @param itemName name of removed item
     * @return removed item
     */
    public Item removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).name().equalsIgnoreCase(itemName)) {
                return items.remove(i);
            }
        }
        return null;
    }

    /**
     * Gets item from available items =
     * @param itemName name of the item
     * @return wanted item
     */
    public Item getItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).name().equalsIgnoreCase(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }

    /**
     * If item is available
     * @param name name of searched item
     * @return if room has the item
     */
    public boolean hasItem(String name) {
        for (Item item : items) {
            if (item.name().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
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
