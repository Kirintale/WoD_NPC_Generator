package templateMageRevisedV20;

import java.util.HashMap;
import java.util.Map;

import powers.ISuperNaturalAbility;
import template.AbstractHuman;
import abilities.KnowledgesMageV20;
import abilities.SkillsMageV20;
import abilities.TalentsMageV20;
import backgrounds.BackgroundsMageRevised;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;
import generators.StatGenerator;

public abstract class AbstractMage extends AbstractHuman {
    
    private ISuperNaturalAbility magic;
    
    public AbstractMage(PointDistrubition pointDistribution,
            ISuperNaturalAbility disciplines) throws NpcGeneratorException {
        super(new TalentsMageV20(), new SkillsMageV20(),
                new KnowledgesMageV20(), new BackgroundsMageRevised(),
                pointDistribution);
        this.magic = disciplines;
        adjustPointDistrubtionForPreSpent();
        
        StatGenerator.generateDisciplines(disciplines.getSuperPower(),
                getPointDistribution());
        addRemainingStats();
    }
    
    public ISuperNaturalAbility getDisciplines() {
        return magic;
    }
    
    protected Map<String, Integer> getConstantDisciplines() {
        return new HashMap<String, Integer>();
    }
    
    private void adjustPointDistrubtionForPreSpent()
            throws NpcGeneratorException {
        int remainingPoints = getPointDistribution().getSpecialPoints()
                - calculatePredeterminedStatSpend(getDisciplines()
                        .getSuperPower());
        getPointDistribution().setSpecialPoints(remainingPoints);
    }
    
    private void addRemainingStats() {
        magic.getSuperPower().putAll(getConstantDisciplines());
    }
}
