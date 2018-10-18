package powers.disciplines;

import java.util.HashMap;
import java.util.Map;

import powers.ISuperNaturalAbility;

public class MalkavianDisciplines implements ISuperNaturalAbility {
    
    Map<String, Integer> discipline = new HashMap<String, Integer>();
    
    public MalkavianDisciplines() {
        discipline.put(DisciplineList.AUSPEX,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.DEMENTATION,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.OBFUSCATE,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
    }
    
    @Override
    public Map<String, Integer> getSuperPower() {
        return discipline;
    }
}
