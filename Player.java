import java.util.ArrayList;

/**
 * A class representing a human player
 */
public class Player extends Updateable implements Describable {

    public static final double LABOR_CONSTANT = 0.5; ///How much labor per cash per minute

    String name; ///The name of this player
    ArrayList<Production> productions; ///The productions this player owns
    private double cash; ///How much cash this player has
    private double labor; ///How much labor this player currently has
    private double payLabor; ///How much labor this player is currently paying for

    public Player(String name) {
        super();
        this.productions = new ArrayList<Production>();
        this.cash = 0;
        this.labor = 0;
        this.payLabor = 0;
    }

    /**
     * Deals with how much labor the Player gained after a certain amount of elapsed minutes
     * TODO: add some maximum to labor
     * TODO: deal with fact that player might be unable to pay
     */
    private void updateLabor(double elapsedTime) {
        this.labor += payLabor * elapsedTime * LABOR_CONSTANT;
        this.cash -= elapsedTime;
    }

    /**
     * Implementation of applyUpdate
     * Updates the Player's labor stock
     */
    @Override 
    public void applyUpdate(double elapsedTime) {
        this.updateLabor(elapsedTime);
    }

    /**
     * Getter method for labor
     */
    public double getLabor() {
        this.update();
        return this.labor;
    }

    /**
     * Setter method for payLabor
     */
    public void setPayLabor(double set) {
        this.update();
        this.payLabor = set;
    }

    /**
     * Getter method for cash
     */
    public double getCash() {
        return this.cash;
    }

    /**
     * Adder method for cash
     */
    public void addCash(double toAdd) {
        this.cash += toAdd;
    }

    /**
     * Implementation of getLabel
     */
    public String getLabel() {
        return this.name + " - $" + this.cash;
    }

    /**
     * Implementation of getInfo
     */
    public String getInfo() {
        String str = "Productions: ";
        for (Production p : this.productions) {
            str += "\n - " + p.getLabel();
        }
        return str + "\nLabor: " + this.labor + "\nCurrently Paying " + this.payLabor;
    }
    
}