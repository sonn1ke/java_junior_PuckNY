package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.figures.v3.iface.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import academy.tochkavhoda.figures.v3.iface.Color;
import academy.tochkavhoda.figures.v3.iface.ColorException;
import academy.tochkavhoda.figures.v3.ColoredRectangle;
import academy.tochkavhoda.figures.v3.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestColoredRectangle {

    @Test
    public void testColorEnumConstructors() {
        ColoredRectangle r = new ColoredRectangle(Color.GREEN);
        assertEquals(Color.GREEN, r.getColor());
    }

    @Test
    public void testSetColorEnum() {
        ColoredRectangle r = new ColoredRectangle();
        r.setColor(Color.BLUE);
        assertEquals(Color.BLUE, r.getColor());
    }

    @Test
    public void testStringConstructorValid() throws ColorException {
        ColoredRectangle r = new ColoredRectangle("RED");
        assertEquals(Color.RED, r.getColor());
    }

    @Test
    public void testStringConstructorInvalid() {
        assertThrows(ColorException.class, () -> new ColoredRectangle("YELLOW"));
    }

    @Test
    public void testStringConstructorNull() {
        assertThrows(ColorException.class, () -> new ColoredRectangle((String) null));
    }

    @Test
    public void testSetColorStringValid() throws ColorException {
        ColoredRectangle r = new ColoredRectangle();
        r.setColor("GREEN");
        assertEquals(Color.GREEN, r.getColor());
    }

    @Test
    public void testSetColorStringInvalid() {
        ColoredRectangle r = new ColoredRectangle();
        assertThrows(ColorException.class, () -> r.setColor("PURPLE"));
    }
}