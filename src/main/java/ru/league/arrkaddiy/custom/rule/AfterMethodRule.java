package ru.league.arrkaddiy.custom.rule;

import ru.league.arrkaddiy.custom.anatation.After;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class AfterMethodRule {

    public static void run(Object initClass) {
        Arrays.stream(initClass.getClass().getMethods())
                .filter(method -> method.getAnnotation(After.class) != null)
                .forEach(method -> {
                    try {
                        method.invoke(initClass);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }
}
