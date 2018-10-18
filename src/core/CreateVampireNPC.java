package core;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

import template.AbstractHuman;
import template.vampire.Brujah;
import template.vampire.Tremere;
import template.vampire.Ventrue;
import exceptions.NpcGeneratorException;
import exporters.VampireZetaCharacterSheet;

public class CreateVampireNPC extends AbstractCreateNPC {
    
    public CreateVampireNPC() throws NpcGeneratorException,
            FileNotFoundException, UnsupportedEncodingException {
        super();
        setExporter(new VampireZetaCharacterSheet());
        createNPC();
    }
    
    // Note this current way creates and rolls every character. Use a better way
    @Override
    protected Map<String, String> selectTemplate() {
        Map<String, String> templates = new TreeMap<String, String>();
        templates.put("1", Brujah.classDescription());
        templates.put("2", Tremere.classDescription());
        templates.put("3", Ventrue.classDescription());
        return templates;
    }
    
    @Override
    protected AbstractHuman getTemplate(String classDescription,
            PointDistrubition pointDistribution) throws NpcGeneratorException {
        if (classDescription.equals(Brujah.classDescription())) {
            return new Brujah(pointDistribution);
        } else if (classDescription.equals(Tremere.classDescription())) {
            return new Tremere(pointDistribution);
        } else if (classDescription.equals(Ventrue.classDescription())) {
            return new Ventrue(pointDistribution);
            
        }
        return null;
    }
}
