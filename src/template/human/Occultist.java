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

public class Occultist extends AbstractHuman {
    
    public Occultist(PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        super(new TalentsVampire20(), new SkillsVampire20(),
                new KnowledgesVampire20(), new BackgroundsHuman(),
                pointDistribution);
    }
    
    public static String classDescription() {
        return "Occultist";
    }
    
    protected void constructInitialAbilities() {
        
        talentsToGenerate.put(AbstractTalents.ALERTNESS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.AWARENESS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.EXPRESSION, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.EMPATHY, ABILITY_START_VALUE);
        
        skillsToGenerate.put(AbstractSkills.CRAFTS, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.MELEE, ABILITY_START_VALUE);
        
        knowledgesToGenerate.put(KnowledgesVampire20.INVESTIGATION,
                ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesVampire20.OCCULT,
                ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesVampire20.MEDICINE,
                ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesVampire20.SCIENCE,
                ABILITY_START_VALUE);
    }
    
    protected void constructInitialBackgrounds() {
        backgroundsToGenerate.put(BackgroundsHuman.MENTOR,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.CONTACTS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.RETAINERS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.LIBRARY,
                BACKGROUND_START_VALUE);
    }
    
    @Override
    protected Map<String, Integer> getConstantBackgrounds() {
        Map<String, Integer> brawlerBackgrounds = getBackgroundStats()
                .getBackgrounds();
        brawlerBackgrounds.put(BackgroundsHuman.RESOURCES, 1);
        return brawlerBackgrounds;
    }
    
    @Override
    protected CharacterPointDistribution convertPointDistrubtion(
            PointDistrubition pointDistribution) {
        return new CharacterPointDistribution(
                pointDistribution.getMinAttribute(),
                pointDistribution.getMidAttribute(),
                pointDistribution.getMaxAttribute(),
                pointDistribution.getMidAbility(),
                pointDistribution.getMinAbility(),
                pointDistribution.getMaxAbility(),
                pointDistribution.getBackgroundPoints(), 0);
    }
    
    protected Map<String, Integer> getConstantTalents() {
        Map<String, Integer> talents = new HashMap<String, Integer>();
        talents.put(AbstractTalents.STREETWISE, 2);
        return talents;
    }
    
}
