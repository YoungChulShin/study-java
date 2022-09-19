package study.java.multithread;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import study.java.multithread.sender.DataSender;

public class Application10CompletableFutureCallback {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadId + ", " + threadName);

    CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> DataSender.sendData(1, 5000L));
    CompletableFuture<Void> completableFuture3 = completableFuture.thenRun(() -> {
      System.out.println(
          "[" + LocalDateTime.now() + "] 1번 콜백 실행 - " + threadId + ", " + threadName);
      DataSender.sendData(3, 2000L);
    });

    CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(() -> DataSender.sendData(2, 3000L));
    CompletableFuture<Void> completableFuture4 = completableFuture2.thenRunAsync(
        () -> {
      System.out.println(
          "[" + LocalDateTime.now() + "] 2번 콜백 실행 1 - " + threadId + ", " + threadName);
      DataSender.sendData(4, 10000L);
    }, executorService);
    CompletableFuture<Void> completableFuture5 = completableFuture2.thenRunAsync(() -> {
      System.out.println(
          "[" + LocalDateTime.now() + "] 2번 콜백 실행 2 - " + threadId + ", " + threadName);
      DataSender.sendData(5, 5000L);
    }, executorService);
    CompletableFuture<Void> completableFuture6 = completableFuture2.thenRunAsync(() -> {
      System.out.println(
          "[" + LocalDateTime.now() + "] 2번 콜백 실행 3 - " + threadId + ", " + threadName);
      DataSender.sendData(6, 5000L);
    }, executorService);

    CompletableFuture
        .anyOf(
          completableFuture,
          completableFuture2,
          completableFuture3,
          completableFuture4,
          completableFuture5,
          completableFuture6)
        .get();

    executorService.shutdown();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }
}
