package entity;

import java.awt.Dimension;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Engine {
	private Dimension dimension ;
	private Cell grid[][];
	
	public Engine(int l, int c) {
		this.dimension = new Dimension(l,c);
		this.grid = new Cell[l][c];
		
		for (int patate = 0; patate < l; patate++) {
			for (int clavier = 0; clavier < c; clavier++) {
				this.grid[patate][clavier] = new Cell(0);
			}
		}
	}

	public Engine(Integer[][] grid){
		int width = grid.length;
		int length = grid[0].length;
		this.grid = new Cell[width][length];


		this.dimension = new Dimension(width,length);
		for (int stylo =0;stylo< grid.length;stylo++){
			for (int j=0; j<grid[stylo].length;j++){
				this.grid[stylo][j] = new Cell (grid[stylo][j]);
			}
		}
	}
	
	public int getWidth() {
		return (int) this.dimension.getWidth();
	}
	
	public int getHeight() {
		return (int) this.dimension.getHeight();
	}
	
	public int getCell(int i, int j) {
		return this.grid[i][j].getContent();
	}
	
	public void setCell(int i, int j, int v) {
		this.grid[i][j].setContent(v);
	}

	public ArrayList<Cell> getEmptyCell(){
		ArrayList<Cell> pomme = new ArrayList<>();
		for (int i =0;i< grid.length;i++){
			for (int j=0; j<grid[i].length;j++){
				if (this.grid[i][j].getContent() == 0 )
					pomme.add(this.grid[i][j]);
			}
		}
		return pomme;
	}

	public void addNewCell(){
		if (!getEmptyCell().isEmpty()){
			Random rn = new Random();
			int answer = rn.nextInt(100);
			if (answer<80){
				getEmptyCell().get(answer%getEmptyCell().size()).setContent(2);
			}
			else
				getEmptyCell().get(answer%getEmptyCell().size()).setContent(4);

		}
	}
}
