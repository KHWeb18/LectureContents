interface LampMethod2 {
    public void lightOn();
    public void lightOff();
}

class Lamp2 implements LampMethod2 {
    @Override
    public void lightOn() {
        System.out.println("Lamp를 킵니다.");
    }

    @Override
    public void lightOff() {
        System.out.println("Lamp를 끕니다.");
    }
}

class StreetLamp2 implements LampMethod2 {
    @Override
    public void lightOn() {
        System.out.println("가로등을 킵니다.");
    }

    @Override
    public void lightOff() {
        System.out.println("가로등을 끕니다.");
    }
}

class Led2 implements LampMethod2 {
    @Override
    public void lightOn() {
        System.out.println("LED등을 킵니다.");
    }

    @Override
    public void lightOff() {
        System.out.println("LED등을 끕니다.");
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        Lamp2 lamp = new Lamp2();

        lamp.lightOn();
        lamp.lightOff();

        StreetLamp2 streetLamp = new StreetLamp2();

        streetLamp.lightOn();
        streetLamp.lightOff();

        Led2 led = new Led2();

        led.lightOn();
        led.lightOff();
    }
}