package main.java;

import java.util.List;
import java.util.Scanner;

public class ConsoleCalculator {

    public static void main (String[] args) throws ExpressionParserException{

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        ParserToReversePolishNotation n = new ParserToReversePolishNotation();
        List<String> reversePolishExpression = n.parse(s);

        ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();

        System.out.println(calculator.calculate(reversePolishExpression));

    }

}