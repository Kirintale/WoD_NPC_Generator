package template.vampire;

import java.util.HashMap;
import java.util.Map;

import powers.disciplines.TremereDisciplines;
import template.CharacterPointDistribution;
import abilities.AbstractSkills;
import abilities.AbstractTalents;
import abilities.KnowledgesVampire20;
import backgrounds.BackgroundsHuman;
import backgrounds.BackgroundsVampire20;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;

public class Tremere extends AbstractVampire {
    
    public Tremere(PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        super(pointDistribution, new TremereDisciplines());
    }
    
    public static String classDescription() {
        return "Tremere";
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
        backgroundsToGenerate.put(BackgroundsVampire20.MENTOR,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.CONTACTS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.RETAINERS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.HERD,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.GENERATION,
                BACKGROUND_START_VALUE);
    }
    
    @Override
    protected Map<String, Integer> getConstantBackgrounds() {
        Map<String, Integer> brawlerBackgrounds = getBackgroundStats()
                .getBackgrounds();
        brawlerBackgrounds.put(BackgroundsHuman.RESOURCES, 1);
        return brawlerBackgrounds;
    }
    
    protected Map<String, Integer> getConstantKnowledges() {
        Map<String, Integer> talents = new HashMap<String, Integer>();
        talents.put(KnowledgesVampire20.OCCULT, 1);
        return talents;
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
                pointDistribution.getBackgroundPoints(),
                pointDistribution.getSpecialAbility());
    }
}
