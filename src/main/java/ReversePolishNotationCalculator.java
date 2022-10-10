package main.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ReversePolishNotationCalculator {

    public Double calculate(List<String> reversePolishList) {
        Deque<Double> stack = new ArrayDeque<>();

        for (String str : reversePolishList) {
            switch (str) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    var num2 = stack.pop();
                    var num1 = stack.pop();
                    stack.push(num1 - num2);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    var num2 = stack.pop();
                    var num1 = stack.pop();
                    stack.push(num1 / num2);
                }
                case "!" -> stack.push(-stack.pop());
                default -> stack.push(Double.valueOf(str));
            }
        }
        return stack.pop();
    }

}
