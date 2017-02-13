package logic;

import java.awt.Color;
import java.util.Random;

/**
 * Created by MC on 2/12/2017.
 */
public class RandomColorPicker {

  private static final int MAX_BOUND = 256;

  public static Color pickColor() {
    Random random = new Random();
    return new Color(random.nextInt(MAX_BOUND), random.nextInt(MAX_BOUND), random.nextInt(MAX_BOUND));

  }
}
