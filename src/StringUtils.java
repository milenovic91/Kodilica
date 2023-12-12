import java.util.Arrays;

public class StringUtils {
  public static String removeDuplicates(String s) {
    if (s == null) return null;
    char[] chars = s.toCharArray();
    int current = 0;
    for (int i = 0; i < chars.length; i++) {
      int j;
      for (j = 0; j < i; j++) {
        if (chars[i] == chars[j]) break;
      }
      if (j == i) {
        chars[current++] = chars[i];
      }
    }
    return new String(Arrays.copyOf(chars, current));
  }

  public static String encodeSpaces(String s) {
    char[] chars = s.toCharArray();
    int spaces = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == ' ') {
        spaces++;
      }
    }
    int length = chars.length;
    int newLength = chars.length + spaces * 2;
    chars = Arrays.copyOf(chars, newLength);
    int pointer = newLength - 1;
    for (int i = length - 1; i >= 0; i--) {
      if (chars[i] == ' ') {
        chars[pointer--] = '0';
        chars[pointer--] = '2';
        chars[pointer--] = '%';
      } else {
        chars[pointer--] = chars[i];
      }
    }
    return new String(chars);
  }
  public static void main(String [] args) {


  }
}
