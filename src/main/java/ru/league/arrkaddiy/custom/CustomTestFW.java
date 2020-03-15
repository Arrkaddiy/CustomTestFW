package ru.league.arrkaddiy.custom;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import ru.league.arrkaddiy.custom.rule.TestMethodRule;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomTestFW {

    public static void runTest(String packageName) {
        Set<Class<?>> classes = getClassesByPackageName(packageName);
        classes.forEach(TestMethodRule::run);
    }

    private static Set<Class<?>> getClassesByPackageName(String packageName) {
        return new Reflections(packageName, new SubTypesScanner(false))
                .getAllTypes()
                .stream()
                .map(CustomTestFW::apply)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

    }

    private static Class<?> apply(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
