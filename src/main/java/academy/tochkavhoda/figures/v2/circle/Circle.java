package academy.tochkavhoda.figures.v2.circle;

import academy.tochkavhoda.figures.v2.Figure;
import academy.tochkavhoda.figures.v2.Point;

import java.util.Objects;

public class Circle extends Figure {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(int xCenter, int yCenter, int radius) {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
    }

    public Circle(int radius) {
        this.center = new Point(0, 0);
        this.radius = radius;
    }

    public Circle() {
        this.center = new Point(0, 0);
        this.radius = 1;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.center = new Point(
                this.center.getX() + dx,
                this.center.getY() + dy
        );
    }

    @Override
    public void resize(double ratio) {
        this.radius = (int) (this.radius * ratio);
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public boolean isInside(int x, int y) {
        double distance = Math.sqrt(
                Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2)
        );
        return distance <= radius;
    }

    @Override
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius && Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}