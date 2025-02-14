package serveur;

public class Grid {
	public int[][] grid;
	
	public Grid() {
		
		this.grid = new int[3][3];

		for (int i = 0;i<3;i++) {
			for (int j = 0;i<3;i++) {
				this.grid[i][j] = 0;
			}
		}
	}
	public boolean alreadyPlayed(int x,int y) {
		if (this.grid[x][y]!=0)
			return true;
		else return false;
	}
	public String printGrid() {
		String printGrid = "";
		for (int i = 0;i<3;i++) {
			for (int j = 0;i<3;i++) {
				printGrid += this.grid[i][j];
			}
		}//test car ne marche pas sur plusieur ligne mais ne marche pas egalement sur une seule
	
		System.out.println(printGrid);
		return printGrid;
	}
	public boolean isTie() {
		for (int i = 0;i<3;i++) {
			for (int j = 0;i<3;i++) {
				if (this.grid[i][j] != 0)return false;
			}
		}
		return true;
	}
	public void setCell(int x,int y,int val ) {
		this.grid[x][y] = val;
	}
}
