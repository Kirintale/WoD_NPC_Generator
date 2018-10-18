package abilities;

import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractSkills implements ISkills {
    
    public static final String SURVIVAL = "survival";
    public static final String STEALTH = "stealth";
    public static final String PERFORMANCE = "performance";
    public static final String LARCENY = "larceny";
    public static final String MELEE = "melee";
    public static final String FIREARMS = "firearms";
    public static final String ETIQUETTE = "etiquette";
    public static final String DRIVE = "drive";
    public static final String CRAFTS = "crafts";
    
    protected static int INITIAL_SKILL_VALUE = 0;
    
    protected Map<String, Integer> skills;
    
    public AbstractSkills() {
        skills = new TreeMap<String, Integer>();
        setInitialSkillsValues();
    }
    
    public Map<String, Integer> getSkills() {
        return skills;
    }
    
    private void setInitialSkillsValues() {
        skills.put(CRAFTS, INITIAL_SKILL_VALUE);
        skills.put(DRIVE, INITIAL_SKILL_VALUE);
        skills.put(ETIQUETTE, INITIAL_SKILL_VALUE);
        skills.put(FIREARMS, INITIAL_SKILL_VALUE);
        skills.put(MELEE, INITIAL_SKILL_VALUE);
        skills.put(LARCENY, INITIAL_SKILL_VALUE);
        skills.put(PERFORMANCE, INITIAL_SKILL_VALUE);
        skills.put(STEALTH, INITIAL_SKILL_VALUE);
        skills.put(SURVIVAL, INITIAL_SKILL_VALUE);
    };
}
