package abilities;

public class SkillsMageV20 extends AbstractSkills {
    
    private static final String MEDITATION = "Meditation";
    
    public SkillsMageV20() {
        super();
        updateKnowledgeMap();
    }
    
    private void updateKnowledgeMap() {
        getSkills().put(MEDITATION, INITIAL_SKILL_VALUE);
    }
}
