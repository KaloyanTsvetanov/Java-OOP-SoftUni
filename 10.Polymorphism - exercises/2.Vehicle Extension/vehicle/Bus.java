package vehicle;

public class Bus extends Vehicle {

    private final double DRIVE_EMPTY = this.getFuelConsumption();
    private final double DRIVE_FULL = DRIVE_EMPTY + 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }


    public String driveEmpty(double distance) {
        setFuelConsumption(DRIVE_EMPTY);
        return super.drive(distance);
    }

    @Override
    public String drive(double distance) {
        setFuelConsumption(DRIVE_FULL);
        return super.drive(distance);
    }
}
