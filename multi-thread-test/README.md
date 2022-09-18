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
