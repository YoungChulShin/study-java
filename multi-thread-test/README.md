# 동기/비동기를 사용 실습
## 자바에서 지원하는 비동기 실습

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

Future로 응답을 받으면, 비동기 작업의 상태를 관리할 수 있습니다. 작업을 취소하거나, 처리 상태 확인 그리고 Future.get()을 통해서 비동기 응답을 기다릴 수 있습니다. 

총 시간: 8초

### Case 7: Threadpool 2개를 이용한 데이터 전송 + Future 응답
Executors를 이용해서 ThreadPool 2개를 생성하고, Future로 응답을 받습니다.

총 시간: 5초

### Case 8: Threadpool 2개를 이용한 데이터 전송 + InvokeAll
Executors를 이용해서 ThreadPool 2개를 생성하고, InvokeAll로 호출합니다. 

InvokeAll로 호출되면, 비동기작업이 모두 완료되어야 다음 작업이 수행됩니다. 

총 시간: 8초

### Case 8-1: Threadpool 2개를 이용한 데이터 전송 + InvokeAny
Executors를 이용해서 ThreadPool 2개를 생성하고, InvokeAny로 호출합니다.

InvokeAny로 호출되면, 하나의 작업이 완료되면 나머지 작업은 모두 취소합니다. 

총 시간: 3초

### Case 9: CompletableFuture를 이용해서 처리
CompletableFuture를 이용해서 2개의 작업을 처리합니다. allOff를 이용하면 실행중인 모든 항목이 완료될 때까지 응답을 기다립니다.

Thread는 ForkJoinPool을 이용해서 실행됩니다.

총 시간: 5초

### Case 10: CompletableFuture + 콜백 응답
CompletableFuture를 이용해서 2개의 작업을 처리하고, 콜백을 추가합니다. 

Future를 사용할 때에는 콜백을 사용하려면 Future.get() 이후에 무언가를 할 수 있었는 데, CompletableFuture를 이용하면 콜백을 미리 설정해줄 수 있다.

콜백 명령어
- thenRun: Runnable을 동기적으로 콜백. 1개 CompletableFuture에 n개 Runnable이 걸려있으면, 순차적으로 실행된다.
- thenRunAsync: Runnable을 비동기적으로 실행. 기본은 ForkJoinPool을 사용하고, ExecutorService를 전달해줄 수 있다. 
- CompletableFuture.allOf: 모든 작업이 완료될 때까지 기다린다
- CompletableFuture.anyOf: 한개라도 먼저 종료되면 끝난다

### Case 11: CompletableFuture + exceptionally
exceptionally를 함께 사용하면 예외가 발생했을 때 처리를 할 수 있다. 

CompletableFuture.allOf로 처리하면, 예외가 발생하지 않는다. get()을 통해서 데이터를 가져와야지 그때 예외가 발생한다.

### Case 12: CompletableFuture + supplyAsync

추가 연산
- thenApply: a를 받아서 b를 리턴하는 기능. 값을 변환할 때 사용할 수 있을 것 같다
- thenAccept: 응답값이 없는 consumer
- thenCompose: 2개의 completableFuture를 이어준다. 
- thenCombine: 상관 없는 2개의 completableFuture를 조합한다

## 상품 계산 예시
비동기 코드 내에서 예외가 발생하면, Future.get()을 했을 때 계속 대기하는 상황이 발생할 수 있다
- Future.get()을 할 때, 타임아웃 값을 설정해서 타임아웃 처리한다. Timeout 시간동안 처리되지 않으면, TimeoutException이 발생한다. 
- CompletableFuture를 사용한다면 `completableFuture.completeExceptionally(ex);`를 이용해서, 명시적으로 예외를 포함한 종료처리를 해야한다. 그렇지 않으면 get()을 호출했을 때 계속 대기하게 된다


## 외부 기능을 내부적으로 비동기 실행하기
### 상황
물건을 검색할 때 1초씩 걸리는 외부 API에 대해서, 4개의 물건을 효율적으로 조회할 수 있는 방법 검토

### Case 1: 직접 호출
동기적으로 동작하기 때문에 총 4초 소요

### Case 2: 스트림 병렬 호출
parallelStream()을 이용하면 스트림의 병렬 기능을 이용해서 호출할 수 있다. 내부적으로는 forkjoinpool을 사용한다.

총 1초 소요

### Case 3: 스트림 병렬 호출
CompletableFuture를 이용해서도 병렬 호출을 할 수 있다.

총 1초 소요