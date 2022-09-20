package study.java.multithread.priceexample;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop02NonBlock {

  public Future<Double> getPriceAsync(String product) {
    CompletableFuture<Double> completableFuture = new CompletableFuture<>();
    new Thread(() -> {
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

    Random random = new Random();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }
}