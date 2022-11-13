package vehicle;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Vehicle car = createVehicle(tokens);

        tokens = scanner.nextLine().split("\\s+");
        Vehicle truck = createVehicle(tokens);

        tokens = scanner.nextLine().split("\\s+");
        Vehicle bus = createVehicle(tokens);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split("\\s+");

            String commandName = tokens[0];
            String vehicleType = tokens[1];

            switch (commandName) {

                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    System.out.println(vehicleMap.get(vehicleType).drive(distance));
                    break;
                case "Refuel":
                    double fuelAmount = Double.parseDouble(tokens[2]);
                    vehicleMap.get(vehicleType).refuel(fuelAmount);
                    break;
                case "DriveEmpty":
                    double driveEmptyDistance = Double.parseDouble(tokens[2]);
                    System.out.println(((Bus) vehicleMap.get(vehicleType)).driveEmpty(driveEmptyDistance));
                    break;
            }


        }
        for (Vehicle value : vehicleMap.values()) {
            System.out.printf("%s: %.2f%n", value.getClass().getSimpleName(), value.getFuelQuantity());
        }

    }

    private static Vehicle createVehicle(String[] tokens) {
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);
        Vehicle vehicle = null;
        String vehicleType = tokens[0];
        {
            switch (vehicleType) {
                case "Car":
                    vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
                case "Truck":
                    vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
                case "Bus":
                    vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
            }
        }
        return vehicle;
    }
}
