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

public class Brawler extends AbstractHuman {
    
    public Brawler(PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        super(new TalentsVampire20(), new SkillsVampire20(),
                new KnowledgesVampire20(), new BackgroundsHuman(),
                pointDistribution);
    }
    
    public static String classDescription() {
        return "Brawler";
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
        backgroundsToGenerate.put(BackgroundsHuman.ALLIES,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.ALTERNATE_IDENTITY,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.BACKUP,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate
                .put(BackgroundsHuman.FAME, BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.RETAINERS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsHuman.CONTACTS,
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
                pointDistribution.getBackgroundPoints(), 0);
    }
}
