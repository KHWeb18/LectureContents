class Vehicle {
    private float rpm;
    private float fuel;
    private float pressure;
    private String color;

    public Vehicle(float rpm, float fuel, float pressure, String color) {
        this.rpm = rpm;
        this.fuel = fuel;
        this.pressure = pressure;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "rpm=" + rpm +
                ", fuel=" + fuel +
                ", pressure=" + pressure +
                ", color='" + color + '\'' +
                '}';
    }
}

class Airplane extends Vehicle {
    private float aileron;
    private float pitch;
    private float rudder;

    public Airplane(float rpm, float fuel, float pressure, String color,
                    float aileron, float pitch, float rudder) {
        super(rpm, fuel, pressure, color);

        this.aileron = aileron;
        this.pitch = pitch;
        this.rudder = rudder;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "super.Vehicle()=" + super.toString()+
                "aileron=" + aileron +
                ", pitch=" + pitch +
                ", rudder=" + rudder +
                '}';
    }
}

public class InheritanceWithSuperTest {
    public static void main(String[] args) {
        Vehicle v = new Vehicle(10,10,10,"white");
        System.out.println(v);
        Airplane ap = new Airplane(20,20,20,"white",20,20,20);
        System.out.println(ap);

    }
}