public class StringAgainAgain {
  public static void main(String[] args) {
    String words = "xxxxxxxxxXXXXalfm lakmf";
    char from = ' ';
    String to = "*";
    System.out.println(replace(words, from, to));
  }

  public static String replace(String s, char from, String to){
    if (s.length() < 1) {
      return s + to;
    } else {
      String letter;
      if (s.charAt(0) != from) {
        letter = s.charAt(0) + to;
      } else{
        letter = "";
      }
      return letter + replace(s.substring(1), from, to);
    }
  }
}