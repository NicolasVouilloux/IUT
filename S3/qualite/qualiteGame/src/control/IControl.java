package control;

public interface IControl {
	public void init();
	public int[][] getGrid();
	public void right();
	public void down();
	public void up();
	public void left();
	public boolean isOver();
	public int score();
}
