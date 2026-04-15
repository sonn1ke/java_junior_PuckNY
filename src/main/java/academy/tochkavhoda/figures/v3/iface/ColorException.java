package academy.tochkavhoda.figures.v3.iface;

public class ColorException extends Exception {
    private final ColorErrorCode errorCode;

    public ColorException(ColorErrorCode errorCode) {
        super(errorCode.getErrorString());
        this.errorCode = errorCode;
    }

    public ColorErrorCode getErrorCode() {
        return errorCode;
    }
}