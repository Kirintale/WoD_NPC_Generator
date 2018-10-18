package template;

import exceptions.NpcGeneratorException;

public class CharacterPointDistribution {
    
    private int physicalPoints;
    private int socialPoints;
    private int mentalPoints;
    private int talentPoints;
    private int skillPoints;
    private int knowledgePoints;
    private int backgroundPoints;
    private int specialPoints;
    
    public CharacterPointDistribution(int physicalPoints, int socialPoints,
            int mentalPoints, int talentPoints, int skillPoints,
            int knowledgePoints, int backgroundPoints, int specialPoints) {
        this.physicalPoints = physicalPoints;
        this.socialPoints = socialPoints;
        this.mentalPoints = mentalPoints;
        this.talentPoints = talentPoints;
        this.skillPoints = skillPoints;
        this.knowledgePoints = knowledgePoints;
        this.backgroundPoints = backgroundPoints;
        this.specialPoints = specialPoints;
    }
    
    public int getPhysicalPoints() {
        return physicalPoints;
    }
    
    public void setPhysicalPoints(int physicalPoints) {
        this.physicalPoints = physicalPoints;
    }
    
    public int getSocialPoints() {
        return socialPoints;
    }
    
    public void setSocialPoints(int socialPoints) {
        this.socialPoints = socialPoints;
    }
    
    public int getMentalPoints() {
        return mentalPoints;
    }
    
    public void setMentalPoints(int mentalPoints) {
        this.mentalPoints = mentalPoints;
    }
    
    public int getTalentPoints() {
        return talentPoints;
    }
    
    public void setTalentPoints(int talentPoints) throws NpcGeneratorException {
        validate(talentPoints);
        this.talentPoints = talentPoints;
    }
    
    public int getSkillPoints() {
        return skillPoints;
    }
    
    public void setSkillPoints(int skillPoints) throws NpcGeneratorException {
        validate(talentPoints);
        this.skillPoints = skillPoints;
    }
    
    public int getKnowledgePoints() {
        return knowledgePoints;
    }
    
    public void setKnowledgePoints(int knowledgePoints)
            throws NpcGeneratorException {
        validate(knowledgePoints);
        this.knowledgePoints = knowledgePoints;
    }
    
    public int getBackgroundPoints() {
        return backgroundPoints;
    }
    
    public void setBackgroundPoints(int backgroundPoints)
            throws NpcGeneratorException {
        validate(backgroundPoints);
        this.backgroundPoints = backgroundPoints;
    }
    
    /**
     * @return the specialPoints
     */
    public int getSpecialPoints() {
        return specialPoints;
    }
    
    /**
     * @param specialPoints
     *            the specialPoints to set
     * @throws NpcGeneratorException
     */
    public void setSpecialPoints(int specialPoints)
            throws NpcGeneratorException {
        validate(specialPoints);
        this.specialPoints = specialPoints;
    }
    
    private void validate(int points) throws NpcGeneratorException {
        if (points < 0) {
            throw new NpcGeneratorException(
                    "Can not set a stat to less than 0.");
        }
    }
}
