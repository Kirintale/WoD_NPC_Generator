package powers.disciplines;

import java.util.HashMap;
import java.util.Map;

import powers.ISuperNaturalAbility;

public class TremereDisciplines implements ISuperNaturalAbility {
    
    Map<String, Integer> discipline = new HashMap<String, Integer>();
    
    public TremereDisciplines() {
        discipline.put(DisciplineList.DOMINATE,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.AUSPEX,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
        discipline.put(DisciplineList.THAUMATURGY,
                DisciplineList.INITIAL_DISCIPLINES_VALUE);
    }
    
    @Override
    public Map<String, Integer> getSuperPower() {
        return discipline;
    }
}
