package attributes;

public class Social extends Attributes {
    
    public Social() {
        setInitialAttributeValues();
    }
    
    public Social(Integer charisma, Integer manipulation, Integer apperance) {
        setInitialAttributeValues();
    }
    
    @Override
    protected void setInitialAttributeValues() {
        attributes.put("charisma", INITIAL_ATTRIBUTE_VALUE);
        attributes.put("manipulation", INITIAL_ATTRIBUTE_VALUE);
        attributes.put("apperance", INITIAL_ATTRIBUTE_VALUE);
    }
}
