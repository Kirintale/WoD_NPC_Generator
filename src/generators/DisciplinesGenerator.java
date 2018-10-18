package generators;

import java.util.Map;

import template.CharacterPointDistribution;
import exceptions.NpcGeneratorException;

public class DisciplinesGenerator {
    
    private final IPointDeligator pointDeligator;
    
    public DisciplinesGenerator(final IPointDeligator pointDeligator) {
        this.pointDeligator = pointDeligator;
    }
    
    public void generateDisciplines(final Map<String, Integer> discipline,
            final CharacterPointDistribution pointDistribution)
            throws NpcGeneratorException {
        
        int remainingPoints = pointDeligator.assignPoints(discipline,
                pointDistribution.getSpecialPoints(), true);
        pointDistribution.setSpecialPoints(remainingPoints);
    }
}
