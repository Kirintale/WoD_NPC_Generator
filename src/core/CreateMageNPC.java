package core;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

import template.AbstractHuman;
import templateMageRevisedV20.Akashic;
import templateMageRevisedV20.Heremetic;
import templateMageRevisedV20.VoidEngineer;
import exceptions.NpcGeneratorException;
import exporters.MageRevisedZetaCharacterSheet;

public class CreateMageNPC extends AbstractCreateNPC {
    
    public CreateMageNPC() throws FileNotFoundException,
            UnsupportedEncodingException, NpcGeneratorException {
        super();
        setExporter(new MageRevisedZetaCharacterSheet());
        createNPC();
    }
    
    // This method should be updated on creation of new template
    @Override
    protected Map<String, String> selectTemplate() {
        Map<String, String> templates = new TreeMap<String, String>();
        templates.put("1", Akashic.classDescription());
        templates.put("2", Heremetic.classDescription());
        templates.put("3", VoidEngineer.classDescription());
        return templates;
    }
    
    // This method should be updated on creation of new template
    @Override
    protected AbstractHuman getTemplate(String classDescription,
            PointDistrubition pointDistribution) throws NpcGeneratorException {
        if (classDescription.equals(Akashic.classDescription())) {
            return new Akashic(pointDistribution);
        } else if (classDescription.equals(Heremetic.classDescription())) {
            return new Heremetic(pointDistribution);
        } else if (classDescription.equals(VoidEngineer.classDescription())) {
            return new VoidEngineer(pointDistribution);
        }
        throw new NpcGeneratorException("Invalid character type selected");
    }
}
