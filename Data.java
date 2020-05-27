

/**
 * Class comprising the static data in the game and various useful resources
 * Temporarily has static definitions, eventually will have these placed in data files and loaded
 */
public class Data {
    
    ///The names of every good, indexed by id
    public static final String[] GOOD_NAMES = {"null", "Fire Wheat", "Ice Ferns", "Toxic Celery", "Evil Cabbage"};

    ///A list of production templates, which are used to copy to players
    ///Needs to be initialized at runtime
    public static Production[] RECIPES;

    /**
     * Temporary method to initialize recipes
     * Will be replaced with an initialize which reads from data files
     */
    public static void initialize() {
        RECIPES = new Production[4];
        RECIPES[0] = new SimpleProduction("Fire Wheat Farm", null, 1, 60, 1, 2);
        RECIPES[1] = new SimpleProduction("Ice Fern Field", null, 2, 60, 0.75, 2);
        RECIPES[2] = new SimpleProduction("Toxic Celery Farm", null, 2, 60, 1, 3);
        RECIPES[3] = new SimpleProduction("Evil Cabbage Plantation", null, 2, 40, 1, 2);
    }

}