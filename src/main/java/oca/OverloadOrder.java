package oca;

import static java.lang.System.out;

public class OverloadOrder {
  void exactVsLarger(int i) {
    out.print("exact primitive match wins");
  }

  void exactVsLarger(long i) {
    out.println(" over larger primitive type");
  }

  void largerVsAutoboxed(long i) {
    out.print("larger primitive match wins");
  }

  void largerVsAutoboxed(Integer i) {
    out.println(" over autoboxed");
  }


  void autoboxedVsVarargs(Integer i) {
    out.print("autoboxed wins");
  }

  void autoboxedVsVarargs(int ... i) {
    out.println(" over varargs");
  }

  static OverloadOrder o = new OverloadOrder();

  public static void main(String[] args) {
    int primitiveInt = 1;

    System.out.println("How java chooses the right overloaded method between primitives, autoboxing and varargs:");

    System.out.print("1. ");
    o.exactVsLarger(primitiveInt);
    o.exactVsLarger((long) primitiveInt);

    System.out.print("2. ");
    o.largerVsAutoboxed(primitiveInt);
    o.largerVsAutoboxed((Integer) primitiveInt);

    System.out.print("3. ");
    o.autoboxedVsVarargs(primitiveInt);
    o.autoboxedVsVarargs(new int[]{primitiveInt});

  }
}
