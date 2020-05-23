

/**
 * An interface which provides some basic information methods
 */
public interface Describable {
    
    /**
     * Returns some sort of labeling for the object;
     * Including a name and other very preliminary information
     */
    public String getLabel();

    /**
     * Returns much more detailed information about the object
     */
    public String getInfo();

}