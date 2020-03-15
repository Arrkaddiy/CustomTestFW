package ru.league.arrkaddiy.calc.Task3;

import java.util.Arrays;

public class ReplaceSolution {

    public String[] replace(String solution) {
        return  replaceArray(solution.replaceAll(" ", "")
                .replaceAll("\\+", ";+;")
                .replaceAll("-", ";-;")
                .replaceAll(";;", ";")
                .split(";"));
    }

    private String[] replaceArray(String[] replaceSolution) {
        return  Arrays.stream(replaceSolution)
                .filter(element -> !element.equals("")).toArray(String[]::new);
    }


}
