interface LampMethod {
    public void lightOn();
    public void lightOff();
}

class Lamp {
    LampMethod lamp = new LampMethod() {
        @Override
        public void lightOn() {
            System.out.println("Lamp를 킵니다.");
        }

        @Override
        public void lightOff() {
            System.out.println("Lamp를 끕니다.");
        }
    };
}

class StreetLamp {
    LampMethod streetLamp = new LampMethod() {
        @Override
        public void lightOn() {
            System.out.println("가로등을 킵니다.");
        }

        @Override
        public void lightOff() {
            System.out.println("가로등을 끕니다.");
        }
    };
}

class Led {
    LampMethod led = new LampMethod() {
        @Override
        public void lightOn() {
            System.out.println("LED등을 킵니다.");
        }

        @Override
        public void lightOff() {
            System.out.println("LED등을 끕니다.");
        }
    };
}

public class InterfaceTest2 {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();

        lamp.lamp.lightOn();
        lamp.lamp.lightOff();

        StreetLamp streetLamp = new StreetLamp();

        streetLamp.streetLamp.lightOn();
        streetLamp.streetLamp.lightOff();

        Led led = new Led();

        led.led.lightOn();
        led.led.lightOff();
    }
}