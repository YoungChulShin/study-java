package study.java.multithread.priceexample;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ShopExternalTest {

  @Test
  void findPricesBlock() {
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadName);

    String product = "iphone14";
    List<Shop04External> shops = getShops();
    List<String> findProducts = shops.stream()
        .map(s -> String.format("%s price is %.2f", s.getName(), s.getPrice(product)))
        .toList();
    System.out.println(findProducts);

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }


  private List<Shop04External> getShops() {
    return Arrays.asList(
        new Shop04External("nike"),
        new Shop04External("abc mart"),
        new Shop04External("emart"),
        new Shop04External("department"));
  }
}