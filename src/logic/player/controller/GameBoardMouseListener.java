package logic.player.controller;

import gui.Cell;
import gui.GameBoard;
import gui.Piece;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by MC on 2/12/2017.
 */
public class GameBoardMouseListener extends GameController implements MouseListener{

  private MouseListener mouseListener;

  public GameBoardMouseListener(Color playerColor, GameBoard gameBoard) {
    super(playerColor, gameBoard);
    mouseListener = this;
  }

  @Override
  public void move() {
    getGameBoard().addMouseListener(mouseListener);
  }

  @Override
  public void releaseControl() {
    getGameBoard().removeMouseListener(mouseListener);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    Component component = getGameBoard().getComponentAt(e.getX(), e.getY());
    int col = -1;
    if (component instanceof Cell) {
      Cell cell = (Cell) component;
      col = cell.getCol();
    } else if (component instanceof Piece) {
      Piece piece = (Piece) component;
      col = piece.getCol();
    }

    if (col != -1) {
      Point point = getGameBoard().add(new Piece(getPlayerColor(), col), col);
      if (point != null) {
        notifyMovedListeners(point);
      }
    }
  }

  @Override
  public final void mouseClicked(MouseEvent e) {}

  @Override
  public final void mousePressed(MouseEvent e) {}

  @Override
  public final void mouseEntered(MouseEvent e) {}

  @Override
  public final void mouseExited(MouseEvent e) {}

}
