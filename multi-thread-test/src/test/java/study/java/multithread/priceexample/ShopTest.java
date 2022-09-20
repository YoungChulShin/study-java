package study.java.multithread.priceexample;

import java.time.LocalDateTime;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Test;

class ShopTest {

  @Test
  void getPriceWithBlock() {
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadName);

    Shop01Block sut = new Shop01Block();
    sut.getPrice("test");
    System.out.println("[" + LocalDateTime.now() + "] 다른 상품 검색, " + (System.currentTimeMillis() - startTime) + " - "+ threadName);
    sut.findAnotherOne();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }

  @Test
  void getPriceWithNonBlock() {
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadName);

    Shop02NonBlock sut = new Shop02NonBlock();
    Future<Double> futurePrice = sut.getPriceAsync("test");
    System.out.println("[" + LocalDateTime.now() + "] 다른 상품 검색, " + (System.currentTimeMillis() - startTime) + " - "+ threadName);
    sut.findAnotherOne();

    try {
      double price = futurePrice.get();
      System.out.println("[" + LocalDateTime.now() + "] Price: " + price + " , " + (System.currentTimeMillis() - startTime) + " - "+ threadName);
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }


    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }

}