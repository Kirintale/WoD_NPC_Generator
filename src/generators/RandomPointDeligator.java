package generators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import exceptions.NpcGeneratorException;

public class RandomPointDeligator implements IPointDeligator {
    
    private static int iteration;
    private final int maximumStatAllowed;
    private final Random randomNumberGenerator;
    
    /**
     * Constructor
     * 
     * @param maximumStatValue
     */
    public RandomPointDeligator(final int maximumStatValue) {
        this.maximumStatAllowed = maximumStatValue;
        iteration = 0;
        
        // Set up a random number generator seeded on the current time
        randomNumberGenerator = new Random();
        randomNumberGenerator.setSeed(Calendar.getInstance().getTimeInMillis());
    }
    
    public int assignPoints(final Map<String, Integer> attributeMap,
            final int points, final boolean allowAttributesOfOne)
            throws NpcGeneratorException {
        
        int remainingPoints = points;
        
        // Randomise the order of the stats
        final Map<String, Integer> randomOrderAttributeMap = randomiseAttributeOrder(attributeMap);
        
        // Distribute points evenly if it iterates too many times.
        if (iteration >= 5) {
            remainingPoints = setPointsEvenly(randomOrderAttributeMap, points);
            attributeMap.putAll(randomOrderAttributeMap);
            iteration = 0;
            return remainingPoints;
        } else {
            iteration++;
        }
        
        remainingPoints = checkAllowAttributesOfOne(randomOrderAttributeMap,
                allowAttributesOfOne, remainingPoints);
        
        Iterator<Entry<String, Integer>> attributeEntryIterator = randomOrderAttributeMap
                .entrySet().iterator();
        while (attributeEntryIterator.hasNext()) {
            
            final Entry<String, Integer> entry = attributeEntryIterator.next();
            
            if (attributeEntryIterator.hasNext()) {
                int newAttributeAddedValue = calculateAllocatedStatValue(entry);
                newAttributeAddedValue = Math.min(remainingPoints,
                        newAttributeAddedValue);
                remainingPoints = remainingPoints - newAttributeAddedValue;
                entry.setValue(newAttributeAddedValue + entry.getValue());
            } else {
                if (remainingPoints + entry.getValue() > maximumStatAllowed) {
                    remainingPoints = assignPoints(attributeMap, points,
                            allowAttributesOfOne);
                    return remainingPoints;
                }
                
                entry.setValue(remainingPoints + entry.getValue());
                remainingPoints -= remainingPoints;
            }
        }
        
        attributeMap.putAll(randomOrderAttributeMap);
        return remainingPoints;
    }
    
    /**
     * Create the allocate value for the stat
     * 
     * @param entry
     * @return
     */
    private int calculateAllocatedStatValue(final Entry<String, Integer> entry) {
        final double maximumStatAllocation = (double) (maximumStatAllowed - entry
                .getValue());
        int newAttributeAddedValue = (int) Math.ceil(randomNumberGenerator
                .nextDouble() * maximumStatAllocation);
        
        // If zero set to 1
        if (newAttributeAddedValue == 0) {
            newAttributeAddedValue = 1;
        }
        
        // Ensure no stat is greater than MAXIMUM_STAT_VALUE
        if (newAttributeAddedValue + entry.getValue() > maximumStatAllowed) {
            newAttributeAddedValue = maximumStatAllowed - entry.getValue();
        }
        
        return newAttributeAddedValue;
    }
    
    /**
     * Check if allowed attributes of one are allowed and if so update any value
     * of one in the map to two
     * 
     * @param attributeMap
     * @param allowAttributesOfOne
     * @param remainingPoints
     * @return
     */
    private int checkAllowAttributesOfOne(
            final Map<String, Integer> attributeMap,
            final boolean allowAttributesOfOne, int remainingPoints) {
        
        if (!allowAttributesOfOne) {
            
            int additionalPointsUsed = 0;
            for (final Entry<String, Integer> entry : attributeMap.entrySet()) {
                if (entry.getValue() == 1) {
                    entry.setValue(2);
                    additionalPointsUsed++;
                }
            }
            
            remainingPoints -= additionalPointsUsed;
        }
        return remainingPoints;
    }
    
    /**
     * Shuffle the order the stats are drawn in
     * 
     * @param attributeMap
     * @return
     */
    private Map<String, Integer> randomiseAttributeOrder(
            final Map<String, Integer> attributeMap) {
        final Map<String, Integer> returnedMap = new HashMap<String, Integer>();
        
        final List<String> keys = new ArrayList<String>(attributeMap.keySet());
        
        final int numberOfShuffles = (int) Math.ceil(randomNumberGenerator
                .nextDouble() * 100.0);
        
        for (int i = 0; i <= numberOfShuffles; i++) {
            Collections.shuffle(keys);
        }
        
        for (final String string : keys) {
            // Access keys/values in a random order
            returnedMap.put(string, attributeMap.get(string));
        }
        
        return returnedMap;
    }
    
    /**
     * Set the points evenly among each stat
     * 
     * @param statMap
     * @param points
     * @return remaining points
     * @throws NpcGeneratorException
     */
    private int setPointsEvenly(final Map<String, Integer> statMap, int points)
            throws NpcGeneratorException {
        int pointsPerStat = (int) Math.ceil(points / statMap.size());
        
        final Iterator<Entry<String, Integer>> statIterator = statMap
                .entrySet().iterator();
        while (statIterator.hasNext()) {
            final Entry<String, Integer> entry = statIterator.next();
            
            pointsPerStat += entry.getValue();
            
            // Check the points are valid
            if (pointsPerStat > maximumStatAllowed) {
                pointsPerStat = maximumStatAllowed;
            }
            
            if (statIterator.hasNext()) {
                entry.setValue(pointsPerStat);
                points = Math.max(points - pointsPerStat, 0);
            } else {
                if (points + entry.getValue() <= maximumStatAllowed) {
                    entry.setValue(points + entry.getValue());
                    return 0;
                } else {
                    entry.setValue(maximumStatAllowed);
                    points = Math.max(points - maximumStatAllowed, 0);
                }
            }
        }
        
        return points;
    }
}
