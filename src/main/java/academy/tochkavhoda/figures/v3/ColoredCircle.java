package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.figures.v3.circle.Circle;
import academy.tochkavhoda.figures.v3.iface.Color;
import academy.tochkavhoda.figures.v3.iface.ColorException;
import academy.tochkavhoda.figures.v3.iface.ColorErrorCode;
import academy.tochkavhoda.figures.v3.iface.Colored;
import java.util.Objects;

public class ColoredCircle extends Circle implements Colored {
    private Color color;

    // Конструкторы с Color (могут бросать ColorException если color == null)
    public ColoredCircle(Point center, int radius, Color color) throws ColorException {
        super(center, radius);
        setColor(color); // используем setColor для проверки
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, Color color) throws ColorException {
        super(xCenter, yCenter, radius);
        setColor(color);
    }

    public ColoredCircle(int radius, Color color) throws ColorException {
        super(radius);
        setColor(color);
    }

    public ColoredCircle(Color color) throws ColorException {
        super();
        setColor(color);
    }

    public ColoredCircle() throws ColorException {
        this(Color.RED);
    }

    // Конструкторы со String
    public ColoredCircle(Point center, int radius, String colorString) throws ColorException {
        super(center, radius);
        setColor(colorString);
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, String colorString) throws ColorException {
        super(xCenter, yCenter, radius);
        setColor(colorString);
    }

    public ColoredCircle(int radius, String colorString) throws ColorException {
        super(radius);
        setColor(colorString);
    }

    public ColoredCircle(String colorString) throws ColorException {
        super();
        setColor(colorString);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        if (colorString == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        try {
            setColor(Color.valueOf(colorString.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }
    }

    // остальные методы (resize, equals, hashCode) без изменений
}