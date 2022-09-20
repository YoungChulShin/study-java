package study.java.multithread.priceexample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop03NonBlockWithException {

  public Future<Double> getPriceAsync(String product) {
    CompletableFuture<Double> completableFuture = new CompletableFuture<>();
    new Thread(() -> {
//      double price = calculatePrice(product);
//      completableFuture.complete(price);
      try {
        double price = calculatePrice(product);
        completableFuture.complete(price);
      } catch (Exception ex) {
        completableFuture.completeExceptionally(ex);
      }
    }).start();

    return completableFuture;
  }

  public void findAnotherOne() {
    PriceUtil.delay();
  }

  private double calculatePrice(String product) {
    PriceUtil.delay();
    throw new RuntimeException("Price is not avaiable");
  }
}