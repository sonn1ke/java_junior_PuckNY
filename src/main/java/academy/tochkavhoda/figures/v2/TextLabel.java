package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.iface.Colored;
import academy.tochkavhoda.figures.v2.iface.Movable;

import java.util.Objects;

public class TextLabel implements Movable, Colored {
    private Point position;
    private String text;
    private int color;

    public TextLabel(Point position, String text, int color) {
        this.position = position;
        this.text = text;
        this.color = color;
    }

    public TextLabel(int x, int y, String text, int color) {
        this(new Point(x, y), text, color);
    }

    public Point getPosition() { return position; }
    public String getText() { return text; }
    public void setPosition(Point position) { this.position = position; }
    public void setText(String text) { this.text = text; }

    @Override
    public int getColor() { return color; }

    @Override
    public void setColor(int color) { this.color = color; }

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