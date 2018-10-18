package generators;

import java.util.Map;

import template.CharacterPointDistribution;
import exceptions.NpcGeneratorException;

public class BackgroundsGenerator {
    
    private final IPointDeligator pointDeligator;
    private boolean allowAttributesOfOne;
    
    public BackgroundsGenerator(final IPointDeligator pointDeligator,
            final boolean allowAttributesOfOne) {
        this.pointDeligator = pointDeligator;
    }
    
    public void generateBackgrounds(final Map<String, Integer> backgrounds,
            final CharacterPointDistribution pointDistribution)
            throws NpcGeneratorException {
        
        int remainingPoints = pointDeligator.assignPoints(backgrounds,
                pointDistribution.getBackgroundPoints(), allowAttributesOfOne);
        pointDistribution.setBackgroundPoints(remainingPoints);
    }
}
