package oca.chapter1;

public class NotStandardAlphabetCharacter {

  public String ciao = "Italiano";
  public String привет = "Russo";

  public String ciaо = "ItaloRusso";

  public static void main(String[] args) {

    NotStandardAlphabetCharacter n = new NotStandardAlphabetCharacter();

    if (!"Italiano".equals(n.ciaо)) {
      System.out.println("Fregato!");
    }
  }

}
