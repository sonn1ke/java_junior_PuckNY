package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Square {
    private Point leftTop;
    private Point rightBottom;
    private int size;

    public Square(Point leftTop, int size) {
        this.leftTop = leftTop;
        this.rightBottom = new Point(
                leftTop.getX() + size,
                leftTop.getY() + size
        );
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
        return this.leftTop;
    }

    public Point getBottomRight() {
        return this.rightBottom;
    }

    public void setTopLeft(Point topLeft) {
        this.leftTop = topLeft;
        this.rightBottom = new Point(
                this.size + topLeft.getX(),
                this.size + topLeft.getY()
        );
    }

    public int getLength() {
        return this.size;
    }

    public void moveTo(int x, int y) {
        this.leftTop = new Point(x, y);
        this.rightBottom = new Point(this.size + x, this.size + y);
    }

    public void moveTo(Point point) {
        this.leftTop = point;
        this.rightBottom = new Point(
                this.size + point.getX(),
                this.size + point.getY()
        );
    }

    public void moveRel(int dx, int dy) {
        this.leftTop = new Point(
                this.leftTop.getX() + dx,
                this.leftTop.getY() + dy
        );
        this.rightBottom = new Point(
                this.rightBottom.getX() + dx,
                this.rightBottom.getY() + dy
        );
    }

    public void resize(double ratio) {
        this.size *= ratio;
        this.rightBottom = new Point(
                this.leftTop.getX() + this.size,
                this.leftTop.getY() + this.size
        );
    }

    public double getArea() {
        return Math.pow(this.size, 2);
    }

    public double getPerimeter() {
        return this.size * 4;
    }

    public boolean isInside(int x, int y) {
        return x >= this.leftTop.getX() &&
                x <= this.rightBottom.getX() &&
                y >= this.leftTop.getY() &&
                y <= this.rightBottom.getY();
    }

    public boolean isInside(Point point) {
        return point.getX() >= this.leftTop.getX() &&
                point.getX() <= this.rightBottom.getX() &&
                point.getY() >= this.leftTop.getY() &&
                point.getY() <= this.rightBottom.getY();
    }

    public boolean isInside(Square square) {
        return this.leftTop.getX() <= square.leftTop.getX() &&
                this.leftTop.getY() <= square.leftTop.getY() &&
                this.rightBottom.getX() >= square.rightBottom.getX() &&
                this.rightBottom.getY() >= square.rightBottom.getY();
    }

    public boolean isIntersects(Square square) {
        return this.leftTop.getX() <= square.rightBottom.getX() &&
                this.rightBottom.getX() >= square.leftTop.getX() &&
                this.leftTop.getY() <= square.rightBottom.getY() &&
                this.rightBottom.getY() >= square.leftTop.getY();
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