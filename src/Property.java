import javax.swing.*;

public class Property {
    private String name;
    private int price;
    private double rent;
    private boolean isOwned;
    private String owner;

    public Property(String name, int price, double rent) {
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.isOwned = false;
        this.owner = "";
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getRent() {
        return rent;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public String getOwner() {
        return owner;
    }

    public void buyProperty(String ownerName) {
        if (!isOwned) {
            this.isOwned = true;
            this.owner = ownerName;
            System.out.println(ownerName + " has bought " + name + " for $" + price);
        } else {
            System.out.println(name + " is already owned by " + owner);
        }
    }

    public void payRent(Player renter, Main main) {
        if (isOwned && !owner.equals(renter.getName())) {
            renter.updateMoney(-(int) rent);
            main.printToGameTextArea(renter.getName() + " has to pay $" + rent + " rent to " + owner);
        } else {
            main.printToGameTextArea(name + " is not owned by anyone or is owned by " + renter.getName());
        }
    }

    public void handleLanding(Player player, Main main) {
        if (!isOwned) {
            main.printToGameTextArea(name);
            main.printToGameTextArea("Price: $" + price);
            main.printToGameTextArea("Rent: $" + rent);
            int response = JOptionPane.showConfirmDialog(main, "Would you like to purchase " + name + " for $" + price + "?", "Buy Property", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                player.buyProperty(this);
                main.printToGameTextArea(player.getName() + " chose to purchase " + name);
            } else {
                main.printToGameTextArea(player.getName() + " chose not to purchase " + name);
            }
        } else if (!owner.equals(player.getName())) {
            payRent(player, main);
        }
    }
}
