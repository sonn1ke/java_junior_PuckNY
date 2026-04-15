package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.figures.v3.iface.Colored;

import java.util.Objects;

import academy.tochkavhoda.figures.v3.iface.Color;
import academy.tochkavhoda.figures.v3.iface.ColorException;
import academy.tochkavhoda.figures.v3.iface.Colored;
import java.util.Objects;

public class ColoredPoint extends Point implements Colored {
    private Color color;

    // Конструкторы с Color
    public ColoredPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    public ColoredPoint(Color color) {
        this(0, 0, color);
    }

    public ColoredPoint() {
        this(Color.RED);
    }

    // Конструкторы со String
    public ColoredPoint(int x, int y, String colorString) throws ColorException {
        this(x, y, Color.colorFromString(colorString));
    }

    public ColoredPoint(String colorString) throws ColorException {
        this(Color.colorFromString(colorString));
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredPoint that = (ColoredPoint) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}