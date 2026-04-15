package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.iface.HasArea;
import academy.tochkavhoda.figures.v2.iface.Movable;
import academy.tochkavhoda.figures.v2.iface.Resizable;

public abstract class Figure implements HasArea, Resizable, Movable {
    public abstract double getPerimeter();
    public abstract boolean isInside(int x, int y);
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }
}