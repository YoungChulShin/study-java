package study.java.multithread;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import study.java.multithread.sender.DataSender;

public class Application09CompletableFuture {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadId + ", " + threadName);

    CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(DataSender::sendData1);
    CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(DataSender::sendData2);

    CompletableFuture.allOf(completableFuture, completableFuture2).get();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }
}
