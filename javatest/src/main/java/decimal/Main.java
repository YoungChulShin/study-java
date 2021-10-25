package decimal;

import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {
    DecimalTest decimalTest = new DecimalTest();
    BigDecimal result = decimalTest.halfUp(new BigDecimal("1.49"));
    System.out.println(result);

  }

}
