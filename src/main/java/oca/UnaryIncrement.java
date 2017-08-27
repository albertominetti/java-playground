package oca;

public class UnaryIncrement {
  public static void main(String[] args) {
    int x = 4;

    int y = x++ - x--; // the first occurence of x is 4, the second is 5

    System.out.println("x value: " + x);
    System.out.println("y value: " + y);

    int k = 10;
    int j = k-- - k; //  the first occurence of k is 10, the second is 9
    System.out.println("k value: " + k);
    System.out.println("j value: " + j);
  }
}
