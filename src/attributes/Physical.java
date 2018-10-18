package attributes;

public class Physical extends Attributes {
    
    public Physical() {
        setInitialAttributeValues();
    }
    
    public Physical(Integer strength, Integer dexterity, Integer stamina) {
        setInitialAttributeValues();
    }
    
    protected void setInitialAttributeValues() {
        attributes.put("strength", INITIAL_ATTRIBUTE_VALUE);
        attributes.put("dexterity", INITIAL_ATTRIBUTE_VALUE);
        attributes.put("stamina", INITIAL_ATTRIBUTE_VALUE);
    }
}
