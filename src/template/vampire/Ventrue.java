package template.vampire;

import java.util.Map;

import powers.disciplines.VentrueDisciplines;
import template.CharacterPointDistribution;
import abilities.AbstractKnowledges;
import abilities.AbstractSkills;
import abilities.AbstractTalents;
import abilities.KnowledgesVampire20;
import backgrounds.BackgroundsHuman;
import backgrounds.BackgroundsVampire20;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;

public class Ventrue extends AbstractVampire {
    
    private static final int ABILITY_START_VALUE = 0;
    private static final int BACKGROUND_START_VALUE = 0;
    
    public Ventrue(PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        super(pointDistribution, new VentrueDisciplines());
    }
    
    public static String classDescription() {
        return "Ventrue";
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
        backgroundsToGenerate.put(BackgroundsVampire20.ALLIES,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.RESOURCES,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.INFLUENCE,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.RETAINERS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.CONTACTS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.GENERATION,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.HERD,
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
                pointDistribution.getBackgroundPoints(),
                pointDistribution.getSpecialAbility());
    }
}
