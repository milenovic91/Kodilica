/*
Imagine a robot sitting on the upper left hand corner of an NxN grid The robot can only move in two directions: right and down How many possible paths are there for the robot?
FOLLOW UP
Imagine certain squares are “off limits”, such that the robot can not step on them Design an algorithm to get all possible paths for the robot
 */
public class MovingRobotHand {
  public static int countPaths(int n, int row, int col) {
    if (row == (n - 1) || col == (n - 1)) return 1;
    return countPaths(n, row + 1, col) + countPaths(n, row, col + 1);
  };


  public static void main(String args[]) {
    System.out.println(countPaths(3, 0, 0));
  }
}
