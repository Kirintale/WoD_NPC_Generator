package abilities;

import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractTalents implements ITalents {
    
    public static final String SUBTERFUGE = "Subterfuge";
    public static final String STREETWISE = "Streetwise";
    public static final String LEADERSHIP = "Leadership";
    public static final String INTIMIDATION = "Intimidation";
    public static final String EXPRESSION = "Expression";
    public static final String EMPATHY = "Empathy";
    public static final String BRAWL = "Brawl";
    public static final String AWARENESS = "Awareness";
    public static final String ATHLETICS = "Athletics";
    public static final String ALERTNESS = "Alertness";
    
    protected Map<String, Integer> talents;
    
    protected static int INITIAL_TALENTS_VALUE = 0;
    
    public AbstractTalents() {
        talents = new TreeMap<String, Integer>();
        setInitialTalentsValue();
    }
    
    public Map<String, Integer> getTalents() {
        return talents;
    }
    
    private void setInitialTalentsValue() {
        talents.put(ALERTNESS, INITIAL_TALENTS_VALUE);
        talents.put(ATHLETICS, INITIAL_TALENTS_VALUE);
        talents.put(AWARENESS, INITIAL_TALENTS_VALUE);
        talents.put(BRAWL, INITIAL_TALENTS_VALUE);
        talents.put(EMPATHY, INITIAL_TALENTS_VALUE);
        talents.put(EXPRESSION, INITIAL_TALENTS_VALUE);
        talents.put(INTIMIDATION, INITIAL_TALENTS_VALUE);
        talents.put(LEADERSHIP, INITIAL_TALENTS_VALUE);
        talents.put(STREETWISE, INITIAL_TALENTS_VALUE);
        talents.put(SUBTERFUGE, INITIAL_TALENTS_VALUE);
    }
}
