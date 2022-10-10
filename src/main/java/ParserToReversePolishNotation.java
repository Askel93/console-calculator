package main.java;

import java.util.*;

import static main.java.Delimeters.*;

public class ParserToReversePolishNotation {

    public List<String> parse(String str) throws ExpressionParserException{

        List<String> out = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        StringTokenizer tokenizer = new StringTokenizer(str, Arrays.toString(Delimeters.values()), true);

        String previousString = "";
        String currentString = "";

        while (tokenizer.hasMoreTokens()) {
            currentString = tokenizer.nextToken();

            if (!tokenizer.hasMoreTokens() && isOperator(currentString)                              //3+3+
                    || isOperator(currentString) && isOperator(previousString)                                 //3++1
                    || isOperator(previousString) && currentString.equals(CLOSE_PARENTHESIS.toString())        //3+(3+)
            ) {
                throw new ExpressionParserException("Illegal expression");
            }

            else if (Delimeters.exists(currentString)) {
                var currentDelimiter = Delimeters.fromString(currentString);

                if (currentDelimiter == OPEN_PARENTHESIS) stack.push(currentString);

                else if (currentDelimiter == CLOSE_PARENTHESIS) {
                    while (!Objects.equals(stack.peek(), OPEN_PARENTHESIS.toString())) {
                        out.add(stack.pop());
                        if (stack.isEmpty()) {
                            throw new ExpressionParserException("Parenthesis aren't correct");
                        }
                    }
                    stack.pop();
                }

                else {
                    if (currentDelimiter == SUBTRACTION && (previousString.equals("")|| previousString.equals(OPEN_PARENTHESIS.toString()))) {
                        currentString = ReversePolishOperators.UNARY.toString();
                    }
                    else {
                        while (!stack.isEmpty() && (priority(currentString) <= priority(stack.peek()))) {
                            out.add(stack.pop());
                        }
                    }
                    stack.push(currentString);
                }

            }

            else {
                out.add(currentString);
            }
            previousString = currentString;
        }

        while (!stack.isEmpty()) {
            if (ReversePolishOperators.exists(stack.peek())) {
                out.add(stack.pop());
            }
            else {
                throw new ExpressionParserException("Parenthesis aren't correct");
            }
        }

        return out;
    }

    private boolean isOperator(String str) {
        return Operators.exists(str);
    }

    private int priority(String str) {
        var delimiter = Delimeters.fromString(str);

        return switch (delimiter) {
            case OPEN_PARENTHESIS -> 1;
            case SUM, SUBTRACTION -> 2;
            case MULTIPLICATION, DIVISION -> 3;
            default -> 4;
        };
    }

}
