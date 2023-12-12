import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JumpingNumbers {
  public static List<Long> extractDigits(Long n) {
    LinkedList<Long> ret = new LinkedList<>();
    while (n > 0) {
      Long digit = n % 10;
      ret.add(digit);
      n = (n - digit) / 10;
    }
    Collections.reverse(ret);
    return ret;
  }

  static long jumpingNumsFailedAttempt1(long x) {
    List<Long> digits = extractDigits(x);
    if (digits.size() < 2) {
      return x;
    }
    boolean decreased = false;
    for (int i = 0; i < digits.size() - 1; i++) {
      Long a = digits.get(i);
      Long b = digits.get(i + 1);
      if (decreased) {
        digits.set(i + 1, a < 9 ? a + 1 : 8);
        continue;
      }
      if (Math.abs(a - b) == 1) continue;
      if (b == a) {
        digits.set(i + 1, a - 1);
        decreased = true;
      } else if (b > a) {
        digits.set(i + 1, a + 1);
        decreased = true;
      } else {
        digits.set(i, a - 1);
        digits.set(i + 1, a);
        if (i >= 1 && digits.get(i - 1) == digits.get(i)) {
          digits.set(i, digits.get(i) - 1);
          digits.set(i + 1, digits.get(i) + 1);
        }
        decreased = true;
      }
    }
    Long result = 0L;

    for (Long digit : digits) {
      result = result * 10 + digit;
    }
    return result;
  }

  static long jumpingNums(long x) {
    long result = 0;
    long steps = 0;
    Queue<Long> queue = new LinkedList<>();
    for (long i = 1; i <= 9 && i <= x; i++)
      queue.add(i);
    while(!queue.isEmpty()) {
      long current = queue.poll();
      steps++;
      System.out.println(current);
      if (current <= x) {
        result = Math.max(result, current);
        long lastDigit = current % 10;
        // calculate left
        if (lastDigit != 0) {
          long left = current * 10 + lastDigit - 1;
          queue.add(left);
        }
        // calculate right
        if (lastDigit != 9) {
          long right = current * 10 + lastDigit + 1;
          queue.add(right);
        }
      }
    }
    System.out.println("Total steps: " + steps);
    return result;
  }

  public static void main(String args[]) {
    System.out.println(jumpingNums(10067));
  }
}