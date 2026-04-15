package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.figures.v3.iface.Stretchable;

import java.util.Objects;

public class Ellipse extends Figure implements Stretchable {
    private Point center;
    private int xAxis;
    private int yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.center = new Point(xCenter, yCenter);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xAxis, int yAxis) {
        this.center = new Point(0, 0);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse() {
        this.center = new Point(0, 0);
        this.xAxis = 1;
        this.yAxis = 1;
    }

    public Point getCenter() {
        return center;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.center = new Point(center.getX() + dx, center.getY() + dy);
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        this.xAxis = (int) (xAxis * xRatio);
        this.yAxis = (int) (yAxis * yRatio);
    }

    @Override
    public double getArea() {
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        return Math.PI * a * b;
    }

    @Override
    public double getPerimeter() {
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        return 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
    }

    @Override
    public boolean isInside(int x, int y) {
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        double dx = x - center.getX();
        double dy = y - center.getY();
        return (dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1;
    }

    @Override
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis && yAxis == ellipse.yAxis && Objects.equals(center, ellipse.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis);
    }
}