package oca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FixedSizeList {
  public static void main(String[] args) throws InterruptedException {
    List<Integer> list = Arrays.asList(5,1,2,3,4);
    System.out.println("Not ordered list: " + list);

    Collections.sort(list);
    System.out.println("Ordered list: " + list);

    try {
      System.out.println("try to add an item");
      list.add(9);
    } catch (RuntimeException ee) {
      System.out.println("cannot! " + ee);
    }

    ArrayList<Integer> arrayList = new ArrayList<>(list);
    arrayList.add(200);
    System.out.println("But standard ArrayList allows to add items: " + arrayList);




  }
}
