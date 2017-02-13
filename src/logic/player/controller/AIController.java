package logic.player.controller;

import gui.GameBoard;
import gui.Piece;

import java.awt.Color;
import java.awt.Point;

/**
 * Created by MC on 2/12/2017.
 */
public class AIController extends GameBoardController {

  public AIController(Color playerColor, GameBoard gameBoard) {
    super(playerColor, gameBoard);
  }

  @Override
  public void move() {
    for(int i = 0; i < 10; i++) {
      Point point = getGameBoard().add(new Piece(getPlayerColor(), i), i);
      if (point != null) {
        notifyMovedListeners(point);
        break;
      }
    }
  }

  @Override
  public void releaseControl() {

  }
}
