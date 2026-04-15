package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.iface.HasArea;
import academy.tochkavhoda.figures.v2.iface.Movable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IconTest {

    @Test
    public void testConstructorAndGetters() {
        Icon icon = new Icon(10, 20, 30, 40);
        assertEquals(10, icon.getPosition().getX());
        assertEquals(20, icon.getPosition().getY());
        assertEquals(30, icon.getWidth());
        assertEquals(40, icon.getHeight());
    }

    @Test
    public void testPointConstructor() {
        Point p = new Point(5, 6);
        Icon icon = new Icon(p, 100, 200);
        assertSame(p, icon.getPosition());
        assertEquals(100, icon.getWidth());
        assertEquals(200, icon.getHeight());
    }

    @Test
    public void testSetters() {
        Icon icon = new Icon(0, 0, 0, 0);
        icon.setPosition(new Point(1, 2));
        icon.setWidth(50);
        icon.setHeight(60);
        assertEquals(1, icon.getPosition().getX());
        assertEquals(2, icon.getPosition().getY());
        assertEquals(50, icon.getWidth());
        assertEquals(60, icon.getHeight());
    }

    @Test
    public void testGetArea() {
        Icon icon1 = new Icon(0, 0, 10, 20);
        assertEquals(200.0, icon1.getArea(), 1e-9);

        Icon icon2 = new Icon(0, 0, 0, 100);
        assertEquals(0.0, icon2.getArea(), 1e-9);
    }

    @Test
    public void testMoveTo() {
        Icon icon = new Icon(1, 1, 5, 5);
        icon.moveTo(100, 200);
        assertEquals(100, icon.getPosition().getX());
        assertEquals(200, icon.getPosition().getY());
    }

    @Test
    public void testMoveRel() {
        Icon icon = new Icon(10, 20, 30, 40);
        icon.moveRel(-5, 10);
        assertEquals(5, icon.getPosition().getX());
        assertEquals(30, icon.getPosition().getY());
    }

    @Test
    public void testInterfaces() {
        Icon icon = new Icon(0, 0, 1, 1);
        assertInstanceOf(Movable.class, icon);
        assertInstanceOf(HasArea.class, icon);
    }

    @Test
    public void testEqualsAndHashCode() {
        Icon icon1 = new Icon(1, 2, 3, 4);
        Icon icon2 = new Icon(1, 2, 3, 4);
        Icon icon3 = new Icon(1, 2, 5, 4);
        Icon icon4 = new Icon(5, 5, 3, 4);

        assertEquals(icon1, icon2);
        assertNotEquals(icon1, icon3);
        assertNotEquals(icon1, icon4);
        assertEquals(icon1.hashCode(), icon2.hashCode());
    }
}