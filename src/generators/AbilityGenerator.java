package generators;

import java.util.Map;

import template.CharacterPointDistribution;
import exceptions.NpcGeneratorException;

public class AbilityGenerator {
    
    private final IPointDeligator pointDeligator;
    
    public AbilityGenerator(final IPointDeligator pointDeligator) {
        this.pointDeligator = pointDeligator;
    }
    
    public void generateAbilities(final Map<String, Integer> talents,
            final Map<String, Integer> skills,
            final Map<String, Integer> knowledges,
            final CharacterPointDistribution pointDistribution)
            throws NpcGeneratorException {
        int remainingPoints = 0;
        
        remainingPoints = pointDeligator.assignPoints(talents,
                pointDistribution.getTalentPoints(), false);
        pointDistribution.setTalentPoints(remainingPoints);
        
        remainingPoints = pointDeligator.assignPoints(skills,
                pointDistribution.getSkillPoints(), false);
        pointDistribution.setSkillPoints(remainingPoints);
        
        remainingPoints = pointDeligator.assignPoints(knowledges,
                pointDistribution.getKnowledgePoints(), false);
        pointDistribution.setKnowledgePoints(remainingPoints);
    }
}
