import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = getCoordinates(scanner);

        Point a = new Point(coordinates[0],coordinates[1]);
        Point c = new Point(coordinates[2],coordinates[3]);

        Rectangle rectangle = new Rectangle(a,c);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-->0){
            int [] point = getCoordinates(scanner);

            Point x = new Point(point[0],point[1]);

            boolean isInside = rectangle.contains(x);
            System.out.println(isInside);
        }

    }

    private static int[] getCoordinates(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
