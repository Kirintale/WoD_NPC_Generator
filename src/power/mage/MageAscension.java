package power.mage;

import java.util.HashMap;
import java.util.Map;

import powers.ISuperNaturalAbility;

public class MageAscension implements ISuperNaturalAbility {
    
    Map<String, Integer> magic;
    public static final String CORRESPONDENCE = "Correspondence";
    public static final String ENTROPY = "Entropy";
    public static final String FORCES = "Forces";
    public static final String LIFE = "Life";
    public static final String MATTER = "Matter";
    public static final String MIND = "Mind";
    public static final String PRIME = "Prime";
    public static final String SPIRIT = "Spirit";
    public static final String TIME = "Time";
    public static final Integer INITIAL_MAGIC_VALUE = 0;
    
    public MageAscension() {
        magic = new HashMap<String, Integer>();
        magic.put(CORRESPONDENCE, INITIAL_MAGIC_VALUE);
        magic.put(ENTROPY, INITIAL_MAGIC_VALUE);
        magic.put(FORCES, INITIAL_MAGIC_VALUE);
        magic.put(LIFE, INITIAL_MAGIC_VALUE);
        magic.put(MATTER, INITIAL_MAGIC_VALUE);
        magic.put(MIND, INITIAL_MAGIC_VALUE);
        magic.put(PRIME, INITIAL_MAGIC_VALUE);
        magic.put(SPIRIT, INITIAL_MAGIC_VALUE);
        magic.put(TIME, INITIAL_MAGIC_VALUE);
    }
    
    @Override
    public Map<String, Integer> getSuperPower() {
        return magic;
    }
    
}
