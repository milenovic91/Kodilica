public class RotateMatrix {
  public static int [][] rotateMatrix(int [][] matrix, int n) {
    int[]r = new int[2];
    int[][] response = new int[n][n];
    for (int row = 0; row < n; row++) {
      for(int col = 0; col < n; col++) {
        response[col][n - 1 - row] = matrix[row][col];
      }
    }
    return response;
  }
  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    Object response = rotateMatrix(matrix, 3);
    System.out.println("Done");
  }
}
