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
        this.engine = new Engine(4,4);
        this.engine.addNewCell();
        this.engine.addNewCell();
    }

    @Override
    public int[][] getGrid() {
        int[][] tab = new int[this.engine.getHeight()][this.engine.getWidth()];
        for (int i = 0;i<this.engine.getHeight();i++){
            for (int j = 0;j<this.engine.getWidth();j++){
                tab[i][j]= this.engine.getCell(i,j);
            }
        }
        return tab;
    }

    public void rotate(){
        int[][] rotated = getGrid();

        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                this.engine.setCell(j,i,rotated[rotated.length-1-i][j]);
            }
        }
    }
    public void moveRight(){
        for (int i = getGrid().length - 1; i > 0; i--) {
            for (int j = getGrid().length - 1; j > 0; j--) {
                if (i != getGrid().length-1) {
                    if (getGrid()[i + 1][j] == 0) {
                        this.engine.setCell(i+1,j,getGrid()[i][j]);
                        this.engine.setCell(i,j,0);
                    }
                }
            }
        }
    }
    @Override
    public void  right() {
        moveRight();
    }

    @Override
    public void down() {
        rotate();
        rotate();
        rotate();
        right();
        rotate();

    }

    @Override
    public void up() {
        rotate();
        right();
        rotate();
        rotate();
        rotate();
    }

    @Override
    public void left() {
        rotate();
        rotate();
        right();
        rotate();
        rotate();

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
