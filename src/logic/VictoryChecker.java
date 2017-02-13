package logic;

/**
 * Created by MC on 2/12/2017.
 */
public class VictoryChecker {

  private final int winningCount;

  public VictoryChecker(int winningCount) {
    this.winningCount = winningCount;
  }

  public static int PLAYER = 1;
  public static int NON_PLAYER = 0;

  public boolean playerWon(int[][] pieceDistribution) {

    for (int i = 0; i < pieceDistribution[0].length; i++) {
      for (int j = 0; j < pieceDistribution.length; j++) {
        if (checkUp(pieceDistribution, i, j) ||
            checkLeft(pieceDistribution, i, j) ||
            checkRight(pieceDistribution, i, j) ||
            checkUpLeft(pieceDistribution, i, j) ||
            checkUpRight(pieceDistribution, i, j)) {
          return true;
        }
      }
    }

    return false;

  }

  private boolean checkUp(int[][] pieceDistribution, int centerX, int centerY) {
    if (checkUpBoundary(pieceDistribution.length, centerY)) {
      int currentCount = 0;
      for (int i = 0; i < winningCount; i++) {
        if (pieceDistribution[centerY + i][centerX] == PLAYER) {
          currentCount++;
        } else {
          break;
        }
      }

      return currentCount == winningCount;
    }
    return false;
  }

  private boolean checkRight(int[][] pieceDistribution, int centerX, int centerY) {
    if (checkRightBoundary(pieceDistribution[0].length, centerX)) {
      int currentCount = 0;
      for (int i = 0; i < winningCount; i++) {
        if (pieceDistribution[centerY][centerX + i] == PLAYER) {
          currentCount++;
        } else {
          break;
        }
      }

      return currentCount == winningCount;
    }
    return false;
  }


  private boolean checkLeft(int[][] pieceDistribution, int centerX, int centerY) {
    if (checkLeftBoundary(centerX)) {
      int currentCount = 0;
      for (int i = 0; i < winningCount; i++) {
        if (pieceDistribution[centerY][centerX - i] == PLAYER) {
          currentCount++;
        } else {
          break;
        }
      }

      return currentCount == winningCount;
    }
    return false;
  }

  private boolean checkUpRight(int [][] pieceDistribution, int centerX, int centerY) {
    if (checkUpBoundary(pieceDistribution.length, centerY) && checkRightBoundary(pieceDistribution[0].length, centerX)) {
      int currentCount = 0;
      for (int i = 0; i < winningCount; i++) {
        if (pieceDistribution[centerY + i][centerX + i] == PLAYER) {
          currentCount++;
        }
      }

      return currentCount == winningCount;
    }
    return false;
  }

  private boolean checkUpLeft(int[][] pieceDistribution, int centerX, int centerY) {
    if (checkUpBoundary(pieceDistribution.length, centerY) && checkLeftBoundary(centerX)) {
      int currentCount = 0;
      for (int i = 0; i < winningCount; i++) {
        if (pieceDistribution[centerY + i][centerX - i] == PLAYER) {
          currentCount++;
        }
      }

      return currentCount == winningCount;
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
    return originX - winningCount >= 0;
  }

}
