package _5_borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!"End".equals(input)) {

            String[] tokens = input.split("\\s+");

            Identifiable identifiable;
            if (tokens.length == 2) {
                identifiable = new Robot(tokens[0], tokens[1]);
                identifiables.add(identifiable);
            } else if (tokens.length == 3) {
                identifiable = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                identifiables.add(identifiable);
            }


            input = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();

        identifiables.stream().map(Identifiable::getId).filter(id -> id.endsWith(fakeId)).forEach(System.out::println);

    }
}
