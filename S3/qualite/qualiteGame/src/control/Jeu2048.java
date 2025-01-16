package control;

import entity.Cell;
import entity.Engine;

public class Jeu2048 implements IControl {

    private Engine engine;


    public Jeu2048(){
        init();
    }
    @Override
    public void init() {
        Integer[][]  vals = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        this.engine = new Engine(vals);
    }

    @Override
    public int[][] getGrid() {

    }

    @Override
    public void right() {

    }

    @Override
    public void down() {

    }

    @Override
    public void up() {

    }

    @Override
    public void left() {

    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public int score() {
        return 0;
    }
}
