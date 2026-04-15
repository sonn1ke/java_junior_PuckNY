package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.iface.Colored;

import java.util.Objects;

public class ColoredPoint extends Point implements Colored {
    private int color;

    public ColoredPoint(int x, int y, int color) {
        super(x, y);
        this.color = color;
    }

    public ColoredPoint(int color) {
        this(0, 0, color);
    }

    public ColoredPoint() {
        this(1);
    }

    @Override
    public int getColor() { return color; }

    @Override
    public void setColor(int color) { this.color = color; }

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
