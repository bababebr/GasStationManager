package pois;

import Tools.Coordinates;

public class GasStation extends POI{

    private Double gasPrice = Math.random()*100d;
    public GasStation(String s) {
        super(s);
    }

    public City cityFactory(String name, String description, Coordinates coordinates){
        City city = new City();
        this.location = coordinates;
        this.name = name;
        this.description = description;
        return city;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "gasPrice=" + String.format("%.2f", gasPrice) +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", description='" + description + '\'' +
                '}';
    }
}
