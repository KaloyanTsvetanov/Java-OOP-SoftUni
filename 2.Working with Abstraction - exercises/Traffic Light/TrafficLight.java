public enum TrafficLight {

    GREEN,
    RED,
    YELLOW;

    public static TrafficLight update(TrafficLight light) {
        switch (light) {
            case RED:
                light = GREEN;
                break;
            case GREEN:
                light = YELLOW;
                break;
            case YELLOW:
                light = RED;
                break;
        }
        return light;
    }

}
