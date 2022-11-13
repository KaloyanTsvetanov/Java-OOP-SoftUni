package team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Team team = new Team("Black Eagles");

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] info = scanner.nextLine().split("\\s+");
            String firstName = info[0];
            String lastName = info[1];
            int age = Integer.parseInt(info[2]);
            double salary = 500;

            Person person = new Person(firstName,lastName,age,salary);
            team.addPlayer(person);
        }
        System.out.println("First team have "+team.getFirstTeam().size()+" players");
        System.out.println("Reserve team have "+team.getReserveTeam().size()+" players");


    }
}
