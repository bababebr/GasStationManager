import Tools.Manager;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Manager manager = new Manager();
        manager.loadPOI("src/main/java/resources/ftcard.gpx");


        System.out.println(manager.getStationById(6));
    }
}
