package powers.disciplines;

import java.util.HashMap;
import java.util.Map;

import powers.ISuperNaturalAbility;

public class LasombraDisciplines implements ISuperNaturalAbility {
    
    Map<String, Integer> discipline = new HashMap<String, Integer>();
    
    public LasombraDisciplines() {
        discipline.put(DisciplineList.DOMINATE,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.OBFUSCATE,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.POTENCE,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
    }
    
    @Override
    public Map<String, Integer> getSuperPower() {
        return discipline;
    }
}
