package oca;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SearchInArrays {
  public static void main(String[] args) {


    int[] array = {10,20,30,40,50};
    Arrays.sort(array);

    int i = Arrays.binarySearch(array, 30); // found at 2
    System.out.println("found at position " + i);

    i = Arrays.binarySearch(array, 32);// should be in position 3, so negate it and minus 1: -4
    System.out.println("not found, result: " + i);


    int searchInString = "Stringa".indexOf('z');
    System.out.println("String.indexOf always returns -1 when no matches: " + searchInString);

  }
}
