package logic;

import gui.GameBoard;
import logic.player.Player;
import logic.player.PlayerMovedListener;

import java.awt.Point;
import java.util.List;

/**
 * Created by MC on 2/12/2017.
 */
public class GameManager {

  private final CircularLinkedList<Player> players;
  private final GameBoard gameBoard;
  private final VictoryChecker victoryChecker;

  private Player currentPlayer;

  public GameManager(List<Player> players, GameBoard gameBoard, int winnningCount) {
    this.gameBoard = gameBoard;
    this.players = new CircularLinkedList<>(players);
    PlayerMovedListener rotator = new PlayerControlRotator();
    PlayerMovedListener highlighter = gameBoard.getMovedListener();
    for (Player player: players) {
      player.addMovedListener(highlighter);
      player.addMovedListener(rotator); // should be the last listener
    }

    victoryChecker = new VictoryChecker(winnningCount);
  }

  public void startNextPlayer() {
    currentPlayer = players.next();
    currentPlayer.takeControl();
  }

  private class PlayerControlRotator implements PlayerMovedListener {

    @Override
    public void moved(Point point) {
      currentPlayer.releaseControl();
      if (victoryChecker.playerWon(gameBoard.getPiecesDistribution(currentPlayer.getColor()))) {
        System.out.println(players.current().getColor() + " won!");
        gameBoard.displayVictoryMessage();
      } else {
        startNextPlayer();
      }
    }
  }



}
