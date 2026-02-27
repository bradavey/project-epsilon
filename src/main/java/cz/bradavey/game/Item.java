package cz.bradavey.game;

public record Item(String name, String description, boolean portable) {

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", portable=" + portable +
                '}';
    }
}
