package cz.bradavey.game;

public class Item {
    private String name;
    private String description;
    private boolean portable;

    public Item(String name, String description, boolean portable) {
        this.name = name;
        this.description = description;
        this.portable = portable;
    }

    public String getName() {
        //TODO all
        return null;
    }

    public boolean isPortable() {
        //TODO all
        return false;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", portable=" + portable +
                '}';
    }
}
