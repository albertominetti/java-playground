package oca;

public class IntegerTools {
  static IntegerTools o = new IntegerTools();
  public static void main(String[] args) {
    o.method(Integer.valueOf(1));
    o.method(Integer.valueOf("1"));
    o.method(Integer.parseInt("1"));
  }


  void method(int i){
    System.out.println("method(int)");
  }
  void method(Integer i){
    System.out.println("method(Integer)");
  }
}
