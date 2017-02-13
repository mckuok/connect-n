package gui;


import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

/**
 * Created by MC on 2/10/2017.
 */
public class Cell extends JPanel {

  private final int col;

  public Cell(int col) {
    super();
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    setLayout(new GridLayout(1, 1));

    this.col = col;
  }

  public int getCol() {
    return col;
  }

}
