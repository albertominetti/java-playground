package oca;

import java.util.Arrays;
import java.util.List;

public class NpeDuringUnboxing {
  static NpeDuringUnboxing o = new NpeDuringUnboxing();

  public static void main(String[] args) {
    System.err.println("wainting for NPE");
    List<Integer> ints = Arrays.asList(1, 2, 3, null);
    for (int i : ints) {

    }

  }

}
