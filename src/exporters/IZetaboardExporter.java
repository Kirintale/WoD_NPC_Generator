package exporters;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import template.AbstractHuman;

public interface IZetaboardExporter {
    
    void exportCharacter(AbstractHuman character, String classDescription)
            throws FileNotFoundException, UnsupportedEncodingException;
    
}
