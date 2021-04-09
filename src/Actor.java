//Every object on the screen will inheritance Actor's class.
//It has an action and a position(x,y).

public abstract class Actor {

    final static int tileSize = 64;
    protected double x;
    protected double y;

    public Actor(double x, double y) {
        this.x = x;
        this.y = y;
    }

    abstract void action();

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}
