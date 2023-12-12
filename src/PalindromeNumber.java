import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
iven a number N.Find if the digit sum(or sum of digits) of N is a Palindrome number or not.
Note:A Palindrome number is a number which stays the same when reversed.Example- 121,131,7 etc.
 */
public class PalindromeNumber {
  public static List<Integer> extractDigits(int n) {
    LinkedList<Integer> ret = new LinkedList<>();
    while (n > 0) {
      int digit = n % 10;
      ret.add(digit);
      n = (n - digit) / 10;
    }
    Collections.reverse(ret);
    return ret;
  }
  static int isDigitSumPalindrome(int N) {
    int digitSum = extractDigits(N).stream().reduce(0, Integer::sum);
    List<Integer> digits = extractDigits(digitSum);
    int i = 0, j = digits.size() - 1;
    for (; i < j; i++, j--) {
      if (digits.get(i) != digits.get(j)) break;
    }
    return i < j ? 0 : 1;
  }
  public static void main(String args[]) {
    System.out.println(isDigitSumPalindrome(236));
  }
}
