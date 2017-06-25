import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class ChangesTest {

  private final Changes changes = new Changes();

  @Test
  public void verifyChanges() throws Exception {

    X x1 = new X() {{
      this.setStringa("auto");
    }};


    X x2 = new X() {{
      this.setStringa("macchina");
      this.setCar(new Car() {{
        this.setPnr("12345");
      }});
    }};

    Collection<String> list = changes.verifyChanges(x1, x2);

    System.out.println(list);

    assertThat(list, hasItem("X.stringA"));
    assertThat(list, hasItem("getCar"));
    assertThat(list, hasItem("car.pnr"));
  }

  @Test
  public void verifyChanges2() throws Exception {

    X x1 = new X() {{
      this.setStringa("auto");
    }};


    X x2 = new X() {{
      this.setStringa("macchina");
      this.setCar(null);
    }};

    Collection<String> list = changes.verifyChanges(x1, x2);

    System.out.println(list);

    assertThat(list, hasItem("X.stringA"));
    assertThat(list, hasItem("getCar"));
    assertThat(list, not(hasItem("car.pnr")));
  }


}

class X {
  private String stringa;
  private int numero;
  private double iu;
  private Car car = new Car();

  @Changes.Verify
  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  @Changes.Verify
  public double getIu() {
    return iu;
  }

  public void setIu(double iu) {
    this.iu = iu;
  }

  @Changes.Verify
  @Changes.VerifyInside
  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }


  @Changes.Verify(value = "X.stringA")
  public String getStringa() {
    return stringa;
  }

  public void setStringa(String stringa) {
    this.stringa = stringa;
  }
}

class Car {

  private String modelType = "modello";
  private String pnr = null;

  @Changes.Verify
  public String getModelType() {
    return modelType;
  }

  public void setModelType(String modelType) {
    this.modelType = modelType;
  }

  @Changes.Verify(value = "car.pnr")
  public String getPnr() {
    return pnr;
  }

  public void setPnr(String pnr) {
    this.pnr = pnr;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Car car = (Car) o;

    if (modelType != null ? !modelType.equals(car.modelType) : car.modelType != null) return false;
    return pnr != null ? pnr.equals(car.pnr) : car.pnr == null;
  }

  @Override
  public int hashCode() {
    int result = modelType != null ? modelType.hashCode() : 0;
    result = 31 * result + (pnr != null ? pnr.hashCode() : 0);
    return result;
  }
}
