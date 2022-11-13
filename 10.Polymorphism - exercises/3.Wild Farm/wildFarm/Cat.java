package wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String catBreed;


    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String catBreed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.catBreed = catBreed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]",this.getAnimalType(),this.getAnimalName(),this.catBreed,df.format(this.getAnimalWeight()),this.getLivingRegion(),this.getFoodEaten());
    }
}
