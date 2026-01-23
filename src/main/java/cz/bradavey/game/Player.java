package cz.bradavey.game;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private final List<Item> inventory;
    private final int maxCapacity = 3;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
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

    public Item removeItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName.trim())) {
                return inventory.remove(i);
            }
        }
        throw new InvalidParameterException("Item not in inventory");
    }

    public boolean hasItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName.trim())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current room: ").append(currentRoom.getName()).append("\n");
        sb.append("Available exits: ");
        for (String exit : currentRoom.getExits()) {
            sb.append(exit).append(", ");
        }
        if (!currentRoom.getItems().isEmpty()) {
            sb.append("\n");
            sb.append("Available items: ");
            for (Item item : currentRoom.getItems()) {
                sb.append(item.getName()).append(", ");
            }
        }
        if (currentRoom.getNpc() != null) {
            sb.append("\nCharacter").append(currentRoom.getNpc().getName());
        }
        sb.append("\n");
        sb.append("Inventory: ");
        for (Item item : inventory) {
            sb.append(item.getName());
        }
        sb.append("\n");
    return sb.toString();
    }
}
