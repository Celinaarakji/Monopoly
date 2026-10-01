public class Player {
    private String name;
    private int position;
    private int money;
    private Jail jail; // Add a Jail object for the player

    public Player(Main main, String name, int initialMoney) {
        this.name = name;
        this.position = 0; // Start position
        this.money = initialMoney;
        this.jail = new Jail(main, false, false, 0, new Dice(), initialMoney); // Initialize Jail object
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getMoney() {
        return money;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }

    public void updateMoney(int amount) {
        this.money += amount;
    }

    public Jail getJail() {
        return jail;
    }

    public void buyProperty(Property property) {
        if (property.isOwned()) {
            System.out.println(name + " cannot buy " + property.getName() + " because it is already owned.");
        } else if (money >= property.getPrice()) {
            updateMoney(-property.getPrice());
            property.buyProperty(name);
            System.out.println(name + " bought " + property.getName());
        } else {
            System.out.println(name + " does not have enough money to buy " + property.getName());
        }
    }

    public void payRent(Property property) {
        if (property.isOwned() && !property.getOwner().equals(name)) {
            updateMoney(-(int) property.getRent());
            System.out.println(name + " paid $" + property.getRent() + " rent to " + property.getOwner());
        } else {
            System.out.println(property.getName() + " is not owned by anyone or is owned by " + name);
        }
    }
}
