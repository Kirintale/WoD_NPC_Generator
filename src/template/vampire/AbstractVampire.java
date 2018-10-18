package template.vampire;

import java.util.HashMap;
import java.util.Map;

import powers.ISuperNaturalAbility;
import template.AbstractHuman;
import abilities.KnowledgesVampire20;
import abilities.SkillsVampire20;
import abilities.TalentsVampire20;
import backgrounds.BackgroundsVampire20;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;
import generators.StatGenerator;

public abstract class AbstractVampire extends AbstractHuman {
    
    private ISuperNaturalAbility disciplines;
    
    public AbstractVampire(PointDistrubition pointDistribution,
            ISuperNaturalAbility disciplines) throws NpcGeneratorException {
        super(new TalentsVampire20(), new SkillsVampire20(),
                new KnowledgesVampire20(), new BackgroundsVampire20(),
                pointDistribution);
        this.disciplines = disciplines;
        adjustPointDistrubtionForPreSpent();
        
        StatGenerator.generateDisciplines(disciplines.getSuperPower(),
                getPointDistribution());
        addRemainingStats();
    }
    
    public ISuperNaturalAbility getDisciplines() {
        return disciplines;
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
        disciplines.getSuperPower().putAll(getConstantDisciplines());
    }
}
