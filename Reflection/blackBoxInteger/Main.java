package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class; // Get info about blackBox class

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor(); // Get empty constructor

        constructor.setAccessible(true); // make constructor public

        BlackBoxInt blackBoxInt = constructor.newInstance(); // create new instance of blackBox with our public constr

        Field innerValue = clazz.getDeclaredField("innerValue"); // get innerValue field

        innerValue.setAccessible(true); // make it public

        String input = scanner.nextLine();

        while (!"END".equals(input)) {

            String[] tokens = input.split("\\_");
            String methodName = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            Method method = clazz.getDeclaredMethod(methodName,int.class); // get method from BlackBoxInt by its name and argument
            method.setAccessible(true); // make it public
            method.invoke(blackBoxInt,number); // call the method on the blackbox

            System.out.println(innerValue.get(blackBoxInt)); // get innerValue of OUR blackBox innerValue


            input = scanner.nextLine();

        }

    }
}
