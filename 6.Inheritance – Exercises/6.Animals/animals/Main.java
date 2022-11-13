package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!"Beast".equals(command)){

            String typeAnimal = command;

            String [] commandParts = scanner.nextLine().split("\\s+");

            String name = commandParts[0];
            int age = Integer.parseInt(commandParts[1]);
            String gender = commandParts[2];
            try {

                switch (typeAnimal) {
                    case "Cat":
                        Cat cat = new Cat(name,age,gender);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name,age,gender);
                        System.out.println(frog);
                        break;
                    case "Dog":
                        Dog dog = new Dog(name,age,gender);
                        System.out.println(dog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name,age);
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name,age);
                        System.out.println(tomcat);
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }


            command = scanner.nextLine();
        }

    }
}
