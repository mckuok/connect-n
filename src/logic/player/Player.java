package logic.player;

import logic.player.controller.GameController;

import java.awt.Color;

/**
 * Created by MC on 2/11/2017.
 */
public class Player {

  private final Color color;
  private final GameController controller;

  public Player(Color color, GameController controller) {
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
