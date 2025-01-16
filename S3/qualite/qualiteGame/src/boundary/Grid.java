package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import control.IControl;

public class Grid extends JPanel {
	private IControl control;

	public Grid(IControl c) {
		this.control = c;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if(this.control.score() == 2048) g.setColor(Color.GREEN);
		else if(this.control.isOver()) g.setColor(Color.RED);
		else g.setColor(Color.GRAY);
		
		g.fillRect(0, 0, 440, 440);

		for (int i = 0; i < this.control.getGrid().length; i++) {
			for (int j = 0; j < this.control.getGrid()[0].length; j++) {
				int value = this.control.getGrid()[j][i];

				g.setColor(getCorrespondingColor(value));
				g.fillRect(5 + 110 * i, 5 + 110 * j, 100, 100);

				if (value == 0) continue ;
				
				if (value < 8)
					g.setColor(COLOR_VALUE_DARK);
				else
					g.setColor(COLOR_VALUE_LIGHT);

				
				
				if (value < 9)
					g.setFont(g.getFont().deriveFont(Font.BOLD, 44.0f));
				else if (value < 99)
					g.setFont(g.getFont().deriveFont(Font.BOLD, 40.0f));
				else if (value < 999)
						g.setFont(g.getFont().deriveFont(Font.BOLD, 36.0f));
				else
					g.setFont(g.getFont().deriveFont(Font.BOLD, 32.0f));
				
				FontMetrics frc = g.getFontMetrics();
				Rectangle2D r = frc.getStringBounds(Integer.toString(value), g);
				int x = (int) (5 + 110 * i + (50 - r.getCenterX()));
				int y = (int) (5 + 110 * j + (50 - r.getCenterY()));
				g.drawString(Integer.toString(value), x, y);
			}
		}
	}

	private static final Color COLOR_EMPTY = new Color(204, 192, 179);
	private static final Color COLOR_2 = new Color(238, 228, 218);
	private static final Color COLOR_4 = new Color(237, 224, 200);
	private static final Color COLOR_8 = new Color(242, 177, 121);
	private static final Color COLOR_16 = new Color(245, 149, 99);
	private static final Color COLOR_32 = new Color(246, 124, 95);
	private static final Color COLOR_64 = new Color(246, 94, 59);
	private static final Color COLOR_128 = new Color(237, 207, 114);
	private static final Color COLOR_256 = new Color(237, 204, 97);
	private static final Color COLOR_512 = new Color(237, 200, 80);
	private static final Color COLOR_1024 = new Color(237, 197, 63);
	private static final Color COLOR_2048 = new Color(237, 194, 46);
	private static final Color COLOR_VALUE_LIGHT = new Color(249, 246, 242);
	private static final Color COLOR_VALUE_DARK = new Color(119, 110, 101);

	private static Color getCorrespondingColor(int v) {
		switch (v) {
		case 0:
			return COLOR_EMPTY;
		case 2:
			return COLOR_2;
		case 4:
			return COLOR_4;
		case 8:
			return COLOR_8;
		case 16:
			return COLOR_16;
		case 32:
			return COLOR_32;
		case 64:
			return COLOR_64;
		case 128:
			return COLOR_128;
		case 256:
			return COLOR_256;
		case 512:
			return COLOR_512;
		case 1024:
			return COLOR_1024;
		case 2048:
			return COLOR_2048;
		default:
			return Color.WHITE;
		}
	}

}
