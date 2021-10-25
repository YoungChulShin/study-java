package decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalTest {

  public BigDecimal halfUp(BigDecimal input) {

    return input.setScale(0, RoundingMode.HALF_UP);
  }
}
