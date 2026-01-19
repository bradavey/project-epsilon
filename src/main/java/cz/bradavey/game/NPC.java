package cz.bradavey.game;

public class NPC {
    private String name;
    private String dialogueInitial;
    private String dialogueSuccess;
    private String requiredItemName;
    private boolean questComplete;

    public NPC(String name, String dialogueInitial, String dialogueSuccess, String requiredItemName, boolean questComplete) {
        this.name = name;
        this.dialogueInitial = dialogueInitial;
        this.dialogueSuccess = dialogueSuccess;
        this.requiredItemName = requiredItemName;
        this.questComplete = questComplete;
    }

    public String talk(Player player) {
        //TODO all
        return null;
    }
    public boolean receiveItem(Item item) {
        //TODO all
        return false;
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
