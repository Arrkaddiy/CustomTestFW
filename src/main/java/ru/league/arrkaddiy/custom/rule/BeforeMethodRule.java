package ru.league.arrkaddiy.custom.rule;

import ru.league.arrkaddiy.custom.anatation.Before;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class BeforeMethodRule {

    public static void run(Object initClass) {
        Arrays.stream(initClass.getClass().getMethods())
                .filter(method -> method.getAnnotation(Before.class) != null)
                .forEach(method -> {
                    try {
                        method.invoke(initClass);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }
}
