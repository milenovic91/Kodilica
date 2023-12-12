public class RectangleOverlap {
  public static int doOverlapNotWorkingBad(int L1[], int R1[], int L2[], int R2[]) {
    return
        (L2[0] >= L1[0] && L2[0]  <= R1[0] && L2[1] <= L1[1] && L2[1] >= R1[1] ||
            R2[0] >= L1[0] && R2[0]  <= R1[0] && R2[1] <= L1[1] && R2[1] >= R1[1] ||
            L1[0] >= L2[0] && L1[0]  <= R2[0] && L1[1] <= L2[1] && L1[1] >= R2[1] ||
            R1[0] >= L2[0] && R1[0]  <= R2[0] && R1[1] <= L2[1] && R1[1] >= R2[1])
            ? 1 : 0;
  }
  public static int doOverlap(int L1[], int R1[], int L2[], int R2[]) {
    // TODO
    return 0;
  }
  public static void main(String args[]) {
    System.out.println(doOverlap(new int []{0, 10}, new int []{10, 0}, new int []{5, 5}, new int []{15, 0}));
  }
}
