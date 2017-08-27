package oca;

public class ExceptionsCatch {

  public static void main(String[] args) {
    try {
      split();
    } catch (HurtException ee){
      System.out.println("hurt");
    } catch (LimpException ee){
      System.out.println("unreachable!");
    } catch (Exception ee){
      System.out.println("exc");
    }

  }

  private static void split() throws HurtException {
  }

  private static class LimpException extends Exception {
  }
  private static class HurtException extends LimpException {
  }
}
