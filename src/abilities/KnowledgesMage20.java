package abilities;

import java.util.Map;

public class KnowledgesMage20 extends AbstractKnowledges {
    
    public static final String COSMOLOGY = "cosmology";
    public static final String ENIGMAS = "enigmas";
    public static final String ESTOTERICA = "estoterica";
    public static final String POLITICS = "politics";
    
    public KnowledgesMage20() {
        super();
        updateKnowledgeMap();
    }
    
    private void updateKnowledgeMap() {
        final Map<String, Integer> knowledges = getKnowledges();
        knowledges.put(COSMOLOGY, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(ENIGMAS, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(ESTOTERICA, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(POLITICS, INITIAL_KNOWLEDGE_VALUE);
    }
}
