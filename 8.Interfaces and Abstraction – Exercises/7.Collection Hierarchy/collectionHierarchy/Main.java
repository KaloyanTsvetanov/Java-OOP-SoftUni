package collectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        AddCollection collection = new AddCollection();
        AddRemoveCollection collectionRemoveAdd = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        for (String s : input) {
            System.out.print(collection.add(s)+" ");
        }
        System.out.println();

        for (String s : input) {
            System.out.print(collectionRemoveAdd.add(s)+" ");
        }
        System.out.println();
        for (String s : input) {
            System.out.print(myList.add(s)+" ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(collectionRemoveAdd.remove()+" ");
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(myList.remove() + " ");
        }

    }

}
