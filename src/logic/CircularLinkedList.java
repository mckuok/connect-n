package logic;

import java.util.Collection;

/**
 * Created by MC on 2/12/2017.
 */
public class CircularLinkedList<E> {

  private Node currentNode;

  public CircularLinkedList(Collection<E> collection) {
    if (collection == null || collection.isEmpty()) {
      throw new IllegalArgumentException("The list is final thus cannot be modified later");
    }

    Node prev = null;
    Node head = null;
    boolean isFirst = true;

    for (E data: collection) {
      currentNode = new Node(data);
      if (isFirst) {
        head = currentNode;
        isFirst = false;
      } else {
        prev.next = currentNode;
      }
      prev = currentNode;
    }

    currentNode.next = head;
    currentNode = head;
  }

  public E next() {
    E data = currentNode.data;
    currentNode = currentNode.next;
    return data;
  }

  public E current() {
    return currentNode.data;
  }


  private class Node {

    private Node next;
    private E data;

    public Node(E data) {
      this.data = data;
    }

  }

}
