import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<TrafficLight> trafficLights = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            for (int i = 0; i < trafficLights.size(); i++) {
                trafficLights.set(i, TrafficLight.update(trafficLights.get(i)));
                System.out.print(trafficLights.get(i) + " ");
            }
            System.out.println();

        }

    }
}
