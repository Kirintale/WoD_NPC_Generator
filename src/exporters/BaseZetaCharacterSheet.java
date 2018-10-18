package exporters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map.Entry;

import template.AbstractHuman;
import template.CharacterPointDistribution;

public class BaseZetaCharacterSheet implements IZetaboardExporter {
    
    public BaseZetaCharacterSheet() {
        
    }
    
    @Override
    public void exportCharacter(AbstractHuman character, String classDescription)
            throws FileNotFoundException, UnsupportedEncodingException {
        
        File exportDirectory = new File("./characters");
        System.out.println(exportDirectory.getAbsolutePath());
        File exportFile = new File(exportDirectory, classDescription + ".txt");
        PrintWriter writer = new PrintWriter(exportFile, "UTF-8");
        StringBuilder stringBuilder = new StringBuilder();
        writer.println("[b]Name:[/b]" + "\n");
        writer.println("[b]Player:[/b]" + "\n");
        writer.println("[b]Nature: [/b]" + "\n");
        writer.println("[b]Demeanor:[/b]" + "\n");
        writer.println("[b]Concept:[/b]" + "\n");
        writer.println("[b]Date of Birth: [/b]" + "\n");
        writer.println("[b]Physical:[/b]" + "\n");
        for (Entry<String, Integer> entry : character.getPhysicalStats()
                .getAttributtes().entrySet()) {
            writer.println(entry.getKey() + ": " + entry.getValue());
            
        }
        writer.println("\n" + "[b]Social: [/b]");
        for (Entry<String, Integer> entry : character.getSocialStats()
                .getAttributtes().entrySet()) {
            writer.println(entry.getKey() + ": " + entry.getValue());
        }
        
        writer.println("\n" + "[b]Mental:[/b]");
        for (Entry<String, Integer> entry : character.getMentalStats()
                .getAttributtes().entrySet()) {
            writer.println(entry.getKey() + ": " + entry.getValue());
        }
        
        writer.println("\n" + "[b]Talents:[/b]");
        for (Entry<String, Integer> entry : character.getTalentsStats()
                .getTalents().entrySet()) {
            writer.println(entry.getKey() + ": " + entry.getValue());
        }
        
        writer.println("\n" + "[b]Skills:[/b]");
        for (Entry<String, Integer> entry : character.getSkillsStats()
                .getSkills().entrySet()) {
            writer.println(entry.getKey() + ": " + entry.getValue());
        }
        
        writer.println("\n" + "[b]Knowledges:[/b]");
        for (Entry<String, Integer> entry : character.getKnowledgesStats()
                .getKnowledges().entrySet()) {
            writer.println(entry.getKey() + ": " + entry.getValue());
        }
        
        writer.println("\n" + "[b]Backgrounds:[/b]");
        for (Entry<String, Integer> entry : character.getBackgroundStats()
                .getBackgrounds().entrySet()) {
            writer.println(entry.getKey() + ": " + entry.getValue());
        }
        
        addSpecialAbilities(writer, character);
        
        writer.println("[b]Willpower:[/b]" + "\n");
        writer.println("[b]Merits:[/b]" + "\n");
        writer.println("[b]Flaws:[/b]" + "\n");
        writer.println("[b]Owned Equipment:[/b]" + "\n");
        writer.println("[b]Carried Equipment:[/b]" + "\n");
        
        outputRemainingPoints(writer, character.getPointDistribution());
        
        writer.println(stringBuilder.toString());
        writer.close();
    }
    
    protected void addSpecialAbilities(PrintWriter writer,
            AbstractHuman character) {
        
    }
    
    private void outputRemainingPoints(PrintWriter writer,
            CharacterPointDistribution pointDistribution) {
        checkStatRemainingPoints(writer, "physical",
                pointDistribution.getPhysicalPoints());
        checkStatRemainingPoints(writer, "social",
                pointDistribution.getSocialPoints());
        checkStatRemainingPoints(writer, "mental",
                pointDistribution.getMentalPoints());
        checkStatRemainingPoints(writer, "talent",
                pointDistribution.getTalentPoints());
        checkStatRemainingPoints(writer, "skill",
                pointDistribution.getSkillPoints());
        checkStatRemainingPoints(writer, "knowledges",
                pointDistribution.getKnowledgePoints());
        checkStatRemainingPoints(writer, "backgrounds",
                pointDistribution.getBackgroundPoints());
    }
    
    private void checkStatRemainingPoints(PrintWriter writer,
            String statisticType, int remainingPoints) {
        if (remainingPoints > 0) {
            writer.println("Remaining " + statisticType + " points: "
                    + remainingPoints);
        }
    }
}
