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