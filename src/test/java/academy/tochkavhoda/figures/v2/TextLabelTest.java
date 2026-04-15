package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.iface.Colored;
import academy.tochkavhoda.figures.v2.iface.Movable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextLabelTest {

    @Test
    public void testConstructorAndGetters() {
        TextLabel tl = new TextLabel(10, 20, "Hello", 5);
        assertEquals(10, tl.getPosition().getX());
        assertEquals(20, tl.getPosition().getY());
        assertEquals("Hello", tl.getText());
        assertEquals(5, tl.getColor());
    }

    @Test
    public void testPointConstructor() {
        Point p = new Point(30, 40);
        TextLabel tl = new TextLabel(p, "World", 7);
        assertSame(p, tl.getPosition());
        assertEquals("World", tl.getText());
        assertEquals(7, tl.getColor());
    }

    @Test
    public void testSetters() {
        TextLabel tl = new TextLabel(0, 0, "", 0);
        tl.setPosition(new Point(100, 200));
        tl.setText("New Text");
        tl.setColor(9);
        assertEquals(100, tl.getPosition().getX());
        assertEquals(200, tl.getPosition().getY());
        assertEquals("New Text", tl.getText());
        assertEquals(9, tl.getColor());
    }

    @Test
    public void testMoveTo() {
        TextLabel tl = new TextLabel(5, 5, "Test", 1);
        tl.moveTo(50, 60);
        assertEquals(50, tl.getPosition().getX());
        assertEquals(60, tl.getPosition().getY());
    }

    @Test
    public void testMoveRel() {
        TextLabel tl = new TextLabel(10, 20, "Test", 1);
        tl.moveRel(3, 4);
        assertEquals(13, tl.getPosition().getX());
        assertEquals(24, tl.getPosition().getY());
    }

    @Test
    public void testInterfaces() {
        TextLabel tl = new TextLabel(0, 0, "A", 1);
        assertInstanceOf(Movable.class, tl);
        assertInstanceOf(Colored.class, tl);
    }

    @Test
    public void testEqualsAndHashCode() {
        TextLabel tl1 = new TextLabel(1, 2, "ABC", 3);
        TextLabel tl2 = new TextLabel(1, 2, "ABC", 3);
        TextLabel tl3 = new TextLabel(1, 2, "DEF", 3);
        TextLabel tl4 = new TextLabel(5, 5, "ABC", 3);

        assertEquals(tl1, tl2);
        assertNotEquals(tl1, tl3);
        assertNotEquals(tl1, tl4);
        assertEquals(tl1.hashCode(), tl2.hashCode());
    }
}