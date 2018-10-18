package template.vampire;

import java.util.Map;

import powers.disciplines.BrujahDiscipline;
import template.CharacterPointDistribution;
import abilities.AbstractKnowledges;
import abilities.AbstractSkills;
import abilities.AbstractTalents;
import backgrounds.BackgroundsHuman;
import backgrounds.BackgroundsVampire20;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;

public class Brujah extends AbstractVampire {
    
    public Brujah(PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        super(pointDistribution, new BrujahDiscipline());
    }
    
    public static String classDescription() {
        return "Brujah";
    }
    
    protected void constructInitialAbilities() {
        
        talentsToGenerate.put(AbstractTalents.ALERTNESS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.ATHLETICS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.BRAWL, ABILITY_START_VALUE);
        talentsToGenerate
                .put(AbstractTalents.INTIMIDATION, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.STREETWISE, ABILITY_START_VALUE);
        
        skillsToGenerate.put(AbstractSkills.MELEE, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.LARCENY, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.STEALTH, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.SURVIVAL, ABILITY_START_VALUE);
        
        knowledgesToGenerate.put(AbstractKnowledges.INVESTIGATION,
                ABILITY_START_VALUE);
        knowledgesToGenerate.put(AbstractKnowledges.LAW, ABILITY_START_VALUE);
        knowledgesToGenerate.put(AbstractKnowledges.MEDICINE,
                ABILITY_START_VALUE);
    }
    
    protected void constructInitialBackgrounds() {
        backgroundsToGenerate.put(BackgroundsVampire20.ALLIES,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.GENERATION,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.RETAINERS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsVampire20.CONTACTS,
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
                pointDistribution.getMaxAttribute(),
                pointDistribution.getMinAttribute(),
                pointDistribution.getMidAttribute(),
                pointDistribution.getMaxAbility(),
                pointDistribution.getMidAbility(),
                pointDistribution.getMinAbility(),
                pointDistribution.getBackgroundPoints(),
                pointDistribution.getSpecialAbility());
    }
}
