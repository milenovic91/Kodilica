public class Main {
  static int closestNumber(int N , int M) {
    int opt1 = (int) (Math.floor(N * 1. / Math.abs(M)) * Math.abs(M));
    int opt2 = (int) (Math.ceil(N * 1. / Math.abs(M)) * Math.abs(M));
    int dist1 = N - opt1;
    int dist2 = opt2 - N;
    if (dist1 < dist2) {
      return opt1;
    } else if (dist1 > dist2) {
      return opt2;
    } else {
      return Math.abs(opt2) > Math.abs(opt1) ? opt2 : opt1;
    }
  }



  public static void main(String[] args) {

  }
}