import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String input = scanner.nextLine();
//
//        if(input.equals("Card Suits")) {
//            System.out.println("Card Suits:");
//            Arrays.stream(CardSuits.values()).forEach(a-> System.out.printf("Ordinal value: %d; Name value: %s%n",a.ordinal(),a.name()));
//        }else if(input.equals("Card Ranks")){
//            System.out.println("Card Ranks:");
//            Arrays.stream(CardRanks.values()).forEach(a-> System.out.printf("Ordinal value: %d; Name value: %s%n",a.ordinal(),a.name()));
//        }

        CardRanks cardRanks = CardRanks.valueOf(scanner.nextLine());
        CardSuits cardSuits = CardSuits.valueOf(scanner.nextLine());

        Card card = new Card(cardSuits,cardRanks);

        System.out.printf("Card name: %s of %s; Card power: %d",card.getCardRanks(),card.getCardSuits(),card.getPowerOfCard());


    }
}
