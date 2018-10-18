package core;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import exceptions.NpcGeneratorException;

public class CommandLineMain {
    
    public static void main(String[] args) throws FileNotFoundException,
            UnsupportedEncodingException, NpcGeneratorException {
        System.out.println("Please enter the number of the chosen venue");
        boolean validInput = false;
        
        while (!validInput) {
            
            for (String venue : venueNames()) {
                System.out.println(venue);
            }
            
            String venueName = CoreUtilities.getInput();
            
            if (venueName.trim().equals("1")) {
                new CreateHumanNPC();
                validInput = true;
            } else if (venueName.trim().equals("2")) {
                new CreateVampireNPC();
                validInput = true;
            } else if (venueName.trim().equals("3")) {
                new CreateMageNPC();
                validInput = true;
            } else if (venueName.trim().equals("q")) {
                System.out.println("Exiting");
                validInput = true;
            } else {
                System.out
                        .println("Please type a valid venue number of 'q' to quit.");
            }
        }
        System.exit(1);
    }
    
    private static List<String> venueNames() {
        
        List<String> venueNames = new ArrayList<String>();
        venueNames.add("1: Human");
        venueNames.add("2: Vampire");
        venueNames.add("3: Mage (Revised)");
        venueNames.add("q: Exit");
        return venueNames;
    }
    
}
