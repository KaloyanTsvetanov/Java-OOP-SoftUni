package randomArrayList;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.eat();
        dog.bark();

        cat.eat();
        cat.meow();
        RandomArrayList list = new RandomArrayList();
        list.add(13);
        list.add(42);
        list.add(53);
        list.add(69);
        list.add(73);
        list.add(33);
        System.out.println(list.getRandomElement());

    }
}
