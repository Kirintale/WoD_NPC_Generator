package templateMageRevisedV20;

import java.util.Map;

import power.mage.MageAscension;
import template.CharacterPointDistribution;
import abilities.AbstractSkills;
import abilities.AbstractTalents;
import abilities.KnowledgesMageV20;
import abilities.SkillsMageV20;
import backgrounds.BackgroundsTechnocracyRevised;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;

public class VoidEngineer extends AbstractMage {
    
    public VoidEngineer(PointDistrubition pointDistribution)
            throws NpcGeneratorException {
        super(pointDistribution, new MageAscension());
    }
    
    public static String classDescription() {
        return "VoidEngineer";
    }
    
    protected void constructInitialAbilities() {
        
        talentsToGenerate.put(AbstractTalents.ALERTNESS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.ATHLETICS, ABILITY_START_VALUE);
        talentsToGenerate.put(AbstractTalents.AWARENESS, ABILITY_START_VALUE);
        
        skillsToGenerate.put(AbstractSkills.FIREARMS, ABILITY_START_VALUE);
        skillsToGenerate.put(AbstractSkills.STEALTH, ABILITY_START_VALUE);
        skillsToGenerate.put(SkillsMageV20.MELEE, ABILITY_START_VALUE);
        
        knowledgesToGenerate
                .put(KnowledgesMageV20.ENIGMAS, ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesMageV20.TECHNOLOGY,
                ABILITY_START_VALUE);
        knowledgesToGenerate
                .put(KnowledgesMageV20.SCIENCE, ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesMageV20.COSMOLOGY,
                ABILITY_START_VALUE);
        knowledgesToGenerate.put(KnowledgesMageV20.COMPUTER,
                ABILITY_START_VALUE);
    }
    
    protected void constructInitialBackgrounds() {
        backgroundsToGenerate.put(BackgroundsTechnocracyRevised.RESOURCES,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsTechnocracyRevised.GENIUS,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsTechnocracyRevised.HYPERCRAM,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsTechnocracyRevised.CLOAKING,
                BACKGROUND_START_VALUE);
        backgroundsToGenerate.put(BackgroundsTechnocracyRevised.REQUISITIONS,
                BACKGROUND_START_VALUE);
    }
    
    @Override
    protected Map<String, Integer> getConstantBackgrounds() {
        Map<String, Integer> backgrounds = getBackgroundStats()
                .getBackgrounds();
        backgrounds.put(BackgroundsTechnocracyRevised.RESOURCES, 1);
        backgrounds.put(BackgroundsTechnocracyRevised.GENIUS, 1);
        return backgrounds;
    }
    
    @Override
    protected Map<String, Integer> getConstantDisciplines() {
        Map<String, Integer> spheres = getDisciplines().getSuperPower();
        spheres.put(MageAscension.SPIRIT, 1);
        return spheres;
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
                pointDistribution.getBackgroundPoints(),
                pointDistribution.getSpecialAbility());
    }
}
