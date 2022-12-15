package Entity;

import Tools.Coordinates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class POI {

     String name ="";
     Coordinates location = new Coordinates();
     String description = "";

     public POI(String s){
         loadLocation(s);
         loadName(s);
         loadDescription(s);
     }
    private double getLocationX(String s) {
        int startIndex = 0;
        int stopIndex = 0;
        if (s.contains("lon=")) {
            startIndex = s.indexOf("lon=\"") + 5;
            stopIndex = s.indexOf("\"", startIndex);
            return Double.parseDouble(s.substring(startIndex, stopIndex));
        }
        return 0;
    }

    private double getLocationY(String s) {
        int startIndex = 0;
        int stopIndex = 0;
        if (s.contains("lat=")) {
            startIndex = s.indexOf("lat=\"") + 5;
            stopIndex = s.indexOf("\"", startIndex);
            return Double.parseDouble(s.substring(startIndex, stopIndex));
        }
        return 0;
    }


    private void loadLocation(String s){
        location = new Coordinates(getLocationX(s), getLocationY(s));
    }

    private void loadName(String s){
        int startIndex = 0;
        int stopIndex = 0;
        if (s.contains("<name>")) {
            startIndex = s.indexOf("<name>") + 6;
            stopIndex = s.indexOf("</name>", startIndex);
            name = s.substring(startIndex, stopIndex);
        }
    }

    private void loadDescription(String s) {
        int startIndex = 0;
        int stopIndex = 0;
        if (s.contains("<desc>")) {
            startIndex = s.indexOf("<desc>") + 6;
            stopIndex = s.indexOf("</desc>", startIndex);
            description = s.substring(startIndex, stopIndex);
        }
    }

    public String getName() {
        return name;
    }

    public Coordinates getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

}
