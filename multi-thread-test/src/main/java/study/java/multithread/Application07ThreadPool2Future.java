package study.java.multithread;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import study.java.multithread.sender.DataSender;

public class Application07ThreadPool2Future {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadId + ", " + threadName);

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Future<?> future1 = executorService.submit(DataSender::sendData1);
    Future<?> future2 = executorService.submit(DataSender::sendData2);

    // future2는 먼저 종료되지만 future1이 종료될 때까지 기다린다
    future1.get();
    System.out.println("[" + LocalDateTime.now() + "] future#1 get - " + threadId + ", " + threadName);
    future2.get();
    System.out.println("[" + LocalDateTime.now() + "] future#2 get - " + threadId + ", " + threadName);

    executorService.shutdown();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }
}
