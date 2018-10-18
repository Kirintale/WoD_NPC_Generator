package core;

public class PointDistrubition {
    
    private String description;
    private int maxAbility;
    private int midAbility;
    private int minAbility;
    private int maxAttribute;
    private int midAttribute;
    private int minAttribute;
    private int backgroundPoints;
    private int specialAbility;
    
    public PointDistrubition(String description, int maxAttribute,
            int midAttribute, int minAttribute, int maxAbility, int midAbility,
            int minAbility, int backgroundPoints, int specialAbility) {
        this.description = description;
        
        this.maxAbility = maxAbility;
        this.midAbility = midAbility;
        this.minAbility = minAbility;
        this.maxAttribute = maxAttribute;
        this.midAttribute = midAttribute;
        this.minAttribute = minAttribute;
        
        this.backgroundPoints = backgroundPoints;
        this.specialAbility = specialAbility;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @return the backgroundPoints
     */
    public int getBackgroundPoints() {
        return backgroundPoints;
    }
    
    /**
     * @return the maxAbility
     */
    public int getMaxAbility() {
        return maxAbility;
    }
    
    /**
     * @return the midAbility
     */
    public int getMidAbility() {
        return midAbility;
    }
    
    /**
     * @return the minAbility
     */
    public int getMinAbility() {
        return minAbility;
    }
    
    /**
     * @return the maxAttribute
     */
    public int getMaxAttribute() {
        return maxAttribute;
    }
    
    /**
     * @return the midAttribute
     */
    public int getMidAttribute() {
        return midAttribute;
    }
    
    /**
     * @return the minAttribute
     */
    public int getMinAttribute() {
        return minAttribute;
    }
    
    /**
     * @return the specialAbility
     */
    public int getSpecialAbility() {
        return specialAbility;
    }
}
