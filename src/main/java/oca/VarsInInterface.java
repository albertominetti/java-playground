package oca;

import static oca.MyInterface.*;

interface MyInterface {
  int SPEED = 10;
}

interface AnotherInterface {
  int LIMIT = 100;
}

public class VarsInInterface implements AnotherInterface {
  public static void main(String[] args) {
    int a = 10;
    switch (a){
      case SPEED:
        System.out.println("I can use x here because it is final");
        System.out.println("Remember the static import!");
        break;
    }

    if (a<LIMIT) {
      System.out.println("I can avoid the static import because my class implements AnotherInterface");
    }
  }
}
