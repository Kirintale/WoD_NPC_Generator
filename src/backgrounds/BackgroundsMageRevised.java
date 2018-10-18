package backgrounds;

public class BackgroundsMageRevised extends AbstractBackground {
    
    public static final String ARCANE = "Arcane";
    public static final String AVATAR = "Avatar";
    public static final String DESTINY = "Destiny";
    public static final String DREAM = "Dream";
    public static final String LIBRARY = "Library";
    public static final String NODE = "Node";
    public static final String WONDER = "Wonder";
    
    public BackgroundsMageRevised() {
        super();
        setBackgroundsValues();
    }
    
    private void setBackgroundsValues() {
        backgrounds.put(ARCANE, INITIAL_BACKGROUND);
        backgrounds.put(AVATAR, INITIAL_BACKGROUND);
        backgrounds.put(DESTINY, INITIAL_BACKGROUND);
        backgrounds.put(DREAM, INITIAL_BACKGROUND);
        backgrounds.put(DESTINY, INITIAL_BACKGROUND);
        backgrounds.put(LIBRARY, INITIAL_BACKGROUND);
        backgrounds.put(NODE, INITIAL_BACKGROUND);
        backgrounds.put(WONDER, INITIAL_BACKGROUND);
    };
}
