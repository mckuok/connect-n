package logic.checker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by MC on 2/14/2017.
 */
public class DirectionCheckIndicatorTest {

  @Test
  public void directionTest() {
    DirectionCheckIndicator indicator = DirectionCheckIndicator.downRight();
    assertTrue(indicator.isRight());
    assertTrue(indicator.isDown());
    assertFalse(indicator.isUp());
    assertFalse(indicator.isLeft());
  }



}