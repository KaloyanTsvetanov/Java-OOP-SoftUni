package vehicle;

public class Truck extends Vehicle {

    private final static double ADDITIONAL_AC_CONSUMPTION = 1.6;
    private final static double PROBLEM_WITH_TANK_FACTOR = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption+ADDITIONAL_AC_CONSUMPTION);
    }

    @Override
    public void refuel(double litres) {
        litres *= PROBLEM_WITH_TANK_FACTOR;
        super.refuel(litres);
    }
}
