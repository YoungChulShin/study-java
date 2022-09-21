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
        .map(s -> {
          System.out.println(Thread.currentThread().getName());
          return String.format("%s price is %.2f", s.getName(), s.getPrice(product));
        })
        .toList();
    System.out.println(findProducts);

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }

  @Test
  void findPricesParallel() {
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadName);

    String product = "iphone14";
    List<Shop04External> shops = getShops();
    // parallelStream을 이용하면 포크조인풀을 이용해서 작업이 수행
    // 첫번째 작업은 메인스레드에서 실행되고, 나머지 작업은 포크조인풀
    List<String> findProducts = shops.parallelStream()
        .map(s -> {
          System.out.println(Thread.currentThread().getName());
          return String.format("%s price is %.2f", s.getName(), s.getPrice(product));
        })
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