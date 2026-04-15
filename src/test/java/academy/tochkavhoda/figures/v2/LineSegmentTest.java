package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.iface.Movable;
import academy.tochkavhoda.figures.v2.iface.Resizable;
import academy.tochkavhoda.figures.v2.iface.Stretchable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LineSegmentTest {

    @Test
    public void testConstructorAndGetters() {
        LineSegment ls = new LineSegment(0, 0, 10, 10);
        assertEquals(0, ls.getStart().getX());
        assertEquals(0, ls.getStart().getY());
        assertEquals(10, ls.getEnd().getX());
        assertEquals(10, ls.getEnd().getY());
    }

    @Test
    public void testPointConstructor() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(5, 6);
        LineSegment ls = new LineSegment(p1, p2);
        assertSame(p1, ls.getStart());
        assertSame(p2, ls.getEnd());
    }

    @Test
    public void testLength() {
        LineSegment ls1 = new LineSegment(0, 0, 3, 4);
        assertEquals(5.0, ls1.length(), 1e-9);

        LineSegment ls2 = new LineSegment(1, 1, 1, 1);
        assertEquals(0.0, ls2.length(), 1e-9);
    }

    @Test
    public void testMoveTo() {
        LineSegment ls = new LineSegment(0, 0, 10, 10);
        ls.moveTo(5, 5);
        assertEquals(5, ls.getStart().getX());
        assertEquals(5, ls.getStart().getY());
        assertEquals(15, ls.getEnd().getX());
    }

    @Test
    public void testMoveRel() {
        LineSegment ls = new LineSegment(1, 2, 3, 4);
        ls.moveRel(10, 20);
        assertEquals(11, ls.getStart().getX());
        assertEquals(22, ls.getStart().getY());
        assertEquals(13, ls.getEnd().getX());
        assertEquals(24, ls.getEnd().getY());
    }

    @Test
    public void testStretch() {
        LineSegment ls = new LineSegment(2, 2, 4, 6);
        ls.stretch(2.0, 3.0);
        // start = (2,2), delta = (2,4) -> (4,12) => end = (2+4, 2+12) = (6,14)
        assertEquals(2, ls.getStart().getX());
        assertEquals(2, ls.getStart().getY());
        assertEquals(6, ls.getEnd().getX());
        assertEquals(14, ls.getEnd().getY());
    }

    @Test
    public void testResize() {
        LineSegment ls = new LineSegment(0, 0, 10, 20);
        ls.resize(0.5);
        assertEquals(0, ls.getStart().getX());
        assertEquals(0, ls.getStart().getY());
        assertEquals(5, ls.getEnd().getX());
        assertEquals(10, ls.getEnd().getY());
    }

    @Test
    public void testInterfaces() {
        LineSegment ls = new LineSegment(0, 0, 1, 1);
        assertInstanceOf(Movable.class, ls);
        assertInstanceOf(Stretchable.class, ls);
        assertInstanceOf(Resizable.class, ls);
    }

    @Test
    public void testEqualsAndHashCode() {
        LineSegment ls1 = new LineSegment(0, 0, 5, 5);
        LineSegment ls2 = new LineSegment(0, 0, 5, 5);
        LineSegment ls3 = new LineSegment(1, 1, 6, 6);
        assertEquals(ls1, ls2);
        assertNotEquals(ls1, ls3);
        assertEquals(ls1.hashCode(), ls2.hashCode());
    }
}
