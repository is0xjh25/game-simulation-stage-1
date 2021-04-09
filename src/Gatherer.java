import bagel.*;
import java.util.Random;

public class Gatherer extends Actor{

    final static int tickSwitch = 5;
    private int tickCount = 0;
    Image image = new Image("res/images/gatherer.png");
    //RandomGen is set for direction changing
    Random randomGen = new Random();
    //Four possible directions(top, down, left, right)
    int theRandomNumber = randomGen.nextInt(4);

    public Gatherer(double x, double y) {
        super(x, y);
    }

    public Image getImage() {
        return image;
    }

    @Override
    public void action() {
        //Changes moving direction per 5 ticks.
        if (tickCount == tickSwitch) {
            theRandomNumber = randomGen.nextInt(4);
            tickCount = 0;
        }

        switch(theRandomNumber) {
            case 0:
                x += tileSize;
                tickCount++;
                break;
            case 1:
                x -= tileSize;
                tickCount++;
                break;
            case 2:
                y += tileSize;
                tickCount++;
                break;
            case 3:
                y -= tileSize;
                tickCount++;
                break;
        }
    }
}