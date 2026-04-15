package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.figures.v3.iface.Colored;
import academy.tochkavhoda.figures.v3.iface.Movable;

import java.util.Objects;

import academy.tochkavhoda.figures.v3.iface.Color;
import academy.tochkavhoda.figures.v3.iface.ColorException;
import academy.tochkavhoda.figures.v3.Point;
import academy.tochkavhoda.figures.v3.iface.Colored;
import academy.tochkavhoda.figures.v3.iface.Movable;
import java.util.Objects;

public class TextLabel implements Movable, Colored {
    private Point position;
    private String text;
    private Color color;

    public TextLabel(Point position, String text, Color color) {
        this.position = position;
        this.text = text;
        this.color = color;
    }

    public TextLabel(int x, int y, String text, Color color) {
        this(new Point(x, y), text, color);
    }

    // Конструкторы со String
    public TextLabel(Point position, String text, String colorString) throws ColorException {
        this(position, text, Color.colorFromString(colorString));
    }

    public TextLabel(int x, int y, String text, String colorString) throws ColorException {
        this(new Point(x, y), text, Color.colorFromString(colorString));
    }

    public Point getPosition() { return position; }
    public String getText() { return text; }
    public void setPosition(Point position) { this.position = position; }
    public void setText(String text) { this.text = text; }

    @Override
    public Color getColor() { return color; }

    @Override
    public void setColor(Color color) { this.color = color; }

    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
    }

    @Override
    public void moveTo(int x, int y) {
        position.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        position.moveRel(dx, dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextLabel textLabel = (TextLabel) o;
        return color == textLabel.color &&
                Objects.equals(position, textLabel.position) &&
                Objects.equals(text, textLabel.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, text, color);
    }
}