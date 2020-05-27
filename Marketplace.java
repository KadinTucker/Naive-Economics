import java.util.ArrayList;

/**
 * The Marketplace class controls how the consumers purchase what they do
 * Represents the consumers' actions with respect to the players'.
 * Each Marketplace can have players opting in or opting out. 
 * Marketplaces act on quantized times; every once in a while a buy action will occur
 * where the consumers will make their various purchases from the available suppliers
 */
public class Marketplace extends Updateable {

    public double wealthPool; ///The total amount of wealth in the marketplace
    private double[] relativeDemand;///The relative demand for each good, indexed according to Data; sums to 1
    private double[] backseatDemand; ///Determiner for relative demand
    ArrayList<Supplier> suppliers; ///All of the suppliers in this marketplace; which suppliers there are can vary

    /**
     * Constructor for Marketplace
     * Initializes all data held within
     */
    public Marketplace() {
        this.backseatDemand = new double[Data.GOOD_NAMES.length];
        for (int i = 1; i < backseatDemand.length; i++) {
            backseatDemand[i] = 1;
        }
        this.updateDemand();
        this.suppliers = new ArrayList<Supplier>();
    }

    /**
     * Implementation of applyUpdate
     * Simply causes the marketplace to take a buy action
     */
    @Override
    public void applyUpdate(double elapsedTime) {

    }

    /**
     * Causes the consumers to buy as many goods as they possibly can desire
     */
    public void buy() {
        double leftover = 0;
        for (int i = 0; i < relativeDemand.length; i++) {
            leftover += purchaseGood(i, relativeDemand[i] * this.wealthPool);
        }
        this.wealthPool = leftover;
    }

    /**
     * Given an amount of wealth with which to buy and a good to buy,
     * Shops among the suppliers and buys as much as it possibly can
     * Returns any leftover money there might have been
     */
    private double purchaseGood(int good, double wealth) {
        while (wealth > 0) {
            Supplier supplier = findCheapest(good);
            if (supplier == null) return wealth;
            double demanded = wealth / supplier.prices[good];
            if (demanded >= supplier.quantities[good]) {
                demanded = supplier.quantities[good];
            }
            wealth -= demanded * supplier.prices[good];
            supplier.owner.addCash(demanded * supplier.prices[good]);
        }
        return 0;
    }

    /**
     * Returns the Supplier providing the cheapest option of the given good
     * Does not count Suppliers who do not have any of this good
     * Returns null if no suppliers have any of this good
     */
    private Supplier findCheapest(int good) {
        Supplier cheapest = null;
        for (Supplier s : this.suppliers) {
            if (s.quantities[good] > 0 && cheapest != null && cheapest.prices[good] > s.prices[good]) {
                cheapest = s;
            }
        }
        return cheapest;
    }

    /**
     * Sets the new demand as backseat demand, and updates the demand
     */
    public void setDemand(double[] newDemand) {
        this.backseatDemand = newDemand;
        this.updateDemand();
    }

    /**
     * Updates the relative demand according to the total demand in the market
     * TODO: set demand for goods of zero quantity to zero (?)
     */
    public void updateDemand() {
        double total = 0;
        for (double d : this.backseatDemand) {
            total += d;
        }
        this.relativeDemand = new double[this.backseatDemand.length];
        for (int i = 0; i < this.relativeDemand.length; i++) {
            this.relativeDemand[i] = this.backseatDemand[i] / total;
        }
    }
    
}