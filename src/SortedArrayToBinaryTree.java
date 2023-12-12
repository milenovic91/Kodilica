public class SortedArrayToBinaryTree {
  public static class Node {
    Node left;
    Node right;
    int value;
  }

  public static Node toBTree(int[] array, int start, int end) {
    if (start > end) return null;
    int middle = start + (end - start) / 2;
    Node n = new Node();
    n.value = array[middle];
    if (start != end) {
      n.left = toBTree(array, start, middle - 1);
      n.right = toBTree(array, middle + 1, end);
    }
    return n;
  }

  public static void main(String[] args) {
    Node n = toBTree(new int[] { 2, 4, 6, 7}, 0, 3);
    System.out.println(n);
  }
}
