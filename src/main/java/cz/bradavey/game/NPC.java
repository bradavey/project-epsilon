package cz.bradavey.game;

public class NPC {
    private final String name;
    private final String dialogueInitial;
    private final String dialogueSuccess;
    private final String requiredItemName;
    private boolean questComplete;
    private boolean hasBeenTalkedTo;

    public NPC(String name, String dialogueInitial, String dialogueSuccess, String requiredItemName, boolean questComplete) {
        this.name = name;
        this.dialogueInitial = dialogueInitial;
        this.dialogueSuccess = dialogueSuccess;
        this.requiredItemName = requiredItemName;
        this.questComplete = questComplete;
    }

    public String getName() {
        return name;
    }

    public boolean hasBeenTalkedTo() {
        return hasBeenTalkedTo;
    }

    public String getRequiredItemName() {
        return requiredItemName;
    }

    public boolean isQuestComplete() {
        return questComplete;
    }

    /**
     * Handles interactions with player
     * @param player player that is being interacted with
     * @return console output
     */
    public String talk(Player player) {
        if (!hasBeenTalkedTo) {
            hasBeenTalkedTo = true;
            return dialogueInitial;
        }
        if (questComplete) {
            return "Quest already complete";
        }
        if (player.hasItem(requiredItemName)) {
            boolean give = Console.scanString("Give item: " + requiredItemName + "to " + name + "\ny/n").trim().equalsIgnoreCase("y");
            if (give) {
                player.removeItem(requiredItemName);
                questComplete = true;
                player.setHasCode(true);
                return dialogueSuccess;
            }
        }
        return dialogueInitial;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                ", dialogueInitial='" + dialogueInitial + '\'' +
                ", dialogueSuccess='" + dialogueSuccess + '\'' +
                ", requiredItemName='" + requiredItemName + '\'' +
                ", questComplete=" + questComplete +
                '}';
    }
}
