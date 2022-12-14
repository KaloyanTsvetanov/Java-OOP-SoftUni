package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.*;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // TODO: implement for problem 3
        try {
            Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> unitConstructor = clazz.getDeclaredConstructor();
            return unitConstructor.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
