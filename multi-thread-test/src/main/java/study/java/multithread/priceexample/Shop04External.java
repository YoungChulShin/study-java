package study.java.multithread.priceexample;

import java.util.Random;

public class Shop04External {

  private String name;

  public Shop04External(String name) {
    this.name = name;
  }

  public double getPrice(String product) {
    return calculatePrice(product);
  }

  public String getName() {
    return name;
  }

  private double calculatePrice(String product) {
    PriceUtil.delay();

    Random random = new Random();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }
}