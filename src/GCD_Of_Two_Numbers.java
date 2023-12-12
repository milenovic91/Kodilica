public class GCD_Of_Two_Numbers {
  /**
   * Sve gluposti koje sam pisao
   */
//  public static boolean isFactor(int n, int x) {
//    System.out.println("CALLED: " + n + ", " + x);
//    if (n == x) return true;
//    if (n > x) return false;
//    for (int i = 2; i <= 9; i++) {
//      if (isFactor(i * n, x)) return true;
//    }
//    return false;
//  }
//
//  public static boolean visit(int n, int x) {
//    System.out.println("CALLED: " + n + ", " + x);
//    if (n == x) return true;
//    if (n > x) return false;
//    for (int i = 2; i <= 9; i++) {
//      if (visit(n * i, x)) {
//        System.out.println(n);
//        return true;
//      }
//    }
//    return false;
//  }
  public static int gcd(int A , int B) {
    System.out.println("CALLED: " + A + ", " + B);
    //Check if B is 0, if true, return A as greatest common divisor.
    if (B == 0)
      return A;
    //Recursively call the gcd function with B as the new A and A % B as the new B.
    return gcd(B, A % B);
  }

  public static void main(String args[]) {
    System.out.println(gcd(24, 32));
  }
}
