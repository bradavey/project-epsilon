package cz.bradavey.game;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private final List<Item> inventory;
    private final int maxCapacity = 3;
    private boolean hasCode;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<>();
        this.hasCode = false;
    }

    public Player(Room currentRoom, List<Item> inventory, boolean hasCode) {
        this.currentRoom = currentRoom;
        this.inventory = inventory;
        this.hasCode = hasCode;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public boolean isHasCode() {
        return hasCode;
    }

    public void setHasCode(boolean hasCode) {
        this.hasCode = hasCode;
    }

    /**
     * @param item item added to inventory
     * @return false if inventory is full
     */
    public boolean addItem(Item item) {
        if (inventory.size() < maxCapacity) {
            this.inventory.add(item);
            return true;
        }
        return false;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    /**
     * Removes item from inventory
     * @param itemName name of removed item
     * @return removed item
     */
    public Item removeItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).name().equalsIgnoreCase(itemName.trim())) {
                return inventory.remove(i);
            }
        }
        throw new InvalidParameterException("Item not in inventory: " + itemName);
    }

    /**
     * Checks for item in inventory
     * @param itemName name of checked item
     * @return if item is in inventory
     */
    public boolean hasItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).name().equalsIgnoreCase(itemName.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return true if inventory is full
     */
    public boolean isInventoryFull() {
        return inventory.size() >= maxCapacity;
    }

    /**
     * Sums up whole player
     * @return state of player stats
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current room: ").append(currentRoom.name()).append("\n");
        sb.append("Available exits: ");
        for (String exit : currentRoom.exits()) {
            sb.append(exit).append(", ");
        }
        if (!currentRoom.items().isEmpty()) {
            sb.append("\n");
            sb.append("Available items: ");
            for (Item item : currentRoom.items()) {
                sb.append(item.name()).append(", ");
            }
        }
        if (currentRoom.npc() != null) {
            sb.append("\nCharacter: ").append(currentRoom.npc().getName());
        }
        sb.append("\n");
        sb.append("Inventory: ");
        for (Item item : inventory) {
            sb.append(item.name()).append(", ");
        }
        sb.append("\n");
    return sb.toString();
    }
}
