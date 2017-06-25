import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class NumericTest {

  @Test
  public void testDoubleUnprecise() {
    final double ZERO_ONE = 0.1;
    double accumulator = 0;
    for (int i = 0; i < 100; i++) {
      accumulator = accumulator + ZERO_ONE;
    }
    assertThat(accumulator, is(not(10.00)));
  }


  @Test
  public void testBigDecimalPrecise() {
    final BigDecimal ZERO_ONE = new BigDecimal("0.1");
    BigDecimal accumulator = BigDecimal.ZERO;
    for (int i = 0; i < 100; i++) {
      accumulator = accumulator.add(ZERO_ONE);
    }
    assertThat(accumulator, comparesEqualTo(BigDecimal.TEN));
  }

  @Test
  public void compareTo() throws Exception {
    BigDecimal TWENTY = new BigDecimal("20");
    BigDecimal TWENTYFIVE = new BigDecimal("25.00");
    assertThat(TWENTY.compareTo(TWENTYFIVE), is(-1));
    assertThat(TWENTYFIVE.compareTo(TWENTY), is(1));

  }
}
