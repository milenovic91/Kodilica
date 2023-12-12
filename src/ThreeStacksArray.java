/*
Approach:
Stack has nodes Node { value, previous }. Instead of using class Node,
buffer holds values [value, previous] - So every even index is value, even odd index is pointer to the previous element
Initially, the whole buffer is initialized as stack of free locations, so for stackSize 10 its:
[0 -1  2 0  4 2  6 4  8 6]
So useful size is 5.
With this setup, available locations are 8 -> 6 -> 4 -> 2 -> 0 -> -1,
I could also initialize this differently so new elements come first at the beginning of the buffer;
 */

public class ThreeStacksArray {
  int stackSize = 300;
  int[] tails = {-1, -1, -1};
  int[] buffer = new int[stackSize];
  int freeStackTail = stackSize - 2;
  {
    for(int i = 0; i <= stackSize - 2;) {
      buffer[i] = i;
      buffer[i + 1] = i - 2;
      i += 2;
    }
    buffer[1] = -1;
  }

  public void push(int stackNumber, int value) {
    // POP from freeStack to find available cell
    if (freeStackTail == -1)
      throw new RuntimeException("Stack is full");
    int availableIndex = buffer[freeStackTail];
    freeStackTail = buffer[freeStackTail + 1];
    if (availableIndex == -1)
      throw new RuntimeException("Stack is full2");

    buffer[availableIndex] = value;
    buffer[availableIndex + 1] = tails[stackNumber];
    tails[stackNumber] = availableIndex;
  }

  public int pop(int stackNumber) {
    if (tails[stackNumber] == -1)
      throw new RuntimeException("Specified stack is empty");
    int currentTail = tails[stackNumber];
    int retValue = buffer[currentTail];
    tails[stackNumber] = buffer[currentTail + 1];
    buffer[currentTail] = currentTail;
    buffer[currentTail + 1] = freeStackTail;
    freeStackTail = currentTail;

    return retValue;
  }

  public static void main(String[] args) {
    ThreeStacksArray stack = new ThreeStacksArray();
    stack.push(0, 1);
    stack.push(0, 2);
    stack.push(0, 3);
    stack.push(1, 10);
    stack.push(1, 11);
    stack.push(1, 12);
    System.out.println(stack.pop(0));
    stack.push(2, 100);
    System.out.println(stack.pop(1));
    System.out.println(stack.pop(2));
  }
}
