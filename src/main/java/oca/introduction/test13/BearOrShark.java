package oca.introduction.test13;

public class BearOrShark {
  public static void main(String[] args) {
    int luck = 10;
    if ((luck > 10 ? luck++ : --luck) < 10) {
      System.out.println("Bear");
    }

    if (luck < 10) {
      System.out.println("Shark");
    }

    System.out.println("luck is " + luck);
  }
}
