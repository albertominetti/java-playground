package oca;

import java.time.LocalDate;

public class PoolForLocalDate {
  public static void main(String[] args) {
    LocalDate one = LocalDate.of(2017, 7, 17);
    LocalDate two = LocalDate.of(2017, 7, 17);

    System.out.println("Equal dates? " + (one.equals(two) ? "yes" : "no"));
    System.out.println("Any pool? " + (one == two ? "yes" : "no"));


  }
}
