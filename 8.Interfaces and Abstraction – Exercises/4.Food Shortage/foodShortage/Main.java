package foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Buyer> buyerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");

            Buyer buyer = input.length == 3
                    ? new Rebel(input[0],Integer.parseInt(input[1]),input[2])
                    : new Citizen(input[0],Integer.parseInt(input[1]),input[2],input[3]);

            buyerList.add(buyer);

        }

        String name = scanner.nextLine();

        while (!"End".equals(name)){

            String checkName = name;

            buyerList.stream().filter(a -> a.getName().equals(checkName)).forEach(Buyer::buyFood);


            name = scanner.nextLine();
        }

        System.out.println(buyerList.stream().mapToInt(Buyer::getFood).sum());

    }
}
