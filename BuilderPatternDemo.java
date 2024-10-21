// Product Class
class House {
    private int windows;
    private int doors;
    private boolean hasGarage;

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    @Override
    public String toString() {
        return "House [windows=" + windows + ", doors=" + doors + ", hasGarage=" + hasGarage + "]";
    }
}

// Builder Interface
interface HouseBuilder {
    void buildWindows();
    void buildDoors();
    void buildGarage();
    House getHouse();
}

// Concrete Builder
class ConcreteHouseBuilder implements HouseBuilder {
    private House house;

    public ConcreteHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildWindows() {
        house.setWindows(4);
    }

    @Override
    public void buildDoors() {
        house.setDoors(2);
    }

    @Override
    public void buildGarage() {
        house.setHasGarage(true);
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

// Director
class HouseDirector {
    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void constructHouse() {
        houseBuilder.buildWindows();
        houseBuilder.buildDoors();
        houseBuilder.buildGarage();
    }

    public House getHouse() {
        return houseBuilder.getHouse();
    }
}

// Client
public class BuilderPatternDemo {
    public static void main(String[] args) {
        HouseBuilder builder = new ConcreteHouseBuilder();
        HouseDirector director = new HouseDirector(builder);

        director.constructHouse();
        House house = director.getHouse();

        System.out.println(house);
    }
}
