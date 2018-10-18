package powers.disciplines;

import java.util.HashMap;
import java.util.Map;

import powers.ISuperNaturalAbility;

public class RavnosDisciplines implements ISuperNaturalAbility {
    
    Map<String, Integer> discipline = new HashMap<String, Integer>();
    
    public RavnosDisciplines() {
        discipline.put(DisciplineList.ANIMALISM,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.CHIMERSTRY,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.FORTITUDE,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
    }
    
    @Override
    public Map<String, Integer> getSuperPower() {
        return discipline;
    }
}
