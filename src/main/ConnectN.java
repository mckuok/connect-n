package main;


import gui.GameBoard;
import logic.GameManager;
import logic.RandomColorPicker;
import logic.player.controller.AIController;
import logic.player.controller.GameBoardMouseListener;
import logic.player.Player;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MC on 2/10/2017.
 */
public class ConnectN {

  private static int WINNING_COUNT = 4;
  private static int NUM_PLAYER = 2;
  private static int BOX_WIDTH = 10;
  private static int BOX_HEIGHT = 10;

  public static void main(String[] args) {
    JFrame frame = new JFrame("Connect-N");
    frame.setSize(1000, 800);
    GameBoard gameBoard = new GameBoard(BOX_WIDTH, BOX_HEIGHT);
    frame.add(gameBoard);
    
    List<Player> players = new ArrayList<>(NUM_PLAYER);
    for (int i = 0; i < NUM_PLAYER; i++) {
      Color color = RandomColorPicker.pickColor();
      players.add(new Player(color, new GameBoardMouseListener(color, gameBoard)));
    }

    GameManager manager = new GameManager(players, gameBoard, WINNING_COUNT);
    manager.startNextPlayer();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

}
