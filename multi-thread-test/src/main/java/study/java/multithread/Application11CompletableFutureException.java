package study.java.multithread;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import study.java.multithread.sender.DataSender;

public class Application11CompletableFutureException {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadId + ", " + threadName);

    CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(DataSender::throwError);
    CompletableFuture<Void> exceptionally = completableFuture.exceptionally(throwable -> {
      System.out.println("에러 발생: " + throwable.getMessage());
      try {
        throw throwable;
      } catch (Throwable e) {
        throw new RuntimeException(e);
      }
    });

    CompletableFuture.allOf(completableFuture, exceptionally);
    exceptionally.get();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }
}
