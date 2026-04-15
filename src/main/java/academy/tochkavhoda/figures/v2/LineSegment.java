package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.iface.Movable;
import academy.tochkavhoda.figures.v2.iface.Stretchable;

import java.util.Objects;

public class LineSegment implements Movable, Stretchable {
    private Point start;
    private Point end;

    public LineSegment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public LineSegment(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Point getStart() { return start; }
    public Point getEnd() { return end; }
    public void setStart(Point start) { this.start = start; }
    public void setEnd(Point end) { this.end = end; }

    public double length() {
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public void moveTo(int x, int y) {
        int dx = x - start.getX();
        int dy = y - start.getY();
        moveRel(dx, dy);
    }

    @Override
    public void moveRel(int dx, int dy) {
        start.moveRel(dx, dy);
        end.moveRel(dx, dy);
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        int newEndX = (int)(start.getX() + (end.getX() - start.getX()) * xRatio);
        int newEndY = (int)(start.getY() + (end.getY() - start.getY()) * yRatio);
        end = new Point(newEndX, newEndY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineSegment that = (LineSegment) o;
        return Objects.equals(start, that.start) && Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}