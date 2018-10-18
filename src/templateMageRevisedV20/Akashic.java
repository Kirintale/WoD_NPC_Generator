package templateMageRevisedV20;

import java.util.Map;

import power.mage.MageAscension;
import template.CharacterPointDistribution;
import abilities.AbstractKnowledges;
import abilities.AbstractSkills;
import abilities.AbstractTalents;
import backgrounds.BackgroundsHuman;
import backgrounds.BackgroundsMageRevised;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;

public class Akashic extends AbstractMage {
    
    public Akashic(PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        super(pointDistribution, new MageAscension());
    }
    
    public static String classDescription() {
        return "Akashic Brotherhood";
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
        backgroundsToGenerate.put(BackgroundsMageRevised.ALLIES,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsMageRevised.AVATAR,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsMageRevised.ARCANE,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsMageRevised.CONTACTS,
                BACKGROUND_START_VALUE);
    }
    
    @Override
    protected Map<String, Integer> getConstantBackgrounds() {
        Map<String, Integer> backgrounds = getBackgroundStats()
                .getBackgrounds();
        backgrounds.put(BackgroundsHuman.RESOURCES, 1);
        backgrounds.put(BackgroundsMageRevised.AVATAR, 1);
        return backgrounds;
    }
    
    @Override
    protected Map<String, Integer> getConstantDisciplines() {
        Map<String, Integer> spheres = getDisciplines().getSuperPower();
        spheres.put(MageAscension.MIND, 1);
        return spheres;
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
