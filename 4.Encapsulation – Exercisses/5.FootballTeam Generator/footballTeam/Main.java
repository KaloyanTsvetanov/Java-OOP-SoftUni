package footballTeam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Team> teamMap = new LinkedHashMap<>();
        while (!"END".equals(input)) {

            String[] commands = input.split(";");
            String commandName = commands[0];
            String teamName = commands[1];
            try {
                switch (commandName) {
                    case "Team":
                        Team team = new Team(teamName);
                        teamMap.put(teamName, team);
                        break;
                    case "Add":
                        String playerName = commands[2];
                        int endurance = Integer.parseInt(commands[3]);
                        int sprint = Integer.parseInt(commands[4]);
                        int dribble = Integer.parseInt(commands[5]);
                        int passing = Integer.parseInt(commands[6]);
                        int shooting = Integer.parseInt(commands[7]);

                        if (!teamMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teamMap.get(teamName).addPlayer(player);
                        }

                        break;
                    case "Remove":
                        String playerToRemove = commands[2];
                        teamMap.get(teamName).removePlayer(playerToRemove);
                        break;
                    case "Rating":
                        if (!teamMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.printf("%s - %d%n", teamName, Math.round(teamMap.get(teamName).getRating()));
                        }

                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
    }
}

