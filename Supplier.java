

/**
 * A Supplier is a set of data given to each type of good,
 * the price charged for that good, 
 * and the quantity of that good made available
 * Consumers in a Marketplace make decisions based on their supplier
 * A single Supplier can belong to only one marketplace;
 * A Player can have multiple suppliers across multiple marketplaces
 */
public class Supplier {

    Marketplace market; ///The market to which this Supplier belongs
    Player owner; ///The player controlling this Supplier
    public double[] quantities; ///The quantity of each good supplied
    public double[] prices; ///The price charged for each good per 1 unit

    /**
     * Constructor for Supplier,
     * owned by the given player and belonging to the given marketplace
     * Initializes quantities and prices according to the Data class,
     * setting initial quantities to zero and initial prices to 1
     */
    public Supplier(Marketplace market, Player owner) {
        this.market = market;
        this.owner = owner;
        this.quantities = new double[Data.GOOD_NAMES.length];
        this.prices = new double[Data.GOOD_NAMES.length];
        for (int i = 0; i < Data.GOOD_NAMES.length; i++) {
            this.quantities[i] = 0;
            this.prices[i] = 1;
        }   
    }
    
}