package oca;

public class MyStuff {
  String name;
  MyStuff(String n) {
    name = n;
  }
  public static void main(String[] args) {
    MyStuff m1 = new MyStuff("guitar");
    MyStuff m2 = new MyStuff("tv");
    System.out.println(m2.equals(m1));
  }
  public boolean equals(Object o) {
    // works but is is not the right contract!
    MyStuff m = (MyStuff) o;
    if (m.name != null) {
      return true;
    }
    return false;
  }
}
