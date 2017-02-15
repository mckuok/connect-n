package logic.checker;

/**
 * Created by MC on 2/14/2017.
 */
public class DirectionCheckIndicator {

  private final boolean up;
  private final boolean down;
  private final boolean right;
  private final boolean left;

  private DirectionCheckIndicator(int directions) {
    // directions (up, down, left, right)
    up = (directions & getUpDirection()) > 0;
    down = (directions & getDownDirection()) > 0;
    right = (directions & getRightDirection()) > 0;
    left = (directions & getLeftDirection()) > 0;
  }

  public static DirectionCheckIndicator up() {
    return new DirectionCheckIndicator(getUpDirection());
  }

  public static DirectionCheckIndicator down() {
    return new DirectionCheckIndicator(getDownDirection());
  }

  public static DirectionCheckIndicator left() {
    return new DirectionCheckIndicator(getLeftDirection());
  }

  public static DirectionCheckIndicator right() {
    return new DirectionCheckIndicator(getRightDirection());
  }

  public static DirectionCheckIndicator upRight() {
    return new DirectionCheckIndicator(getUpDirection() | getRightDirection());
  }

  public static DirectionCheckIndicator upLeft() {
    return new DirectionCheckIndicator(getUpDirection() | getLeftDirection());
  }

  public static DirectionCheckIndicator downRight() {
    return new DirectionCheckIndicator(getDownDirection() | getRightDirection());
  }

  public static DirectionCheckIndicator downLeft() {
    return new DirectionCheckIndicator(getDownDirection() | getLeftDirection());
  }

  private static int getUpDirection() {
    return 0b1000;
  }

  private static int getDownDirection() {
    return 0b0100;
  }

  private static int getLeftDirection() {
    return 0b0010;
  }

  private static int getRightDirection() {
    return 0b0001;
  }

  public boolean isUp() {
    return up;
  }

  public boolean isDown() {
    return down;
  }

  public boolean isRight() {
    return right;
  }

  public boolean isLeft() {
    return left;
  }
}
