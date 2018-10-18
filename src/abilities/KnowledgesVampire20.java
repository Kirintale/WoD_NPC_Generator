package abilities;

import java.util.Map;

public class KnowledgesVampire20 extends AbstractKnowledges {
    
    public static final String FINANCE = "finance";
    public static final String POLITICS = "politics";
    public static final String TECHNOLOGY = "technology";
    
    public KnowledgesVampire20() {
        super();
        updateKnowledgeMap();
    }
    
    private void updateKnowledgeMap() {
        Map<String, Integer> knowledges = getKnowledges();
        knowledges.put(FINANCE, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(POLITICS, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(TECHNOLOGY, INITIAL_KNOWLEDGE_VALUE);
    }
}
