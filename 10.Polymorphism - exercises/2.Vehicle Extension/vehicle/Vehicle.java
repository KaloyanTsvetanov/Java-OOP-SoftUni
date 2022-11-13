package vehicle;

import java.text.DecimalFormat;

public class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance) {

        double fuelNeeded = distance * fuelConsumption;

        if (fuelNeeded > this.fuelQuantity) {

            return String.format("%s needs refueling",this.getClass().getSimpleName());

        }

        this.fuelQuantity = this.fuelQuantity - fuelNeeded;
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));

    }


    public void refuel(double litres) {
        if(litres<=0){
            System.out.println("Fuel must be a positive number");
            return;
        }

        if(litres+this.fuelQuantity>tankCapacity){
            System.out.println("Cannot fit fuel in tank");
            return;
        }

        this.fuelQuantity += litres;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
