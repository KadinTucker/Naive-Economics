import java.util.ArrayList;

/**
 * A class representing a human player
 */
public class Player extends Updateable {

    public static final double LABOR_CONSTANT = 0.5; ///How much labor per cash per minute

    String name; ///The name of this player
    ArrayList<Production> productions; ///The productions this player owns
    double cash; ///How much cash this player has
    double labor; ///How much labor this player currently has
    double payLabor; ///How much labor this player is currently paying for

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
    
}