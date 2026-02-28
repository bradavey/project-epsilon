package cz.bradavey.game;

/**
 * @param description for inspect command
 * @param portable decides if item can be picked up
 * <li> author: brada (bradadavidcz@gmail.com)
 */
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
