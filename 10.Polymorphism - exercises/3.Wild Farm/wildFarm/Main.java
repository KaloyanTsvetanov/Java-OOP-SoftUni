package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();

        String animalInput = scanner.nextLine();

        while (!"End".equals(animalInput)){

            Animal animal = createAnimal(animalInput.split("\\s+"));
            animalList.add(animal);

            String foodInput = scanner.nextLine();
            Food food = getFood(foodInput.split("\\s+"));

            animal.makeSound();
            try {
            animal.eat(food);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            animalInput = scanner.nextLine();

        }
        animalList.forEach(System.out::println);

    }

    public static Food getFood(String[] tokens){
        String type = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        if(type.equals("Meat")){
            return new Meat(quantity);
        }else return new Vegetable(quantity);

    }

    public static Animal createAnimal (String[] tokens){
        String animalType = tokens[0];
        String animalName = tokens[1];
        double animalWeight = Double.parseDouble(tokens[2]);
        String animalLivingRegion = tokens[3];
        switch (animalType){
            case "Cat":
                return new Cat(animalName,animalType,animalWeight,animalLivingRegion,tokens[4]);
            case "Zebra":
                return new Zebra(animalName,animalType,animalWeight,animalLivingRegion);
            case "Tiger":
                return new Tiger(animalName,animalType,animalWeight,animalLivingRegion);
            case "Mouse":
                return new Mouse(animalName,animalType,animalWeight,animalLivingRegion);
            default:
                throw new IllegalArgumentException("No such animal type!");
        }
    }
}
