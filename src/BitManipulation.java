/*
You are given two 32-bit numbers, N and M, and two bit positions, i and j Write a method to
set all bits between i and j in N equal to M (e g , M becomes a substring of N located at i and starting at j)
EXAMPLE:
Input: N = 10000000000, M = 10101, i = 2, j = 6
Output: N = 10001010100
 */
public class BitManipulation {
  public static int setBitsBetweenPositions(int N, int M, int i, int j) {
    // 11....000000.....1
    // ......j....i......
    // this mask is used to set to 0 all bits between i and j in N
    int helpMask = ~(((1 << (j - i + 1)) - 1) << i);
    return N & helpMask | (M << i);
  }
  public static void main(String args[]) {
    System.out.println(Integer.toBinaryString(setBitsBetweenPositions(0b10000000000, 0b10101, 2, 6)));
  }
}
