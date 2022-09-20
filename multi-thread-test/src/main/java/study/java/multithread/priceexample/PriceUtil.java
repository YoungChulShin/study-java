package study.java.multithread.priceexample;

public final class PriceUtil {

  public static void delay() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
