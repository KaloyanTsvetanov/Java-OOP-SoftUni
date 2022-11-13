package pizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public Dough() {

    }

    private void setFlourType(String flourType) {
        if (!checkFlourType(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!checkBakingTechnique(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double flourTypeFactor = 0;
        double bakingTechniqueFactor = 0;
        double calories;
        switch (flourType) {
            case "White":
                flourTypeFactor = 1.5;
                break;
            case "Wholegrain":
                flourTypeFactor = 1.0;
                break;
        }
        switch (bakingTechnique) {
            case "Crispy":
                bakingTechniqueFactor = 0.9;
                break;
            case "Chewy":
                bakingTechniqueFactor = 1.1;
                break;
            case "Homemade":
                bakingTechniqueFactor = 1.0;
                break;
        }
        calories = flourTypeFactor * bakingTechniqueFactor * (2 * weight);
        return calories;
    }

    private boolean checkFlourType(String flourType) {
        switch (flourType) {
            case "White":
            case "Wholegrain":
                return true;
            default:
                return false;
        }
    }

    private boolean checkBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
            case "Chewy":
            case "Homemade":
                return true;
            default:
                return false;
        }
    }
}
