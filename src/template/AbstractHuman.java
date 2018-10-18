package template;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import powers.ISuperNaturalAbility;
import abilities.IKnowledges;
import abilities.ISkills;
import abilities.ITalents;
import attributes.Mental;
import attributes.Physical;
import attributes.Social;
import backgrounds.IBackground;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;
import generators.StatGenerator;

public abstract class AbstractHuman {
    
    protected static final int ABILITY_START_VALUE = 0;
    protected static final int BACKGROUND_START_VALUE = 0;
    
    private Physical physical;
    private Social social;
    private Mental mental;
    private IKnowledges knowledges;
    private ISkills skills;
    private ITalents talents;
    private IBackground backgrounds;
    private CharacterPointDistribution pointDistribution;
    protected Map<String, Integer> talentsToGenerate;
    protected Map<String, Integer> skillsToGenerate;
    protected Map<String, Integer> knowledgesToGenerate;
    protected Map<String, Integer> backgroundsToGenerate;
    
    public AbstractHuman(ITalents talent, ISkills skill, IKnowledges knowledge,
            IBackground backgrounds, PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        CharacterPointDistribution pointSpread = convertPointDistrubtion(pointDistribution);
        
        initialiseValues(talent, skill, knowledge, backgrounds, pointSpread);
        constructInitialAbilities();
        constructInitialBackgrounds();
        
        // Note must be performed after constructing the initial abilities
        adjustPointDistrubtionForPreSpent();
        
        StatGenerator.generateAttributes(physical.getAttributtes(),
                social.getAttributtes(), mental.getAttributtes(), pointSpread);
        StatGenerator.generateAbilities(talentsToGenerate, skillsToGenerate,
                knowledgesToGenerate, pointSpread);
        StatGenerator.generateBackgrounds(backgroundsToGenerate, pointSpread);
        
        addRemainingStats();
    }
    
    private void addRemainingStats() {
        talents.getTalents().putAll(talentsToGenerate);
        skills.getSkills().putAll(skillsToGenerate);
        knowledges.getKnowledges().putAll(knowledgesToGenerate);
        backgrounds.getBackgrounds().putAll(backgroundsToGenerate);
        
        addMaps(talents.getTalents(), getConstantTalents());
        addMaps(skills.getSkills(), getConstantSkills());
        addMaps(knowledges.getKnowledges(), getConstantKnowledges());
        addMaps(backgrounds.getBackgrounds(), getConstantBackgrounds());
    }
    
    private void addMaps(Map<String, Integer> coreMap,
            Map<String, Integer> mapToMap) {
        for (Entry<String, Integer> entry : coreMap.entrySet()) {
            if (mapToMap.containsKey(entry.getKey())) {
                entry.setValue(entry.getValue() + mapToMap.get(entry.getKey()));
            }
        }
    }
    
    private void initialiseValues(ITalents talent, ISkills skill,
            IKnowledges knowledge, IBackground backgrounds,
            CharacterPointDistribution pointDistribution) {
        physical = new Physical();
        social = new Social();
        mental = new Mental();
        this.talents = talent;
        this.skills = skill;
        this.knowledges = knowledge;
        this.backgrounds = backgrounds;
        
        talentsToGenerate = new HashMap<String, Integer>();
        skillsToGenerate = new HashMap<String, Integer>();
        knowledgesToGenerate = new HashMap<String, Integer>();
        backgroundsToGenerate = new HashMap<String, Integer>();
        
        this.pointDistribution = pointDistribution;
    }
    
    public Physical getPhysicalStats() {
        return physical;
    }
    
    public Social getSocialStats() {
        return social;
    }
    
    public Mental getMentalStats() {
        return mental;
    }
    
    public ITalents getTalentsStats() {
        return talents;
    }
    
    public ISkills getSkillsStats() {
        return skills;
    }
    
    public IKnowledges getKnowledgesStats() {
        return knowledges;
    }
    
    public IBackground getBackgroundStats() {
        return backgrounds;
    }
    
    // Should refactor this to get special
    public ISuperNaturalAbility getDisciplines() {
        return null;
    };
    
    public CharacterPointDistribution getPointDistribution() {
        return pointDistribution;
    }
    
    protected abstract void constructInitialAbilities();
    
    protected abstract void constructInitialBackgrounds();
    
    protected abstract CharacterPointDistribution convertPointDistrubtion(
            PointDistrubition pointDistribution);
    
    /**
     * Method to be overridden
     */
    protected Map<String, Integer> getConstantTalents() {
        return new HashMap<String, Integer>();
    }
    
    protected Map<String, Integer> getConstantSkills() {
        return new HashMap<String, Integer>();
    }
    
    protected Map<String, Integer> getConstantKnowledges() {
        return new HashMap<String, Integer>();
    }
    
    protected Map<String, Integer> getConstantBackgrounds() {
        return new HashMap<String, Integer>();
    }
    
    private void adjustPointDistrubtionForPreSpent()
            throws NpcGeneratorException {
        int remainingTalentPoints = pointDistribution.getTalentPoints()
                - calculatePredeterminedStatSpend(getConstantTalents());
        pointDistribution.setTalentPoints(remainingTalentPoints);
        int remainingSkillsPoints = pointDistribution.getSkillPoints()
                - calculatePredeterminedStatSpend(getConstantSkills());
        pointDistribution.setSkillPoints(remainingSkillsPoints);
        int remainingKnowledgesPoints = pointDistribution.getKnowledgePoints()
                - calculatePredeterminedStatSpend(getConstantKnowledges());
        pointDistribution.setKnowledgePoints(remainingKnowledgesPoints);
        int remainingBackgroundPoints = pointDistribution.getBackgroundPoints()
                - calculatePredeterminedStatSpend(getConstantBackgrounds());
        pointDistribution.setBackgroundPoints(remainingBackgroundPoints);
    }
    
    protected int calculatePredeterminedStatSpend(Map<String, Integer> stat) {
        if (stat == null) {
            return 0;
        }
        
        int totalPointSpend = 0;
        for (Entry<String, Integer> entry : stat.entrySet()) {
            totalPointSpend += entry.getValue();
        }
        
        return totalPointSpend;
    }
}
