package logic.player.controller;

import gui.GameBoard;
import logic.player.PlayerMovedListener;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by MC on 2/12/2017.
 */
public abstract class GameController {

  private final GameBoard gameBoard;
  private final Color playerColor;

  private final List<PlayerMovedListener> movedListeners = new LinkedList<>();

  public GameController(Color playerColor, GameBoard gameBoard) {
    this.gameBoard = gameBoard;
    this.playerColor = playerColor;
  }

  protected GameBoard getGameBoard() {
    return gameBoard;
  }

  public Color getPlayerColor() {
    return playerColor;
  }

  public void addMovedListener(PlayerMovedListener listener) {
    movedListeners.add(listener);
  }

  public void notifyMovedListeners(Point point) {
    movedListeners.forEach(listener -> listener.moved(point));
  }

  public abstract void move();

  public abstract void releaseControl(  );

}
