package study.java.multithread;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import study.java.multithread.sender.DataSender;

public class Application06ThreadPool1Future {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadId + ", " + threadName);

    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Future<?> future1 = executorService.submit(DataSender::sendData1);
    Future<?> future2 = executorService.submit(DataSender::sendData2);

    future1.get();
    future2.get();
    executorService.shutdown();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }
}
