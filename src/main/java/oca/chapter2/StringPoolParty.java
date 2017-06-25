package oca.chapter2;

public class StringPoolParty {
  public static void main(String[] args) {
    String a = "";
    String b = "";
    String c = new String("");
    String d = new StringBuilder().append("").toString();

    if (a == b) {
      System.out.println("a and b have the same reference");
    }

    if (a != c) {
      System.out.println("a and c don't have the same reference");
    }

    if (c != d) {
      System.out.println("c and d don't have the same reference");
    }

    if (c.equals(d) && c.equals(a)) {
      System.out.println("c and d but are equals, with a too");
    }

    c = c.intern();
    d = d.intern();
    if (a == c && a == d) {
      System.out.println("a, c and d have now the same reference");
    }

  }
}
