package powers.disciplines;

import java.util.HashMap;
import java.util.Map;

import powers.ISuperNaturalAbility;

public class BrujahDiscipline implements ISuperNaturalAbility {
    
    public BrujahDiscipline() {
        discipline.put(DisciplineList.POTENCE,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.FORTITUDE,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.PRESENCE,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
    }
    
    Map<String, Integer> discipline = new HashMap<String, Integer>();
    
    @Override
    public Map<String, Integer> getSuperPower() {
        return discipline;
    }
    
}
