import java.util.ArrayList;
import java.util.Collections;

public class LeaderNumbers {
  public static ArrayList<Integer> findLeaders(int arr[], int n) {
    int currentMax = -999999;
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] >= currentMax) {
        result.add(arr[i]);
        currentMax = arr[i];
      }
    }
    Collections.reverse(result);
    return result;
  }
  public static void main(String args[]) {
    System.out.println(findLeaders(null, 0));
  }
}
