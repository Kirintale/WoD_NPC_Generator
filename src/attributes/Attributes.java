package attributes;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Attributes {
    
    protected final static int INITIAL_ATTRIBUTE_VALUE = 1;
    protected Map<String, Integer> attributes;
    
    public Attributes() {
        attributes = new LinkedHashMap<String, Integer>();
    }
    
    public Map<String, Integer> getAttributtes() {
        return attributes;
    }
    
    protected abstract void setInitialAttributeValues();
}
