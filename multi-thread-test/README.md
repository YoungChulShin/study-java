# 동기/비동기를 사용 실습
## CompletableFuture
Java8부터 사용 가능하며, 비동기 호출을 훨씬 쉽게 만들어준다. 

CompletableFuture 큰 특징은 콜백을 등록하거나 메서드 체이닝, 2개의 비동기를 합치는 등의 동작을 할 수 있다. 기존에도 Future를 통해서 할 수 있었으나, 그 방법이 더 쉬워졌다. 

메서드
- runAsync
   - 팩토리 메서드
   - runnable을 전달 받는다
- supplyAsync
   - 팩토리 메서드
   - supplier를 전달 받는다. 응답값이 `CompletableFuture<T>` 가 된다. 
- thenApply
   - 앞의 연산의 결과 값을 이어서 처리할 때 사용한다
   - CompletableFuture가 끝날 때까지 블록하지 않는다
- thenCompose
   - 첫번째 연산의 결과를 두번째 연산으로 전달한다
- thenCombine
   - 첫번째 연산과 두번째 연산을 합해서 처리한다
- thenAccept
   - 연산 결과를 소비하는 'Consumer'를 파라미터로 받는다
- allOf
   - CompletableFuture 배열을 입력받아서 `CompletableFuture<Void>`를 반환한다. 
   - 모든 CompletableFuture가 완료되어야 완료된다. 
   - `join` 메서드를 호출하면 실행 완료를 기다릴 수 있다
- anyOf
   - 처음으로 완료한 CompletableFuture 값으로 동작을 완성한다

특징
- 일반 메서드와 async가 붙은 메서드와의 차이
   - async로 끝나는 메서드는 해당 작업을 다른 스레드에서 실행되도록 스레드 풀에 작업을 요청한다. 
   - aysnc가 없는 메서드는 이전 작업을 수행한 스레드와 같은 스레드에서 작업을 수행한다
   - 꼭 새로운 스레드에서 실행되어야하는게 아니라면 일반메서드를 사용해서 스레드 전환 오버헤드나 새로운 스레드가 없어서 대기하는 등의 문제를 줄일 수 있다

스트림 병렬화와 CompletableFuture 병렬화
- I/O가 포함되어 있지 않은 계산 중심의 동작은 스트림 인터페이스가 구현하기 편한다
- I/O를 기다리는 작업을 병렬로 실행할 때에는 CompletableFuture를 통해서 조금 더 유연한 작업 편의성을 가져갈 수 있고, 스레드수를 계산해서 적용할 수 있다


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
별도로 실행중인 스레드에서 예외가 발생해도 해당 에러가 전파되지는 않는다. 이때 `exceptionally`를 사용하면 에러가 발생했을 때 내용을 정의할 수 있다. 이때 실제로 에러가 throw 되려면 `.get()` 을 호출해야한다.

`CompletableFuture.completeExceptionally`를 이용하면 명시적으로 예를 발생시키면서 종료시킬 수도 있다. 

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