# 저장소 설명
멀티스테드에서 공유 데이터 업데이트

# 방법
동작하는 방법
1. Synchronized 사용
   - 동시에 1개의 Thread만 사용할 수 있도록 Lock을 걸기 때문에 멀티스레드에서도 문제가 되지 않는다. 
   - 다만 Lock을 걸기 때문에 속도는 느릴 수 있다
2. AtomicInteger 사용
   - CAS 방식으로 데이터 처리
   - Synchronized보다 빠르다

동작하지 않는 방법
1. volatile 키워드
   - volatile로 선언된 변수는 최신의 값을 가져오는 것을 보장한다. 
   - 다만 예제코드에서 사용한 `++` 연산의 경우, `get and increment`의 방식으로 동작하기 때문에 `get`과 `increment`사이에 다른 스레드가 값을 업뎅이트하면 값이 깨질 수 있다