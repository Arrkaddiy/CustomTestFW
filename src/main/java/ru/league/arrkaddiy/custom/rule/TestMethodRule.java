package ru.league.arrkaddiy.custom.rule;

import ru.league.arrkaddiy.custom.anatation.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class TestMethodRule {

    public static void run(Class<?> testClass) {
        Arrays.stream(testClass.getMethods())
                .filter(method -> method.getAnnotation(Test.class) != null)
                .forEach(method -> {
                    try {
                        Object initClass = testClass.newInstance();
                        BeforeMethodRule.run(initClass);
                        method.invoke(initClass);
                        AfterMethodRule.run(initClass);
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                        e.printStackTrace();
                    }
                });
    }
}
