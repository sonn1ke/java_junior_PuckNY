package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.iface.HasArea;
import academy.tochkavhoda.figures.v2.iface.Movable;

import java.util.Objects;

public class Icon implements Movable, HasArea {
    private Point position;
    private int width;
    private int height;

    public Icon(Point position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Icon(int x, int y, int width, int height) {
        this(new Point(x, y), width, height);
    }

    public Point getPosition() { return position; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public void setPosition(Point position) { this.position = position; }
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    @Override
    public void moveTo(int x, int y) {
        position.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        position.moveRel(dx, dy);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Icon icon = (Icon) o;
        return width == icon.width && height == icon.height && Objects.equals(position, icon.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, width, height);
    }
}
