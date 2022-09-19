package study.java.multithread;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import study.java.multithread.sender.DataSender;

public class Application12CompletableFutureSupply {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadId + ", " + threadName);

    CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> "hi")
        .thenApply(m -> m + ", hello")
        .thenAccept(m -> System.out.println(m));
    voidCompletableFuture.get();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }
}
