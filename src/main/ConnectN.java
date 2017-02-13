package main;


import gui.GameBoard;
import logic.GameManager;
import logic.player.controller.GameBoardMouseListener;
import logic.player.Player;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MC on 2/10/2017.
 */
public class ConnectN {

  public static void main(String[] args) {
    JFrame frame = new JFrame("Connect-N");
    frame.setSize(1000, 800);
    GameBoard gameBoard = new GameBoard(10, 10);
    frame.add(gameBoard);


    List<Player> players = Arrays.asList(
        //new Player(Color.BLACK, new AIController(Color.BLACK, gameBoard)),
        new Player(Color.YELLOW, new GameBoardMouseListener(Color.YELLOW, gameBoard)),
        new Player(Color.RED, new GameBoardMouseListener(Color.RED, gameBoard))
    //    new Player(Color.BLUE, new AIController(Color.BLUE, gameBoard))
    );

    GameManager manager = new GameManager(players, gameBoard, 4);
    manager.startNextPlayer();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

}
