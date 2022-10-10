package test.java;

import main.java.ExpressionParserException;
import main.java.ParserToReversePolishNotation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ParserToReversePolishNotationTest {

    @Test
    public void shouldThrowExceptionDoubleOperation() {
        var parser = new ParserToReversePolishNotation();

        assertThrows(
                ExpressionParserException.class,
                ()->parser.parse("2++"));
    }

    @Test
    public void shouldThrowExceptionOnlyParenthesis() {
        var parser = new ParserToReversePolishNotation();

        assertThrows(
                Exception.class,
                ()->parser.parse("()))"));

    }

    @Test
    public void shouldThrowExceptionBadParenthesis() {
        var parser = new ParserToReversePolishNotation();

        assertThrows(
                ExpressionParserException.class,
                ()->parser.parse("2*(2+(3)"));
    }

    @Test
    public void shouldThrowExceptionRedundantOperator() {
        var parser = new ParserToReversePolishNotation();

        assertThrows(
                ExpressionParserException.class,
                ()->parser.parse("2+3+"));
    }

    @Test
    public void shouldThrowExceptionRedundantOperator2() {
        var parser = new ParserToReversePolishNotation();

        assertThrows(
                ExpressionParserException.class,
                ()->parser.parse("2+(3+)"));
    }

    @Test
    public void shouldReturnCorrectSum() throws ExpressionParserException {
        var parser = new ParserToReversePolishNotation();

        assertEquals("[1, 2, +]", parser.parse("1+2").toString());
    }

    @Test
    public void shouldReturnCorrectMultiplication() throws ExpressionParserException {
        var parser = new ParserToReversePolishNotation();

        assertEquals("[1, 2, *]", parser.parse("1*2").toString());
    }

    @Test
    public void shouldReturnCorrectDivision() throws ExpressionParserException {
        var parser = new ParserToReversePolishNotation();

        assertEquals("[1, 2, /]", parser.parse("1/2").toString());
    }

    @Test
    public void shouldReturnCorrectSubtraction() throws ExpressionParserException {
        var parser = new ParserToReversePolishNotation();

        assertEquals("[1, 2, -]", parser.parse("1-2").toString());
    }

    @Test
    public void shouldReturnCorrectUnary() throws ExpressionParserException {
        var parser = new ParserToReversePolishNotation();

        assertEquals("[1, 2, !, *]", parser.parse("1*(-2)").toString());
    }

    @Test
    public void shouldReturnCorrectResult() throws ExpressionParserException {
        var parser = new ParserToReversePolishNotation();

        assertEquals("[1, 2, 5, +, 6, *, 3, 1, -, /, -]", parser.parse("1-(2+5)*6/(3-1)").toString());
    }

}