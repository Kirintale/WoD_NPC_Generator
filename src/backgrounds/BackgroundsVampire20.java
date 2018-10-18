package backgrounds;

public class BackgroundsVampire20 extends AbstractBackground {
    
    public static final String BLACK_HAND_MEMBERSHIP = "Black Hand Membership";
    public static final String DOMAIN = "Domain";
    public static final String HERD = "Herd";
    public static final String GENERATION = "Generation";
    public static final String MENTOR = "Mentor";
    public static final String RITUALS_SABBAT = "Rituals Sabbat";
    
    public BackgroundsVampire20() {
        super();
        setBackgroundsValues();
    }
    
    private void setBackgroundsValues() {
        backgrounds.put(BLACK_HAND_MEMBERSHIP, INITIAL_BACKGROUND);
        backgrounds.put(DOMAIN, INITIAL_BACKGROUND);
        backgrounds.put(HERD, INITIAL_BACKGROUND);
        backgrounds.put(GENERATION, INITIAL_BACKGROUND);
        backgrounds.put(MENTOR, INITIAL_BACKGROUND);
        backgrounds.put(RITUALS_SABBAT, INITIAL_BACKGROUND);
    };
}
