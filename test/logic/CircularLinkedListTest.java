package logic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by MC on 2/12/2017.
 */
public class CircularLinkedListTest {

  @Test
  public void nextTest() {
    CircularLinkedList<String> circularLinkedList = new CircularLinkedList<>(Arrays.asList("a", "b", "c"));
    assertEquals("a", circularLinkedList.next());
    assertEquals("b", circularLinkedList.next());
    assertEquals("c", circularLinkedList.next());
    assertEquals("a", circularLinkedList.next());
    assertEquals("b", circularLinkedList.next());
    assertEquals("c", circularLinkedList.next());
  }

}