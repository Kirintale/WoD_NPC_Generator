package backgrounds;

import java.util.Map;
import java.util.TreeMap;

public class AbstractBackground implements IBackground {
    
    public static final String ALLIES = "Allies";
    public static final String ALTERNATE_IDENTITY = "Alternate Identity";
    public static final String CONTACTS = "Contacts";
    public static final String FAME = "Fame";
    public static final String INFLUENCE = "Influence";
    public static final String RESOURCES = "Resources";
    public static final String RETAINERS = "Retainers";
    
    protected static int INITIAL_BACKGROUND = 0;
    
    protected Map<String, Integer> backgrounds;
    
    public AbstractBackground() {
        backgrounds = new TreeMap<String, Integer>();
        setInitialBackgroundsValues();
    }
    
    public Map<String, Integer> getBackgrounds() {
        return backgrounds;
    }
    
    private void setInitialBackgroundsValues() {
        backgrounds.put(ALLIES, INITIAL_BACKGROUND);
        backgrounds.put(ALTERNATE_IDENTITY, INITIAL_BACKGROUND);
        backgrounds.put(CONTACTS, INITIAL_BACKGROUND);
        backgrounds.put(FAME, INITIAL_BACKGROUND);
        backgrounds.put(INFLUENCE, INITIAL_BACKGROUND);
        backgrounds.put(RESOURCES, INITIAL_BACKGROUND);
        backgrounds.put(RETAINERS, INITIAL_BACKGROUND);
    };
}
