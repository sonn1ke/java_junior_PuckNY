package academy.tochkavhoda.figures.v3.iface;

public enum ColorErrorCode {
    WRONG_COLOR_STRING("Invalid color string"),
    NULL_COLOR("Color cannot be null");

    private final String errorString;

    ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}