package gui;

import logic.checker.CellStatus;
import logic.checker.VictoryChecker;
import logic.player.PlayerMovedListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;


/**
 * Created by MC on 2/10/2017.
 */
public class GameBoard extends JPanel {

  private static final int GAP_SPACE = 5;

  private Cell[][] cells;

  public GameBoard(int numRow, int numCol) {
    setLayout(new GridLayout(numRow, numCol, GAP_SPACE, GAP_SPACE));

    cells  = new Cell[numRow][numCol];
    for (int i = cells.length -1; i >=0 ; i--) {
      for (int j = 0; j < cells[0].length ; j++) {
        cells[i][j] = new Cell(j);
        add(cells[i][j]);
      }
    }
  }

  public Point add(Piece piece, int col) {
    int row = -1;
    for (int i = 0; i < cells.length; i++) {
      if (cells[i][col].getComponents().length == 0) {
        row = i;
        break;
      }
    }

    if (row == -1) {
      return null;
    }

    cells[row][col].add(piece, JLabel.CENTER);
    revalidate();
    repaint();

    return new Point(col, row);
  }

  public void displayVictoryMessage() {
    JOptionPane.showMessageDialog(this, "You won.", "Congratulation", JOptionPane.INFORMATION_MESSAGE);
  }

  public void displayDrawMessage() {
    JOptionPane.showMessageDialog(this, "Game is draw.", "Boooo", JOptionPane.INFORMATION_MESSAGE);
  }


  public CellStatus[][] getPiecesDistribution(Color playerColor) {
    CellStatus[][] piecesDistribution = new CellStatus[cells.length][cells[0].length];
    for (int i = cells.length -1; i >=0 ; i--) {
      for (int j = 0; j < cells[0].length ; j++) {
       Cell cell = cells[i][j];
       if (cell.getComponents().length == 0) {
         piecesDistribution[i][j] = CellStatus.EMPTY;
       } else {
         if (cell.getComponents()[0] instanceof Piece) {
           Piece piece = (Piece) cell.getComponents()[0];
           if (piece.getColor().equals(playerColor)) {
             piecesDistribution[i][j] = CellStatus.PLAYER;
           } else {
             piecesDistribution[i][j] = CellStatus.OPPONENT;
           }
         }
       }
      }
    }

    return piecesDistribution;
  }

  public PlayerMovedListener getMovedListener() {
    return new CellMovedHighlighter();
  }

  private class CellMovedHighlighter implements PlayerMovedListener {

    private Cell previousCell;

    @Override
    public void moved(Point point) {
      if (previousCell == null) {
        previousCell = cells[(int) point.getY()][(int) point.getX()];
      }
      previousCell.setBackground(null);
      cells[(int) point.getY()][(int) point.getX()].setBackground(Color.CYAN);
      previousCell = cells[(int) point.getY()][(int) point.getX()];
    }
  }

}
