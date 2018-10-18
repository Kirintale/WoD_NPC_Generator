package backgrounds;

public class BackgroundsHuman extends AbstractBackground {
    
    public static final String MENTOR = "Mentor";
    public static final String BACKUP = "Backup";
    public static final String LABORATORY = "Laboratory";
    public static final String LIBRARY = "Library";
    public static final String REQUISITIONS = "Requisitions";
    public static final String SPIES = "Spies";
    
    public BackgroundsHuman() {
        super();
        setBackgroundsValues();
    }
    
    private void setBackgroundsValues() {
        backgrounds.put(BACKUP, INITIAL_BACKGROUND);
        backgrounds.put(MENTOR, INITIAL_BACKGROUND);
        backgrounds.put(LABORATORY, INITIAL_BACKGROUND);
        backgrounds.put(LIBRARY, INITIAL_BACKGROUND);
        backgrounds.put(REQUISITIONS, INITIAL_BACKGROUND);
        backgrounds.put(SPIES, INITIAL_BACKGROUND);
    };
    
}
