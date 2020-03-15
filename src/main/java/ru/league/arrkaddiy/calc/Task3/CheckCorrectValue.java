package ru.league.arrkaddiy.calc.Task3;

public class CheckCorrectValue {

    public boolean checkCorrectValue(String solution) {
        return solution.matches("[\\s\\d+-]+");
    }

    public boolean isLastElementAnCorrect(String element) {
        return !element.equals("+") || !element.equals("-");
    }
}
