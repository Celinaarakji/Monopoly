import javax.swing.*;

public class Jail {
    private boolean inJail;
    private static int jailTile;
    private boolean goToJail;
    private int playerPos;
    private int goToJailTile;
    private Dice dice;
    private int playerMoney;
    private Main main;

    public Jail(Main main, boolean inJail, boolean goToJail, int pos, Dice diceRoll, int initialMoney) {
        this.main = main;
        this.inJail = inJail;
        this.goToJail = goToJail;
        goToJailTile = 30;
        jailTile = 10;
        playerPos = pos;
        dice = diceRoll;
        playerMoney = initialMoney;
    }

    public boolean getInJail() {
        return inJail;
    }

    public boolean getVisitJail() {
        return goToJail;
    }

    public void gotoJail() {
        inJail = true;
        playerPos = jailTile;
        main.printToGameTextArea("Player is in jail at position " + playerPos);
        promptJailOptions();
    }

    public void promptJailOptions() {
        String[] options = {"Roll Dice", "Pay $50"};
        int choice = JOptionPane.showOptionDialog(main,
                "You are in jail. Choose an option to get out:",
                "Jail Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            rollDiceToGetOut();
        } else if (choice == 1) {
            payToGetOut();
        }
    }

    public void rollDiceToGetOut() {
        int roll1 = dice.throwDice();
        int roll2 = dice.throwDice();
        main.printToGameTextArea("Rolled: " + roll1 + " and " + roll2);

        if (roll1 == roll2) {
            inJail = false;
            goToJail = false;
            main.printToGameTextArea("Player rolled a double and is out of jail!");
        } else {
            main.printToGameTextArea("Player did not roll a double and remains in jail.");
            promptJailOptions();
        }
    }

    public void payToGetOut() {
        int bailAmount = 50; // Amount to pay to get out of jail
        if (playerMoney >= bailAmount) {
            playerMoney -= bailAmount;
            inJail = false;
            goToJail = false;
            main.printToGameTextArea("Player paid $" + bailAmount + " to get out of jail. Remaining money: " + playerMoney);
        } else {
            main.printToGameTextArea("Player does not have enough money to pay the bail.");
            promptJailOptions();
        }
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void checkGoToJail() {
        if (playerPos == goToJailTile) {
            gotoJail();
        }
    }

    public void movePlayer(int spaces) {
        playerPos += spaces;
        main.printToGameTextArea("Player moved to position " + playerPos);
        checkGoToJail();
    }
}
