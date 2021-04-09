import bagel.*;

public class ShadowLife extends AbstractGame {

    static final int tickTime = 500;
    private final Image background;
    private final Tree[] trees;
    private final Gatherer[] gatherers;
    private int treeCount = 0;
    private int gathererCount = 0;
    private long setTime = System.currentTimeMillis();
    ReadCSV readCSV = new ReadCSV("res/worlds/test.csv");

    public ShadowLife() {

        background = new Image("res/images/background.png");

        int i = 0;
        int j = 0;
        int k = 0;

        //Starts counting trees and gatherers
        String[] dataArray = readCSV.splitDataText(readCSV.readLine());
        for (i = 0; i < dataArray.length; i++) {
            if (dataArray[i].toLowerCase().equals("tree")) {
                treeCount++;
            }
            else if(dataArray[i].toLowerCase().equals("gatherer")) {
                gathererCount++;
            }
        }

        //Creates arrays
        trees = new Tree[treeCount];
        gatherers = new Gatherer[gathererCount];

        //Inserts data into array
        for (i = 0; i < dataArray.length; i++) {
            if (dataArray[i].toLowerCase().equals("tree")) {
                trees[j] = new Tree(Double.parseDouble(dataArray[i+1]),
                        Double.parseDouble(dataArray[i+2]));
                j++;
            }
            else if(dataArray[i].toLowerCase().equals("gatherer")) {
                gatherers[k] = new Gatherer(Double.parseDouble(dataArray[i+1]),
                        Double.parseDouble(dataArray[i+2]));
                k++;
            }
        }
    }

    @Override
    protected void update(Input input) {

        //Draws background
        background.draw(Window.getWidth() / 2.0, Window.getHeight() / 2.0);

        //Draws trees
        for (int i = 0; i<treeCount; i++) {
            trees[i].getImage().draw(trees[i].getX(), trees[i].getY());
        }

        //Changes gatherers per 500ms
        if (System.currentTimeMillis() - setTime > tickTime) {
            for (int i = 0; i<gathererCount; i++) {
                gatherers[i].action();
            }
            setTime = System.currentTimeMillis();
        }

        //Draws gatherers
        for (int i = 0; i<gathererCount; i++) {
            gatherers[i].getImage().draw(gatherers[i].getX(), gatherers[i].getY());
        }
    }

    //Executes the game
    public static void main(String[] args) {
        System.out.println(args[0]);
        ShadowLife game = new ShadowLife();
        game.run();
    }
}
