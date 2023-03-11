package study.java.multithread;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import study.java.multithread.sender.DataSender;

public class Application08ThreadPool2InvokeAny {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadId + ", " + threadName);

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    // invokeAny는 하나가 종료되면 나머지 future를 cancel한다
    Object result = executorService.invokeAny(
        Arrays.asList(DataSender::sendData1WithReturn, DataSender::sendData2WithReturn));
    System.out.println(result);

    executorService.shutdown();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }
}
