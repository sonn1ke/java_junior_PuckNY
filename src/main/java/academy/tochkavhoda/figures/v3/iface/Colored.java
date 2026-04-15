package academy.tochkavhoda.figures.v3.iface;

import academy.tochkavhoda.figures.v3.iface.Color;
import academy.tochkavhoda.figures.v3.iface.ColorException;

public interface Colored {
    void setColor(Color color) throws ColorException;  // добавлено throws
    Color getColor();
    void setColor(String colorString) throws ColorException;
}