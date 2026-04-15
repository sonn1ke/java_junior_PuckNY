package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.iface.Colored;
import academy.tochkavhoda.figures.v2.iface.Movable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColoredPointTest {

    @Test
    public void testConstructorAndGetters() {
        ColoredPoint cp = new ColoredPoint(3, 5, 2);
        assertEquals(3, cp.getX());
        assertEquals(5, cp.getY());
        assertEquals(2, cp.getColor());
    }

    @Test
    public void testDefaultConstructor() {
        ColoredPoint cp = new ColoredPoint();
        assertEquals(0, cp.getX());
        assertEquals(0, cp.getY());
        assertEquals(1, cp.getColor());
    }

    @Test
    public void testColorConstructor() {
        ColoredPoint cp = new ColoredPoint(7);
        assertEquals(0, cp.getX());
        assertEquals(0, cp.getY());
        assertEquals(7, cp.getColor());
    }

    @Test
    public void testSetters() {
        ColoredPoint cp = new ColoredPoint(1, 2, 3);
        cp.setX(10);
        cp.setY(20);
        cp.setColor(5);
        assertEquals(10, cp.getX());
        assertEquals(20, cp.getY());
        assertEquals(5, cp.getColor());
    }

    @Test
    public void testMovableInterface() {
        ColoredPoint cp = new ColoredPoint(1, 1, 1);
        cp.moveTo(5, 6);
        assertEquals(5, cp.getX());
        assertEquals(6, cp.getY());

        cp.moveRel(2, 3);
        assertEquals(7, cp.getX());
        assertEquals(9, cp.getY());
    }

    @Test
    public void testColoredInterface() {
        Colored cp = new ColoredPoint(1, 2, 8);
        assertEquals(8, cp.getColor());
        cp.setColor(10);
        assertEquals(10, cp.getColor());
    }

    @Test
    public void testEqualsAndHashCode() {
        ColoredPoint cp1 = new ColoredPoint(1, 2, 3);
        ColoredPoint cp2 = new ColoredPoint(1, 2, 3);
        ColoredPoint cp3 = new ColoredPoint(1, 2, 4);
        ColoredPoint cp4 = new ColoredPoint(2, 2, 3);

        assertEquals(cp1, cp2);
        assertNotEquals(cp1, cp3);
        assertNotEquals(cp1, cp4);

        assertEquals(cp1.hashCode(), cp2.hashCode());
    }

    @Test
    public void testInheritance() {
        ColoredPoint cp = new ColoredPoint(1, 2, 3);
        assertInstanceOf(Point.class, cp);
        assertInstanceOf(Movable.class, cp);
        assertInstanceOf(Colored.class, cp);
    }
}
