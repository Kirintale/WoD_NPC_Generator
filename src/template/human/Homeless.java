package template.human;

import java.util.HashMap;
import java.util.Map;

import template.AbstractHuman;
import template.CharacterPointDistribution;
import abilities.AbstractSkills;
import abilities.AbstractTalents;
import abilities.KnowledgesVampire20;
import abilities.SkillsVampire20;
import abilities.TalentsVampire20;
import backgrounds.BackgroundsHuman;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;

public class Homeless extends AbstractHuman {
    
    public Homeless(PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        super(new TalentsVampire20(), new SkillsVampire20(),
                new KnowledgesVampire20(), new BackgroundsHuman(),
                pointDistribution);
    }
    
    public static String classDescription() {
        return "Homeless";
    }
    
    protected void constructInitialAbilities() {
        
        talentsToGenerate.put(AbstractTalents.ALERTNESS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.EMPATHY, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.BRAWL, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.EXPRESSION, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.STREETWISE, ABILITY_START_VALUE);
        
        skillsToGenerate.put(AbstractSkills.PERFORMANCE, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.LARCENY, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.STEALTH, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.CRAFTS, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.SURVIVAL, ABILITY_START_VALUE);
        
        knowledgesToGenerate.put(KnowledgesVampire20.INVESTIGATION,
                ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesVampire20.POLITICS,
                ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesVampire20.MEDICINE,
                ABILITY_START_VALUE);
    }
    
    protected void constructInitialBackgrounds() {
        backgroundsToGenerate.put(BackgroundsHuman.MENTOR,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.CONTACTS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.INFLUENCE,
                BACKGROUND_START_VALUE);
    }
    
    @Override
    protected CharacterPointDistribution convertPointDistrubtion(
            PointDistrubition pointDistribution) {
        return new CharacterPointDistribution(
                pointDistribution.getMaxAttribute(),
                pointDistribution.getMinAttribute(),
                pointDistribution.getMidAttribute(),
                pointDistribution.getMidAbility(),
                pointDistribution.getMaxAbility(),
                pointDistribution.getMinAbility(),
                pointDistribution.getBackgroundPoints(), 0);
    }
    
    protected Map<String, Integer> getConstantTalents() {
        Map<String, Integer> talents = new HashMap<String, Integer>();
        talents.put(AbstractTalents.STREETWISE, 2);
        return talents;
    }
}
