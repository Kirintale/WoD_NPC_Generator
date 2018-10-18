package exporters;

import java.io.PrintWriter;
import java.util.Map.Entry;

import template.AbstractHuman;

public class MageRevisedZetaCharacterSheet extends BaseZetaCharacterSheet {
    
    protected void addSpecialAbilities(PrintWriter writer,
            AbstractHuman character) {
        writer.println("\n" + "[b]Spheres:[/b]");
        for (Entry<String, Integer> entry : character.getDisciplines()
                .getSuperPower().entrySet()) {
            writer.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
}
