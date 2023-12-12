public class LinkedListUtils {
  public static class Node<T> {
    Node next;
    T value;
  }
  public static <T> Node<T> findBeginingOfTheCircle(Node<T> head) {
    Node first = head;
    Node second = head.next;
    while (first != null && second != null) {
      if (first.value == second.value) break;
      first = first.next;
      second = second.next;
      if (second != null) {
        second = second.next;
      }
    }
    if (first == second && first != null) {
      while (head != null) {
        second = first;
        do {
          if (second == head) return head;
          second = second.next;
        } while (second != first);
        head = head.next;
      }
    }
    return null;
  }

  public static <T> Node<T> generateList(T[] values) {
    Node head = null;
    Node tail = null;
    for (T value : values) {
      Node newNode = new Node();
      newNode.value = value;
      if (head == null) head = newNode;
      if (tail != null) tail.next = newNode;
      tail = newNode;
    }
    return head;
  }

  public static <T> Node<T> find(Node<T> list, T value) {
    while (list != null && !list.value.equals(value))
      list = list.next;
    if (list != null) return list;
    else return null;
  }

  public static void main(String[] args) {
    Character[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
    Node<Character> list = generateList(charArray);
    Node<Character> dNode = find(list, 'd');
    Node<Character> kNode = find(list, 'k');
    kNode.next = dNode;
    System.out.println(findBeginingOfTheCircle(list).value);

  }
}
