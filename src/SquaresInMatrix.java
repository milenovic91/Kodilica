/*
Given a mxn matrix, count the number of squares in the matrix.

Example 1:

Input:
m = 2, n = 2
Output:
5
Explanation:
There are a total of 5 squares in a 2*2
matrix. Four 1*1 squares and one 2*2 square.
Example 2:

Input:
m = 4, n = 3
Output:
20
Explanation:
There are a total of 20 squares in a 4*3
matrix. 
 */
public class SquaresInMatrix {
  static long squaresInMatrix(int m, int n) {
    int sum = 0;
    for (int width = 1; width <= n; width++) {
      for (int i = width; i <= n; i++) {
        for (int j = width; j <= m; j++) {
          sum++;
        }
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(squaresInMatrix(4, 3));
  }
}
