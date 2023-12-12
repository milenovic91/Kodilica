import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array A of N integers, find any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k.

Example 1:

Input:
N = 5
A[] = {1,2,1,1,3}
Output: 1
Explanation: a sub-sequence 1 2 3 exist.
 */
public class NOTE_Sorted_subsequence_of_size_3 {
  static ArrayList<Integer> find3NumbersAttempt1(ArrayList<Integer> arr, int n) {
    // Working, but was complaining about speed
    Integer[] a = arr.toArray(new Integer[arr.size()]);
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        for (int k = j + 1; k < a.length; k++) {
          if (a[i] < a[j] && a[j] < a[k]) {
            return new ArrayList(Arrays.asList(a[i], a[j], a[k]));
          }
        }
      }
    }
    return new ArrayList<>();
  }
  static ArrayList<Integer> find3NumbersAttempt2(ArrayList<Integer> arr, int n) {
    // Working, but was complaining about speed
    for (int j = 0; j < arr.size(); j++) {
      int i;
      int k;
      for (i = j - 1; i >= 0; i--) {
        if (arr.get(i) < arr.get(j)) break;
      }
      if (i == -1) continue;
      for (k = j + 1; k < arr.size(); k++) {
        if (arr.get(k) > arr.get(j)) break;
      }
      if (i >= 0 && i < j && j < k && k < arr.size()) {
        return new ArrayList<>(Arrays.asList(arr.get(i), arr.get(j), arr.get(k)));
      }
    }
    return new ArrayList<>();
  }
  static ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
    int[] smaller = new int[arr.size()];
    int[] greater = new int[arr.size()];

    int minIndex = 0;
    smaller[minIndex] = -1;
    for (int i = 1; i < arr.size(); i++) {
      if (arr.get(i) <= arr.get(minIndex)) {
        minIndex = i;
        smaller[i] = -1;
      } else {
        smaller[i] = minIndex;
      }
    }

    int maxIndex = arr.size() - 1;
    greater[maxIndex] = -1;
    for (int i = arr.size() - 2; i >= 0; i--) {
      if (arr.get(i) >= arr.get(maxIndex)) {
        maxIndex = i;
        greater[i] = -1;
      } else {
        greater[i] = maxIndex;
      }
    }

    for (int i = 0; i < arr.size(); i++) {
      if (greater[i] != -1 && smaller[i] != -1) {
        return new ArrayList<>(Arrays.asList(arr.get(smaller[i]), arr.get(i), arr.get(greater[i])));
      }
    }
    return new ArrayList<>();
  }
  public static void main(String args[]) {
    System.out.println(find3Numbers(new ArrayList(Arrays.asList(1, 1, 3)), 3));
  }
}
