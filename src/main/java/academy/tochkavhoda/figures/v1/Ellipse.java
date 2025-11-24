package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Ellipse {
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
        return this.center;
    }

    public int getXAxis() {
        return this.xAxis;
    }

    public int getYAxis() {
        return this.yAxis;
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

    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    public void moveTo(Point point) {
        this.center = point;
    }

    public void moveRel(int dx, int dy) {
        this.center = new Point(
                this.center.getX() + dx,
                this.center.getY() + dy
        );
    }

    public void resize(double ratio) {
        this.xAxis *= ratio;
        this.yAxis *= ratio;
    }

    public void stretch(double xRatio, double yRatio) {
        this.xAxis *= xRatio;
        this.yAxis *= yRatio;
    }

    public double getArea() {
        double a = xAxis / 2;
        double b = yAxis / 2;
        return Math.PI * a * b;
    }

    public double getPerimeter() {
        double a = xAxis / 2;
        double b = yAxis / 2;
        return 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
    }

    public boolean isInside(int x, int y) {
        double a = xAxis / 2;
        double b = yAxis / 2;
        double dx = x - center.getX();
        double dy = y - center.getY();
        return (dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1;
    }

    public boolean isInside(Point point) {
        double a = xAxis / 2;
        double b = yAxis / 2;
        double dx = point.getX() - center.getX();
        double dy = point.getY() - center.getY();
        return (dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1;
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
