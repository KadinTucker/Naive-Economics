

/**
 * An object representing a method of production for some good,
 * for example a factory, farm, etc.
 */
abstract class Production extends Updateable {

    Player owner; ///The player who owns this production
    int produced; ///The identifier of what good is produced via this production

    public Production(Player owner, int produced) {
        super();
        this.owner = owner;
        this.produced = produced;
    }

    /**
     * Returns how much of a good is produced given however much labor and reagents are available for production
     */
    abstract double produce(int labor, int[] reagents);

}