package academy.tochkavhoda.figures.v3;

import java.util.Objects;

public class Square extends Figure {
    private Point leftTop;
    private Point rightBottom;
    private int size;

    public Square(Point leftTop, int size) {
        this.leftTop = leftTop;
        this.rightBottom = new Point(leftTop.getX() + size, leftTop.getY() + size);
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this.leftTop = new Point(xLeft, yTop);
        this.rightBottom = new Point(xLeft + size, yTop + size);
        this.size = size;
    }

    public Square(int size) {
        this.leftTop = new Point(0, -size);
        this.rightBottom = new Point(size, 0);
        this.size = size;
    }

    public Square() {
        this.leftTop = new Point(0, -1);
        this.rightBottom = new Point(1, 0);
        this.size = 1;
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point topLeft) {
        this.leftTop = topLeft;
        this.rightBottom = new Point(size + topLeft.getX(), size + topLeft.getY());
    }

    public int getLength() {
        return size;
    }

    @Override
    public void moveTo(int x, int y) {
        this.leftTop = new Point(x, y);
        this.rightBottom = new Point(size + x, size + y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.leftTop = new Point(leftTop.getX() + dx, leftTop.getY() + dy);
        this.rightBottom = new Point(rightBottom.getX() + dx, rightBottom.getY() + dy);
    }

    @Override
    public void resize(double ratio) {
        this.size = (int) (size * ratio);
        this.rightBottom = new Point(leftTop.getX() + size, leftTop.getY() + size);
    }

    @Override
    public double getArea() {
        return size * size;
    }

    @Override
    public double getPerimeter() {
        return 4 * size;
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

    public boolean isInside(Square square) {
        return leftTop.getX() <= square.leftTop.getX() &&
                leftTop.getY() <= square.leftTop.getY() &&
                rightBottom.getX() >= square.rightBottom.getX() &&
                rightBottom.getY() >= square.rightBottom.getY();
    }

    public boolean isIntersects(Square square) {
        return leftTop.getX() <= square.rightBottom.getX() &&
                rightBottom.getX() >= square.leftTop.getX() &&
                leftTop.getY() <= square.rightBottom.getY() &&
                rightBottom.getY() >= square.leftTop.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return size == square.size && Objects.equals(leftTop, square.leftTop) && Objects.equals(rightBottom, square.rightBottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftTop, rightBottom, size);
    }
}