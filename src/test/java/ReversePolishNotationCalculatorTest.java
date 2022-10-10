package test.java;

import main.java.ReversePolishNotationCalculator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ReversePolishNotationCalculatorTest {

    @Test
    public void shouldReturnCorrectSum() {
        var calculator = new ReversePolishNotationCalculator();

        assertEquals(3.0,
                calculator.calculate(List.of("1", "2", "+")),
                0.000001);
    }

    @Test
    public void shouldReturnCorrectMultiplication() {
        var calculator = new ReversePolishNotationCalculator();

        assertEquals(2.0,
                calculator.calculate(List.of("1", "2", "*")),
                0.000001);
    }

    @Test
    public void shouldReturnCorrectDivision() {
        var calculator = new ReversePolishNotationCalculator();

        assertEquals(0.5,
                calculator.calculate(List.of("1", "2", "/")),
                0.000001);
    }

    @Test
    public void shouldReturnCorrectSubtraction() {
        var calculator = new ReversePolishNotationCalculator();

        assertEquals(-1.0,
                calculator.calculate(List.of("1", "2", "-")),
                0.000001);
    }

    @Test
    public void shouldReturnCorrectUnary() {
        var calculator = new ReversePolishNotationCalculator();

        assertEquals(-1.0,
                calculator.calculate(List.of("1", "!")),
                0.000001);
    }

    @Test
    public void shouldReturnCorrectResult() {
        var calculator = new ReversePolishNotationCalculator();

        assertEquals(-20.0,
                calculator.calculate(List.of("1", "2", "5", "+", "6", "*", "3", "1", "-", "/", "-")),
                0.000001);
    }

    @Test
    public void shouldThrowException() {
        var calculator = new ReversePolishNotationCalculator();

        assertThrows(Exception.class,
                () -> calculator.calculate(List.of("1", "+", "/")));
    }
}