package template.human;

import java.util.Map;

import template.AbstractHuman;
import template.CharacterPointDistribution;
import abilities.AbstractKnowledges;
import abilities.AbstractSkills;
import abilities.AbstractTalents;
import abilities.KnowledgesVampire20;
import abilities.SkillsVampire20;
import abilities.TalentsVampire20;
import backgrounds.BackgroundsHuman;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;

public class Politician extends AbstractHuman {
    
    private static final int ABILITY_START_VALUE = 0;
    private static final int BACKGROUND_START_VALUE = 0;
    
    public Politician(PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        super(new TalentsVampire20(), new SkillsVampire20(),
                new KnowledgesVampire20(), new BackgroundsHuman(),
                pointDistribution);
    }
    
    public static String classDescription() {
        return "Politician";
    }
    
    protected void constructInitialAbilities() {
        
        talentsToGenerate.put(AbstractTalents.ALERTNESS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.EXPRESSION, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.LEADERSHIP, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.SUBTERFUGE, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.EMPATHY, ABILITY_START_VALUE);
        
        skillsToGenerate.put(AbstractSkills.DRIVE, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.ETIQUETTE, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.PERFORMANCE, ABILITY_START_VALUE);
        
        knowledgesToGenerate.put(KnowledgesVampire20.FINANCE,
                ABILITY_START_VALUE);
        knowledgesToGenerate.put(AbstractKnowledges.LAW, ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesVampire20.POLITICS,
                ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesVampire20.ACADEMICS,
                ABILITY_START_VALUE);
    }
    
    protected void constructInitialBackgrounds() {
        backgroundsToGenerate.put(BackgroundsHuman.ALLIES,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.RESOURCES,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.INFLUENCE,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.RETAINERS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.CONTACTS,
                BACKGROUND_START_VALUE);
    }
    
    @Override
    protected Map<String, Integer> getConstantBackgrounds() {
        Map<String, Integer> brawlerBackgrounds = getBackgroundStats()
                .getBackgrounds();
        brawlerBackgrounds.put(BackgroundsHuman.RESOURCES, 2);
        return brawlerBackgrounds;
    }
    
    @Override
    protected CharacterPointDistribution convertPointDistrubtion(
            PointDistrubition pointDistribution) {
        return new CharacterPointDistribution(
                pointDistribution.getMinAttribute(),
                pointDistribution.getMaxAttribute(),
                pointDistribution.getMidAttribute(),
                pointDistribution.getMaxAttribute(),
                pointDistribution.getMinAttribute(),
                pointDistribution.getMidAttribute(),
                pointDistribution.getBackgroundPoints(), 0);
    }
}
