package pizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!checkTopping(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = 0;
        switch (toppingType) {
            case "Meat":
                calories = (weight * 2) * 1.2;
                break;
            case "Veggies":
                calories = (weight * 2) * 0.8;
                break;
            case "Cheese":
                calories = (weight * 2) * 1.1;
                break;
            case "Sauce":
                calories = (weight * 2) * 0.9;
                break;

        }
        return calories;

    }

    private boolean checkTopping(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                return true;
            default:
                return false;
        }
    }
}
