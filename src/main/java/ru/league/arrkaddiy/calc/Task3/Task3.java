package ru.league.arrkaddiy.calc.Task3;

public class Task3 {

    public Integer equationSolution(String inputString) {
        CheckCorrectValue correctValue = new CheckCorrectValue();
        ReplaceSolution replaceSolution = new ReplaceSolution();
        if (!correctValue.checkCorrectValue(inputString)) return null;
        String[] elements = replaceSolution.replace(inputString);
        if (!correctValue.isLastElementAnCorrect(elements[elements.length - 1])) return null;
        return equation(elements);
    }

    private Integer equation(String[] elements) {
        Integer value;
        Integer result = 0;
        boolean minusSign = false;
        for (String element : elements) {
            if (element.isEmpty()) {
                continue;
            } else if (element.equals("-")) {
                minusSign = !minusSign;
                continue;
            } else if (element.equals("+")) {
                continue;
            } else {
                try {
                    value = Integer.valueOf(element);
                } catch (NumberFormatException nfe) {
                    System.err.println("Error parsing String to Integer. " + nfe.getMessage());
                    return null;
                }
                if (minusSign) {
                    value *= (-1);
                    minusSign = false;
                }
                result += value;
            }
        }
        return result;
    }
}
