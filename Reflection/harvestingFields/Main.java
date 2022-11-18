package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Class<RichSoilLand> clazz = RichSoilLand.class;

        Field[] declaredFields = clazz.getDeclaredFields();

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"HARVEST".equals(input)) {

            getModifiers(declaredFields,input);

            input = scanner.nextLine();
        }

    }
    private static void getModifiers(Field[] declaredFields,String modifier) {
        if(!"all".equals(modifier)) {
            for (Field field : declaredFields) {
                if (Modifier.toString(field.getModifiers()).equals(modifier)) {
                    System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
                }
            }
        }else {
            Arrays.stream(declaredFields).forEach(field -> {
                System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
            });
        }
    }
}
