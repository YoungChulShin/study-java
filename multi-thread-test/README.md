# 동기/비동기를 사용 실습

### 상황
Data1, Data2 2개의 데이터를 전송합니다. 각 데이터의 전송 시간은 아래와 같습니다
- Data1: 5초
- Data2: 3초

### Case 1: 동기 전송
2개의 메서드를 메인스레드에서 각각 호출합니다. 

총 시간: 8초

### Case 2: Thread를 이용한 전송
DataSenderThread를 생성하고, 이 Thread를 이용해서 전송합니다.

각각의 데이터 전송은 Main Thread가 아닌, 별도로 생성된 Thread에서 동작합니다. 

총 시간: 5초

### Case 3: Runnable을 이용한 데이터 전송
Thread 생성 시, Runnable 인터페이스를 이용해서 값을 전달합니다. 

총 시간: 5초

### Case 4: Threadpool 1개를 이용한 데이터 전송
Executors를 이용해서 ThreadPool 1개를 생성하고 테스트합니다. 

총 시간: 8초

### Case 5: Threadpool 2개를 이용한 데이터 전송
Executors를 이용해서 ThreadPool 2개를 생성하고 테스트합니다.

총 시간: 5초

### Case 6: Threadpool 1개를 이용한 데이터 전송 + Future 응답
Executors를 이용해서 ThreadPool 1개를 생성하고, Future로 응답을 받습니다. 

Future로 응답을 받으면, Future.get()을 통해서 비동기 응답을 기다릴 수 있습니다. 

총 시간: 8초

### Case 7: Threadpool 2개를 이용한 데이터 전송 + Future 응답
Executors를 이용해서 ThreadPool 2개를 생성하고, Future로 응답을 받습니다.

총 시간: 5초

### Case 8: Threadpool 2개를 이용한 데이터 전송 + InvokeAll
Executors를 이용해서 ThreadPool 2개를 생성하고, InvokeAll로 호출합니다. 

InvokeAll로 호출되면, 비동기작업이 모두 완료되어야 다음 작업이 수행됩니다. 

총 시간: 8초

### Case 9: CompletableFuture를 이용해서 처리
CompletableFuture를 이용해서 2개의 작업을 처리합니다. allOff를 이용하면 실행중인 모든 항목이 완료될 때까지 응답을 기다립니다.

Thread는 ForkJoinPool을 이용해서 실행됩니다.

총 시간: 5초

### Case 10: CompletableFuture + 콜백 응답
CompletableFuture를 이용해서 2개의 작업을 처리하고, 콜백을 추가합니다. 

Future를 사용할 때에는 콜백을 사용하려면 Future.get() 이후에 무언가를 할 수 있었는 데, CompletableFuture를 이용하면 콜백을 미리 설정해줄 수 있다.

콜백 명령어
- thenRun: Runnable을 동기적으로 콜백. 1개 CompletableFuture에 n개 Runnable이 걸려있으면, 순차적으로 실행된다.
- thenRunAsync: Runnable을 비동기적으로 실행. 기존은 ForkJoinPool을 사용하고, ExecutorService를 전달해줄 수 돟 있다. 
- CompletableFuture.allOf: 모든 작업이 완료될 때까지 기다린다
- CompletableFuture.anyOf: 한개라도 먼저 종료되면 끝난다

### Case 11: CompletableFuture + exceptionally
exceptionally를 함께 사용하면 예외가 발생했을 때 처리를 할 수 있다. 

CompletableFuture.allOf로 처리하면, 예외가 발생하지 않는다. get()을 통해서 데이터를 가져와야지 그때 예외가 발생한다. 
