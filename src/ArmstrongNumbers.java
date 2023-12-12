/*
For a given 3 digit number, find whether it is armstrong number or not. An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. Return "Yes" if it is a armstrong number else return "No".
NOTE: 371 is an Armstrong number since 33 + 73 + 13 = 371

Input: N = 153
Output: "Yes"
Explanation: 153 is an Armstrong number
since 13 + 53 + 33 = 153.
Hence answer is "Yes".

Input: N = 370
Output: "Yes"
Explanation: 370 is an Armstrong number
since 33 + 73 + 03 = 370.
Hence answer is "Yes".
 */
public class ArmstrongNumbers {
  public static String isArmstrong(int n) {
    int sum = 0;
    int m = n;
    while (m > 0) {
      int digit = m % 10;
      sum += Math.pow(digit, 3);
      m = (m - digit) / 10;
    }
    return sum == n ? "Yes" : "No";
  }
  public static void main(String args[]) {
    System.out.println(isArmstrong(370));
  }
}
