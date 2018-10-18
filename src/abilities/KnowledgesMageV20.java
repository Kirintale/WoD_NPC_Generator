package abilities;

import java.util.Map;

public class KnowledgesMageV20 extends AbstractKnowledges {
    
    public static final String COSMOLOGY = "Cosmology";
    public static final String ENIGMAS = "Enigmas";
    public static final String TECHNOLOGY = "Technology";
    
    public KnowledgesMageV20() {
        super();
        updateKnowledgeMap();
    }
    
    private void updateKnowledgeMap() {
        final Map<String, Integer> knowledges = getKnowledges();
        knowledges.put(COSMOLOGY, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(ENIGMAS, INITIAL_KNOWLEDGE_VALUE);
        knowledges.put(TECHNOLOGY, INITIAL_KNOWLEDGE_VALUE);
    }
}
