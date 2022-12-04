import Tools.GpxParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<String>> s = GpxParser.waypoints(Path.of("src/resources/ftcard.gpx"));
        System.out.println(s.size());
        System.out.println(s.get(3));
    }
}
