package generators;

import java.util.Map;

import exceptions.NpcGeneratorException;

public interface IPointDeligator {
    
    int assignPoints(final Map<String, Integer> attributeMap, final int points,
            final boolean allowAttributesOfOne) throws NpcGeneratorException;
    
}
