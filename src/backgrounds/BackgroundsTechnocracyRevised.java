package backgrounds;

public class BackgroundsTechnocracyRevised extends AbstractBackground {
    
    public static final String BACKUP = "Backup";
    public static final String CLOAKING = "Cloaking";
    public static final String COMPANION = "Companion";
    public static final String CONSTRUCT = "Construct";
    public static final String DESTINY = "Destiny";
    public static final String DEVICE = "Device";
    public static final String ENHANCEMENT = "Enhancement";
    public static final String GENIUS = "Genius";
    public static final String HYPERCRAM = "Hypercram";
    public static final String LABORATORY = "Laboratory";
    public static final String LIBRARY = "Library";
    public static final String MENTOR = "Mentor";
    public static final String NODE = "Node";
    public static final String PATRON = "Patron";
    public static final String REQUISITIONS = "Requisitions";
    public static final String SECRET_WEAPONS = "Secret Weapons";
    public static final String SPIES = "Spies";
    
    public BackgroundsTechnocracyRevised() {
        super();
        setBackgroundsValues();
    }
    
    private void setBackgroundsValues() {
        backgrounds.put(BACKUP, INITIAL_BACKGROUND);
        backgrounds.put(CLOAKING, INITIAL_BACKGROUND);
        backgrounds.put(COMPANION, INITIAL_BACKGROUND);
        backgrounds.put(CONSTRUCT, INITIAL_BACKGROUND);
        backgrounds.put(DESTINY, INITIAL_BACKGROUND);
        backgrounds.put(DEVICE, INITIAL_BACKGROUND);
        backgrounds.put(ENHANCEMENT, INITIAL_BACKGROUND);
        backgrounds.put(GENIUS, INITIAL_BACKGROUND);
        backgrounds.put(HYPERCRAM, INITIAL_BACKGROUND);
        backgrounds.put(LABORATORY, INITIAL_BACKGROUND);
        backgrounds.put(LIBRARY, INITIAL_BACKGROUND);
        backgrounds.put(MENTOR, INITIAL_BACKGROUND);
        backgrounds.put(NODE, INITIAL_BACKGROUND);
        backgrounds.put(PATRON, INITIAL_BACKGROUND);
        backgrounds.put(REQUISITIONS, INITIAL_BACKGROUND);
        backgrounds.put(SECRET_WEAPONS, INITIAL_BACKGROUND);
        backgrounds.put(SPIES, INITIAL_BACKGROUND);
    };
    
}
