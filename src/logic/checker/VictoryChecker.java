package logic.checker;

import java.awt.Point;

/**
 * Created by MC on 2/12/2017.
 */
public class VictoryChecker {

  private final int winningCount;

  public VictoryChecker(int winningCount) {
    this.winningCount = winningCount;
  }

  public boolean draw(CellStatus[][] pieceDistribution) {
    for (int i = 0; i < pieceDistribution.length; i++) {
      for (int j = 0; j < pieceDistribution[0].length; j++) {
        if (pieceDistribution[i][j].equals(CellStatus.EMPTY)) {
          return false;
        }
      }
    }

    return true;
  }

  // TODO check only the most recent piece
  public boolean playerWon(CellStatus[][] pieceDistribution, Point point) {
    if (checkUp(pieceDistribution, (int) point.getX(), (int) point.getY()) ||
        checkLeft(pieceDistribution, (int) point.getX(), (int) point.getY()) ||
        checkRight(pieceDistribution, (int) point.getX(), (int) point.getY()) ||
        checkUpLeft(pieceDistribution, (int) point.getX(), (int) point.getY()) ||
        checkUpRight(pieceDistribution, (int) point.getX(), (int) point.getY()) ||
        checkDown(pieceDistribution, (int) point.getX(), (int) point.getY()) ||
        checkDownLeft(pieceDistribution, (int) point.getX(), (int) point.getY()) ||
        checkDownRight(pieceDistribution, (int) point.getX(), (int) point.getY())) {
      return true;
    }

    return false;

}

  private boolean checkUp(CellStatus[][] pieceDistribution, int centerX, int centerY) {
    if (checkUpBoundary(pieceDistribution.length, centerY)) {
      return checkDirection(pieceDistribution, centerX, centerY, DirectionCheckIndicator.up());
    }
    return false;
  }

  private boolean checkDown(CellStatus[][] pieceDistribution, int centerX, int centerY) {
    if (checkDownBoundary(centerY)) {
      return checkDirection(pieceDistribution, centerX, centerY, DirectionCheckIndicator.down());
    }
    return false;
  }

  private boolean checkRight(CellStatus[][] pieceDistribution, int centerX, int centerY) {
    if (checkRightBoundary(pieceDistribution[0].length, centerX)) {
      return checkDirection(pieceDistribution, centerX, centerY, DirectionCheckIndicator.right());
    }
    return false;
  }


  private boolean checkLeft(CellStatus[][] pieceDistribution, int centerX, int centerY) {
    if (checkLeftBoundary(centerX)) {
      return checkDirection(pieceDistribution, centerX, centerY, DirectionCheckIndicator.left());
    }
    return false;
  }

  private boolean checkUpRight(CellStatus[][] pieceDistribution, int centerX, int centerY) {
    if (checkUpBoundary(pieceDistribution.length, centerY) && checkRightBoundary(pieceDistribution[0].length, centerX)) {
      return checkDirection(pieceDistribution, centerX, centerY, DirectionCheckIndicator.upRight());
    }
    return false;
  }

  private boolean checkUpLeft(CellStatus[][] pieceDistribution, int centerX, int centerY) {
    if (checkUpBoundary(pieceDistribution.length, centerY) && checkLeftBoundary(centerX)) {
      return checkDirection(pieceDistribution, centerX, centerY, DirectionCheckIndicator.upLeft());
    }
    return false;
  }

  private boolean checkDownLeft(CellStatus[][] pieceDistribution, int centerX, int centerY) {
    if (checkDownBoundary(centerY) && checkLeftBoundary(centerX)) {
      return checkDirection(pieceDistribution, centerX, centerY, DirectionCheckIndicator.downLeft());
    }
    return false;
  }

  private boolean checkDownRight(CellStatus[][] pieceDistribution, int centerX, int centerY) {
    if (checkDownBoundary(centerY) && checkRightBoundary(pieceDistribution[0].length, centerX)) {
      return checkDirection(pieceDistribution, centerX, centerY, DirectionCheckIndicator.downRight());
    }
    return false;
  }

  private boolean checkUpBoundary(int height, int originY) {
    return height - winningCount >= originY;
  }

  private boolean checkRightBoundary(int width, int originX) {
    return width - winningCount >= originX;
  }

  private boolean checkLeftBoundary(int originX) {
    return originX >= winningCount - 1;
  }

  private boolean checkDownBoundary(int originY) {
    return originY >= winningCount - 1;
  }

  private boolean checkDirection(CellStatus[][] pieceDistribution, int centerX, int centerY,
                                 DirectionCheckIndicator directionCheckIndicator) {
    int currentCount = 0;
    for (int i = 0; i < winningCount; i++) {
      int deltaY = 0;
      int deltaX = 0;
      if (directionCheckIndicator.isRight()) {
        deltaX = i;
      }
      if (directionCheckIndicator.isLeft()) {
        deltaX = -i;
      }
      if (directionCheckIndicator.isUp()) {
        deltaY = i;
      }
      if (directionCheckIndicator.isDown()) {
        deltaY = -i;
      }
      if (pieceDistribution[centerY + deltaY][centerX + deltaX].equals(CellStatus.PLAYER)) {
        currentCount++;
      } else {
        break;
      }
    }

    return currentCount == winningCount;
  }

}
