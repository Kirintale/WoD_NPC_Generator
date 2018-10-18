package core;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

import template.AbstractHuman;
import template.human.Brawler;
import template.human.Homeless;
import template.human.Occultist;
import template.human.Politician;
import template.human.Shooter;
import exceptions.NpcGeneratorException;

public class CreateHumanNPC extends AbstractCreateNPC {
    
    public CreateHumanNPC() throws NpcGeneratorException,
            FileNotFoundException, UnsupportedEncodingException {
        super();
        createNPC();
    }
    
    // Note this current way creates and rolls every character. Use a better way
    @Override
    protected Map<String, String> selectTemplate() {
        Map<String, String> templates = new TreeMap<String, String>();
        templates.put("1", Brawler.classDescription());
        templates.put("2", Politician.classDescription());
        templates.put("3", Homeless.classDescription());
        templates.put("4", Occultist.classDescription());
        templates.put("5", Shooter.classDescription());
        return templates;
        
    }
    
    @Override
    protected AbstractHuman getTemplate(String classDescription,
            PointDistrubition pointDistribution) throws NpcGeneratorException {
        if (classDescription.equals(Brawler.classDescription())) {
            return new Brawler(pointDistribution);
        } else if (classDescription.equals(Politician.classDescription())) {
            return new Politician(pointDistribution);
        } else if (classDescription.equals(Homeless.classDescription())) {
            return new Homeless(pointDistribution);
        } else if (classDescription.equals(Occultist.classDescription())) {
            return new Occultist(pointDistribution);
        } else if (classDescription.equals(Shooter.classDescription())) {
            return new Shooter(pointDistribution);
        }
        return null;
    }
}
