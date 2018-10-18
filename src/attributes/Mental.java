package attributes;

public class Mental extends Attributes {
    
    public Mental() {
        setInitialAttributeValues();
    }
    
    public Mental(Integer perception, Integer intelligence, Integer wits) {
        setInitialAttributeValues();
    }
    
    protected void setInitialAttributeValues() {
        attributes.put("perception", INITIAL_ATTRIBUTE_VALUE);
        attributes.put("intelligence", INITIAL_ATTRIBUTE_VALUE);
        attributes.put("wits", INITIAL_ATTRIBUTE_VALUE);
    }
}
