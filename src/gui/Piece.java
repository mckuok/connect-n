package gui;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by MC on 2/10/2017.
 */
public class Piece extends JLabel {

  private final Color color;
  private final int col;

  public Piece(Color color, int col) {
    super("", SwingConstants.CENTER);
    this.color = color;
    this.col = col;
  }

  @Override
  public void paintComponent(Graphics g) {
    g.setColor(color);
    g.fillOval(0, 0, getHeight(), getHeight());
  }

  public int getCol() {
    return col;
  }

  public Color getColor() {
    return color;
  }
}
