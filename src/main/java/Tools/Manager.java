package Tools;

import pois.GasStation;
import pois.POI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final ArrayList<POI> POIS = new ArrayList<>();
    private final NauticalMath calculator = new NauticalMath();

    public ArrayList<POI> loadPOI(String pathToGpxFile) throws IOException {
        List<String> s = Files.readAllLines(Path.of(pathToGpxFile));
        int startIndex = 0;
        int stopIndex = 0;
        for (int i = 0; i < s.size(); i++) {
            if(s.get(i).contains("<wpt")){
                startIndex = i;
                for (int j = startIndex; j < s.size(); j++){
                    if(s.get(j).contains("</wpt>")){
                        stopIndex = j;
                        POIS.add(new GasStation(String.valueOf(s.subList(startIndex,stopIndex))));
                        break;
                    }
                }
            }
        }
        return POIS;

    }
    public POI getNearestPOI(POI poi){
        double minDist = 100_000_000d;
        POI nearestPOI = null;
        for(POI p : POIS){
            if(minDist > NauticalMath.euclideanDistance(poi.getLocation(), p.getLocation()) && !p.equals(poi)){
                minDist = NauticalMath.euclideanDistance(poi.getLocation(), p.getLocation());
                nearestPOI = p;
            }
        }
        return nearestPOI;
    }

    public POI getStationById(int id){
        return POIS.get(id);
    }

    public int getStationCount(){
        return POIS.size();
    }

    public ArrayList<POI> getStationsByName(String stationName){
        ArrayList<POI> returnList = new ArrayList<>();
        POIS.stream().forEach(POI -> {
            if (POI.getName().equals(stationName)){
                returnList.add(POI);
            }
        });
        return returnList;
    }
    public double getDistToStation(Coordinates selfLocation, POI station){
        return calculator.RL_Dist(selfLocation, station.getLocation());
    }
}
