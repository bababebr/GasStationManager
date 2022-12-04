package Entity;

import Tools.Coordinates;

public abstract class Waypoint {

    private final String name;
    private final Coordinates location;
    private final String description;

    public Waypoint(String name, Coordinates location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
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
