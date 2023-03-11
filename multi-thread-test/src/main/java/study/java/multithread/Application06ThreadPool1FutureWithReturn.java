package study.java.multithread;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import study.java.multithread.sender.DataSender;

public class Application06ThreadPool1FutureWithReturn {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadId + ", " + threadName);

    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Future<String> future1 = executorService.submit(DataSender::sendData1WithReturn);
    Future<String> future2 = executorService.submit(DataSender::sendData2WithReturn);

    // case1: future1이 종료 -> future1 결과표시 -> future2 시작 및 종료 -> future2 결과표시
//    System.out.println("[" + LocalDateTime.now() + "] future#1 결과: " + future1.get() + " - " + threadId + ", " + threadName);
//    System.out.println("[" + LocalDateTime.now() + "] future#2 결과: " + future2.get() + " - " + threadId + ", " + threadName);

    // case2: future1이 종료 -> future2 시작 및 종료 -> future2 결과표시 ->  -> future1 결과표시
    System.out.println("[" + LocalDateTime.now() + "] future#2 결과: " + future2.get() + " - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] future#1 결과: " + future1.get() + " - " + threadId + ", " + threadName);


    executorService.shutdown();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }
}
