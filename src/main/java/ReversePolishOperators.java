package main.java;

public enum ReversePolishOperators {
    SUM("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    UNARY("!")
    ;

    private final String view;

    ReversePolishOperators(String view) {
        this.view = view;
    }

    public static boolean exists(String text) {
        for (ReversePolishOperators b : ReversePolishOperators.values()) {
            if (b.view.equalsIgnoreCase(text)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return view;
    }
}
