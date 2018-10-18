package generators;

import java.util.Map;

import template.CharacterPointDistribution;
import exceptions.NpcGeneratorException;

public class AttributeGenerator {
    
    private final IPointDeligator pointDeligator;
    private boolean allowAttributesOfOne;
    
    public AttributeGenerator(final IPointDeligator pointDeligator,
            final boolean allowAttributesOfOne) {
        this.pointDeligator = pointDeligator;
        this.allowAttributesOfOne = allowAttributesOfOne;
    }
    
    public void generateAttributes(final Map<String, Integer> physical,
            final Map<String, Integer> social,
            final Map<String, Integer> mental,
            final CharacterPointDistribution pointDistribution)
            throws NpcGeneratorException {
        int remainingPoints = 0;
        
        remainingPoints = pointDeligator.assignPoints(physical,
                pointDistribution.getPhysicalPoints(), allowAttributesOfOne);
        pointDistribution.setPhysicalPoints(remainingPoints);
        
        remainingPoints = pointDeligator.assignPoints(social,
                pointDistribution.getSocialPoints(), allowAttributesOfOne);
        pointDistribution.setSocialPoints(remainingPoints);
        
        remainingPoints = pointDeligator.assignPoints(mental,
                pointDistribution.getMentalPoints(), allowAttributesOfOne);
        pointDistribution.setMentalPoints(remainingPoints);
    }
    
    public boolean getAllowAttributesOfOne() {
        return allowAttributesOfOne;
    }
    
    public void setAllowAttributesOfOne(final boolean allowAttributesOfOne) {
        this.allowAttributesOfOne = allowAttributesOfOne;
    }
}
