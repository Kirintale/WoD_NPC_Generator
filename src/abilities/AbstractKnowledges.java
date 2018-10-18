package abilities;

import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractKnowledges implements IKnowledges {
    
    public static final String SCIENCE = "Science";
    public static final String OCCULT = "Occult";
    public static final String MEDICINE = "Medicine";
    public static final String LAW = "Law";
    public static final String INVESTIGATION = "Investigation";
    public static final String COMPUTER = "Computer";
    public static final String ACADEMICS = "Academics";
    
    protected static int INITIAL_KNOWLEDGE_VALUE = 0;
    
    protected Map<String, Integer> knowledges;
    
    public AbstractKnowledges() {
        knowledges = new TreeMap<String, Integer>();
        setInitialKnowledgesValues();
    }
    
    public Map<String, Integer> getKnowledges() {
        return knowledges;
    }
    
    private void setInitialKnowledgesValues() {
        knowledges.put(ACADEMICS, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(COMPUTER, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(INVESTIGATION, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(LAW, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(MEDICINE, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(OCCULT, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(SCIENCE, INITIAL_KNOWLEDGE_VALUE);
    };
}
