package defineInterface;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> birthableList = new ArrayList<>();

        while (!"End".equals(input)) {

            String[] tokens = input.split("\\s+");

            if (!"Robot".equals(tokens[0])) {
                Birthable birthable = tokens.length == 3
                        ? new Pet(tokens[1],tokens[2] )
                        : new Citizen(tokens[1],Integer.parseInt(tokens[2]),tokens[3],tokens[4]);

                birthableList.add(birthable);
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        birthableList.stream().map(Birthable::getBirthDate).filter(a -> a.endsWith(year)).forEach(System.out::println);

    }
}
