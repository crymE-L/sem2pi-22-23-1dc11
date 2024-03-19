package pt.ipp.isep.dei.esoft.project.domain;

/**
 * This class serves the purpose of listing the house's characteristics
 * @author Afonso Silva (1221179)
 */
public class House {
    /** If the house has basement or not
     *
     */
    private boolean basement;

    /** If the house has loft area or not
     *
     */
    private boolean loft;

    /** If the house has sun exposure or not
     *
     */
    private SunExposure sunExposure;

    /**
     * The constructor made specifically to create
     * the object House. This constructor contains
     * all the parameters needed at once
     *
     * @param basement
     * @param loft
     * @param sunExposure
     */
    public House(boolean basement, boolean loft, SunExposure sunExposure) {
		setBasement(basement);
		setLoft(loft);
		setSunExposure(sunExposure);
    }

    /**
     * The getter for the house basement
     *
     * @return String
     */
    public boolean getBasement() {
        return basement;
    }

    /**
     * The getter for the house loft
     *
     * @return String
     */
    public boolean getLoft() {
        return loft;
    }

    /**
     * The getter for the house exposure
     *
     * @return String
     */
    public SunExposure getSunExposure() {
        return sunExposure;
    }

    /**
     * The setter for the house basement
     *
     * @param basement
     */
    public void setBasement(boolean basement) {
        this.basement = basement;
    }

    /**
     * The setter for the property name
     *
     * @param loft
     */
    public void setLoft(boolean loft) {
        this.loft = loft;
    }

    /**
     * The setter for the house exposure
     *
     * @param sunExposure
     */
    public void setSunExposure(SunExposure sunExposure) {
        this.sunExposure = sunExposure;
    }
}
