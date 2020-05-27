
/**
 * A variant of Production
 * Gains resources over time, up to a maximum amount, then stops growing.
 * Has a certain constant labor intensity
 */
public class SimpleProduction extends Production {
    
    private double available; ///How much resource is available to harvest
    double maximum; ///The maximum amouont of resource available
    double growthRate; ///How much resource grows per minute
    double laborIntensity; ///How much labor it takes per unit produced

    public SimpleProduction(String name, Player owner, int produced, double maximum, double growthRate, double laborIntensity) {
        super(name, owner, produced);
        this.name = name;
        this.laborIntensity = laborIntensity;
        this.growthRate = growthRate;
        this.maximum = maximum;
        this.available = 0;
    }

    /**
     * Produce method for SimpleProduction
     * Produces as much as labor is put in, according to the labor intensity
     * Consumes as much resource as possible given the constraints of labor and the available resource
     */
    @Override
    public double produce(int labor, int[] reagents) {
        double theoretical = labor / laborIntensity;
        if (theoretical > available) {
            this.available = 0;
            return theoretical;
        }
        this.available -= theoretical;
        return theoretical;
    }

    private void updateAvailable(double timeElapsed) {
        this.available += timeElapsed * this.growthRate;
        if (this.available > this.maximum) {
            this.available = this.maximum;
        }
    }

    @Override
    public void applyUpdate(double timeElapsed) {
        this.updateAvailable(timeElapsed);
    }

    public double getAvailable() {
        this.update();
        return this.available;
    }

    /**
     * Implementation of getLabel
     */
    public String getLabel() {
        return this.name;
    }

    /**
     * Implementation of getInfo
     */
    public String getInfo() {
        return "Produces " + Data.GOOD_NAMES[this.produced] + "\nAvailable Resources: " + this.getAvailable() + " / " + this.maximum;
    }

    /**
     * Implementation of createFor from Production
     */
    public Production createFor(Player toOwn) {
        return new SimpleProduction(this.name, toOwn, this.produced, this.maximum, this.growthRate, this.laborIntensity);
    }

}