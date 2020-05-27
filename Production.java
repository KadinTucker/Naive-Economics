

/**
 * An object representing a method of production for some good,
 * for example a factory, farm, etc.
 */
abstract class Production extends Updateable implements Describable {

    String name; ///The name of this production
    Player owner; ///The player who owns this production
    int produced; ///The identifier of what good is produced via this production

    public Production(String name, Player owner, int produced) {
        super();
        this.owner = owner;
        this.produced = produced;
        this.name = name;
    }

    /**
     * Returns how much of a good is produced given however much labor and reagents are available for production
     */
    abstract double produce(int labor, int[] reagents);

    /**
     * Creates a production object copying this one's template
     * Does not copy any data unique to the instance;
     * For the abstract Production, this means just the owner
     */
    abstract Production createFor(Player toOwn);

}