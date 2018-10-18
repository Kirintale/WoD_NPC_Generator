package templateMageRevisedV20;

import java.util.Map;

import power.mage.MageAscension;
import template.CharacterPointDistribution;
import abilities.AbstractSkills;
import abilities.AbstractTalents;
import abilities.KnowledgesMageV20;
import abilities.SkillsMageV20;
import backgrounds.BackgroundsHuman;
import backgrounds.BackgroundsMageRevised;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;

public class Heremetic extends AbstractMage {
    
    public Heremetic(PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        super(pointDistribution, new MageAscension());
    }
    
    public static String classDescription() {
        return "Hemetic";
    }
    
    protected void constructInitialAbilities() {
        
        talentsToGenerate.put(AbstractTalents.ALERTNESS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.ATHLETICS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.AWARENESS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.EMPATHY, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.SUBTERFUGE, ABILITY_START_VALUE);
        
        skillsToGenerate.put(AbstractSkills.FIREARMS, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.ETIQUETTE, ABILITY_START_VALUE);
        skillsToGenerate.put(SkillsMageV20.CRAFTS, ABILITY_START_VALUE);
        
        knowledgesToGenerate
                .put(KnowledgesMageV20.ENIGMAS, ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesMageV20.TECHNOLOGY,
                ABILITY_START_VALUE);
        knowledgesToGenerate
                .put(KnowledgesMageV20.SCIENCE, ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesMageV20.COSMOLOGY,
                ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesMageV20.OCCULT, ABILITY_START_VALUE);
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
        spheres.put(MageAscension.FORCES, 1);
        return spheres;
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
