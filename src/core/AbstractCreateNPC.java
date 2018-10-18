package core;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import template.AbstractHuman;
import exceptions.NpcGeneratorException;
import exporters.BaseZetaCharacterSheet;
import exporters.IZetaboardExporter;

public abstract class AbstractCreateNPC {
    
    IZetaboardExporter exporter;
    
    public AbstractCreateNPC() throws FileNotFoundException,
            UnsupportedEncodingException, NpcGeneratorException {
        exporter = new BaseZetaCharacterSheet();
    }
    
    protected void createNPC() throws NpcGeneratorException {
        try {
            boolean isValidSelection = false;
            while (!isValidSelection) {
                System.out.println("Please the powerlevel of your NPC");
                Map<String, PointDistrubition> pointDistributions = selectPowerLevel();
                for (Entry<String, PointDistrubition> entry : pointDistributions
                        .entrySet()) {
                    System.out.println(entry.getKey()
                            + entry.getValue().getDescription());
                }
                
                String input = CoreUtilities.getInput();
                
                if (input.equals("q")) {
                    break;
                }
                
                if (!pointDistributions.containsKey(input)) {
                    System.out
                            .println("Please input a valid value or q to exit");
                    continue;
                }
                
                PointDistrubition pointDistribution = pointDistributions
                        .get(input);
                
                System.out
                        .println("Please select which template you wish to use.");
                Map<String, String> templates = selectTemplate();
                for (Entry<String, String> entry : templates.entrySet()) {
                    System.out
                            .println(entry.getKey() + ": " + entry.getValue());
                }
                
                input = CoreUtilities.getInput();
                
                if (input.equals("q")) {
                    break;
                }
                
                if (!templates.containsKey(input)) {
                    System.out
                            .println("Please input a valid value or q to exit");
                    continue;
                }
                
                String classDescription = templates.get(input);
                AbstractHuman npCharacter = getTemplate(classDescription,
                        pointDistribution);
                exporter.exportCharacter(npCharacter, classDescription);
                isValidSelection = true;
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new NpcGeneratorException(e);
        }
    }
    
    // Note this current way creates and rolls every character. Use a better way
    protected abstract Map<String, String> selectTemplate();
    
    protected abstract AbstractHuman getTemplate(String classDescription,
            PointDistrubition pointDistribution) throws NpcGeneratorException;
    
    protected Map<String, PointDistrubition> selectPowerLevel() {
        Map<String, PointDistrubition> powerLevels = new TreeMap<String, PointDistrubition>();
        PointDistrubition powerlevel = new PointDistrubition(
                ": Experienced NPC break Attributes: 7/6/4 Abilities: 16/12/8 Background: 7 Special (if applicable): 6",
                7, 6, 4, 16, 12, 8, 7, 6);
        powerLevels.put("1", powerlevel);
        
        powerlevel = new PointDistrubition(
                ": PC break Attributes: 7/5/3 Abilities: 13/9/5 Background: 5 Special (if applicable): 5",
                7, 5, 3, 13, 9, 5, 5, 5);
        powerLevels.put("2", powerlevel);
        
        powerlevel = new PointDistrubition(
                ": Moderate NPC break Attributes: 5/4/3 Abilities: 11/7/4 Background: 3 Special (if applicable): 4",
                5, 4, 3, 11, 7, 4, 3, 4);
        powerLevels.put("3", powerlevel);
        
        powerlevel = new PointDistrubition(
                ": Weak NPC break Attributes: 4/4/3 Abilities: 9/6/4 Background: 3 Special (if applicable): 3",
                4, 4, 3, 9, 6, 4, 3, 3);
        powerLevels.put("4", powerlevel);
        
        powerlevel = new PointDistrubition(
                ": Child-like NPC break Attributes: 4/3/3 Abilities: 6/4/3 Background: 1 Special (if applicable): 2",
                4, 3, 3, 9, 6, 4, 3, 2);
        powerLevels.put("5", powerlevel);
        
        return powerLevels;
    }
    
    protected void setExporter(IZetaboardExporter zetaExporter) {
        exporter = zetaExporter;
    }
}
