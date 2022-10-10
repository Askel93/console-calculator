package main.java;

public enum Operators {
    SUM("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/")
    ;

    private final String view;

    Operators(String view) {
        this.view = view;
    }

    public static boolean exists(String text) {
        for (Operators b : Operators.values()) {
            if (b.view.equalsIgnoreCase(text)) {
                return true;
            }
        }
        return false;
    }
}
