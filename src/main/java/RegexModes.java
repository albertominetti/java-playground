public class RegexModes {
  public static void main(String[] args) {
    String txt = "Let's fly way up to the clouds";
    String[] regex = {"L.*", "l.*", "(?i)l.*"};
    for (String r : regex) {
      System.out.println(r + (txt.matches(r) ? " matches " : " doesn't match ") + txt);
    }
  }
}
