package main.java;

import java.util.Objects;

public enum Delimeters {
    SUM("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    OPEN_PARENTHESIS("("),
    CLOSE_PARENTHESIS(")")
    ;

    private final String view;

    Delimeters(String view) {
        this.view = view;
    }

    public static boolean exists(String text) {
        return Objects.nonNull(fromString(text));
    }

    public static Delimeters fromString(String text) {
        for (Delimeters b : Delimeters.values()) {
            if (b.view.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return view;
    }
}
