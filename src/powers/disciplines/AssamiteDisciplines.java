package powers.disciplines;

import java.util.HashMap;
import java.util.Map;

import powers.ISuperNaturalAbility;

public class AssamiteDisciplines implements ISuperNaturalAbility {
    
    Map<String, Integer> discipline = new HashMap<String, Integer>();
    
    public AssamiteDisciplines() {
        discipline.put(DisciplineList.CELERITY,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.OBFUSCATE,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.QUIETUS,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
    }
    
    @Override
    public Map<String, Integer> getSuperPower() {
        return discipline;
    }
    
}
