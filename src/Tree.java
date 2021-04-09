import bagel.*;

public class Tree extends Actor{

    Image image = new Image("res/images/tree.png");

    public Tree(double x, double y) {
        super(x, y);
    }

    public Image getImage() {
        return image;
    }

    //No action for a stationary tree
    @Override
    public void action(){}
}
