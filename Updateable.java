

/**
 * A very abstract object that keeps track of time and updates itself when necessary
 * Deals with time in minutes
 */
public abstract class Updateable {
    
    long lastUpdated; ///The time when this was last updated

    /**
     * Constructs an Updateable
     * Stores the time at creation
     */
    public Updateable() {
        this.lastUpdated = System.currentTimeMillis();
    }

    /**
     * Returns how many minutes are in however many given milliseconds
     */
    private double getMinutes(long millis) {
        return (double) millis / 6000;
    }

    /**
     * The public method which updates the system
     * Only this method should be used
     */
    public void update() {
        long current = System.currentTimeMillis();
        this.applyUpdate(getMinutes(current - lastUpdated));
        this.lastUpdated = current;
    }

    /**
     * Implementation of what happens when an update occurs; will vary based on the Updateable
     */
    public abstract void applyUpdate(double elapsedTime);

}