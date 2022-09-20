package study.java.multithread.priceexample;

import java.util.Random;

public class Shop01Block {

  public double getPrice(String product) {
    return calculatePrice(product);
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