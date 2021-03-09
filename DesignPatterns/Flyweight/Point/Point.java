package DesignPatterns.Flyweight.Point;

public class Point {
    private final PointIcon icon;
    private final int x;
    private final int y;

    public Point(int x, int y, PointIcon icon) {
        this.x = x;
        this.y = y;
        this.icon = icon;
    }

    public void draw() {
        System.out.printf("%s at (%d, %d)", icon.getType(), x , y);
    }
}
