package generators;

import java.util.Map;

import template.CharacterPointDistribution;
import exceptions.NpcGeneratorException;

public class StatGenerator {
    
    public static void generateAbilities(final Map<String, Integer> talents,
            final Map<String, Integer> skills,
            final Map<String, Integer> knowledges,
            final CharacterPointDistribution pointDistribution)
            throws NpcGeneratorException {
        
        final AbilityGenerator attributeGenerator = new AbilityGenerator(
                new RandomPointDeligator(3));
        attributeGenerator.generateAbilities(talents, skills, knowledges,
                pointDistribution);
    }
    
    public static void generateAttributes(final Map<String, Integer> physical,
            final Map<String, Integer> social,
            final Map<String, Integer> mental,
            final CharacterPointDistribution pointDistribution)
            throws NpcGeneratorException {
        
        final AttributeGenerator attributeGenerator = new AttributeGenerator(
                new RandomPointDeligator(5), false);
        attributeGenerator.generateAttributes(physical, social, mental,
                pointDistribution);
    }
    
    public static void generateBackgrounds(
            final Map<String, Integer> backgrounds,
            final CharacterPointDistribution pointDistribution)
            throws NpcGeneratorException {
        
        final BackgroundsGenerator backgroundGenerator = new BackgroundsGenerator(
                new RandomPointDeligator(4), true);
        backgroundGenerator.generateBackgrounds(backgrounds, pointDistribution);
    }
    
    public static void generateDisciplines(
            final Map<String, Integer> disciplines,
            final CharacterPointDistribution pointDistribution)
            throws NpcGeneratorException {
        
        final DisciplinesGenerator disciplineGenerator = new DisciplinesGenerator(
                new RandomPointDeligator(5));
        disciplineGenerator.generateDisciplines(disciplines, pointDistribution);
    }
    
}
