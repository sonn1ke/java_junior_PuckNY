package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.iface.Stretchable;

import java.util.Objects;

public class Rectangle extends Figure implements Stretchable {
    private Point leftTop;
    private Point rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.leftTop = new Point(xLeft, yTop);
        this.rightBottom = new Point(xRight, yBottom);
    }

    public Rectangle(int length, int width) {
        this.leftTop = new Point(0, -width);
        this.rightBottom = new Point(length, 0);
    }

    public Rectangle() {
        this.leftTop = new Point(0, -1);
        this.rightBottom = new Point(1, 0);
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point topLeft) {
        this.leftTop = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.rightBottom = bottomRight;
    }

    public int getLength() {
        return rightBottom.getX() - leftTop.getX();
    }

    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    @Override
    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        this.leftTop = new Point(x, y);
        this.rightBottom = new Point(x + length, y + width);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.leftTop = new Point(leftTop.getX() + dx, leftTop.getY() + dy);
        this.rightBottom = new Point(rightBottom.getX() + dx, rightBottom.getY() + dy);
    }

    @Override
    public void resize(double ratio) {
        stretch(ratio, ratio);
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        int newLength = (int) (getLength() * xRatio);
        int newWidth = (int) (getWidth() * yRatio);
        this.rightBottom = new Point(leftTop.getX() + newLength, leftTop.getY() + newWidth);
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    @Override
    public boolean isInside(int x, int y) {
        return x >= leftTop.getX() && x <= rightBottom.getX() &&
                y >= leftTop.getY() && y <= rightBottom.getY();
    }

    @Override
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isInside(Rectangle rectangle) {
        return leftTop.getX() <= rectangle.leftTop.getX() &&
                leftTop.getY() <= rectangle.leftTop.getY() &&
                rightBottom.getX() >= rectangle.rightBottom.getX() &&
                rightBottom.getY() >= rectangle.rightBottom.getY();
    }

    public boolean isIntersects(Rectangle rectangle) {
        boolean noIntersectX = rightBottom.getX() < rectangle.leftTop.getX() ||
                leftTop.getX() > rectangle.rightBottom.getX();
        boolean noIntersectY = rightBottom.getY() < rectangle.leftTop.getY() ||
                leftTop.getY() > rectangle.rightBottom.getY();
        return !(noIntersectX || noIntersectY);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(leftTop, rectangle.leftTop) && Objects.equals(rightBottom, rectangle.rightBottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftTop, rightBottom);
    }
}