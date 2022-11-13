public class Rectangle {
    private Point a;
    private Point c;

    public Rectangle(Point a, Point c) {
        this.a = a;
        this.c = c;
    }

    public boolean contains(Point d){
        return d.greaterOrEqual(a) && d.lessOrEqual(c);

    }

}
