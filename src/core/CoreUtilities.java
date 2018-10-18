package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoreUtilities {
    
    public static String getInput() {
        String venueName = null;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            venueName = br.readLine();
        } catch (IOException ioe) {
            System.out.println("Error trying to read your input.");
            System.exit(1);
        }
        return venueName;
    }
}
