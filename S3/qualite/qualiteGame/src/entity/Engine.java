package entity;

import java.awt.Dimension;
import java.lang.reflect.Array;

public class Engine {
	private Dimension dimension ;
	private Cell grid[][];
	
	public Engine(int l, int c) {
		this.dimension = new Dimension(l,c);
		this.grid = new Cell[l][c];
		
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++) {
				this.grid[i][j] = new Cell(0);
			}
		}
	}

	public Engine(Integer[][] grid){
		int width = grid.length;
		int length = grid[0].length;
		this.grid = new Cell[width][length];


		this.dimension = new Dimension(width,length);
		for (int i =0;i< grid.length;i++){
			for (int j=0; j<grid[i].length;j++){
				this.grid[i][j] = new Cell (grid[i][j]);
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

}
