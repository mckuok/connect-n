package logic.player;

import logic.player.controller.GameBoardController;

import java.awt.Color;

/**
 * Created by MC on 2/11/2017.
 */
public class Player {

  private final Color color;
  private final GameBoardController controller;

  public Player(Color color, GameBoardController controller) {
    this.color = color;
    this.controller = controller;
  }

  public Color getColor() {
    return color;
  }

  public void addMovedListener(PlayerMovedListener listener) {
    controller.addMovedListener(listener);
  }

  public void takeControl() {
    controller.move();
  }

  public void releaseControl() {
    controller.releaseControl();
  }

}
