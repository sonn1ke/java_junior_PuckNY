package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.figures.v3.iface.Colored;

import java.util.Objects;

import academy.tochkavhoda.figures.v3.iface.Color;
import academy.tochkavhoda.figures.v3.iface.ColorException;
import academy.tochkavhoda.figures.v3.iface.Colored;
import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {
    private Color color;

    // Конструкторы с Color
    public ColoredRectangle(Point leftTop, Point rightBottom, Color color) {
        super(leftTop, rightBottom);
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) {
        super(xLeft, yTop, xRight, yBottom);
        this.color = color;
    }

    public ColoredRectangle(int length, int width, Color color) {
        super(length, width);
        this.color = color;
    }

    public ColoredRectangle(Color color) {
        super();
        this.color = color;
    }

    public ColoredRectangle() {
        this(Color.RED);
    }

    // Конструкторы со String
    public ColoredRectangle(Point leftTop, Point rightBottom, String colorString) throws ColorException {
        this(leftTop, rightBottom, Color.colorFromString(colorString));
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, String colorString) throws ColorException {
        this(xLeft, yTop, xRight, yBottom, Color.colorFromString(colorString));
    }

    public ColoredRectangle(int length, int width, String colorString) throws ColorException {
        this(length, width, Color.colorFromString(colorString));
    }

    public ColoredRectangle(String colorString) throws ColorException {
        this(Color.colorFromString(colorString));
    }

    @Override
    public Color getColor() { return color; }

    @Override
    public void setColor(Color color) { this.color = color; }

    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
    }

    public boolean isIntersects(ColoredRectangle rectangle) {
        return super.isIntersects(rectangle);
    }

    public boolean isInside(ColoredRectangle rectangle) {
        return super.isInside(rectangle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}