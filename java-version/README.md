# 저장소 설명
Java 버전별 특징에 대한 정리

# 참고 자료
- https://www.marcobehler.com/guides/a-guide-to-java-versions-and-features
- https://learn.microsoft.com/en-us/java/openjdk/reasons-to-move-to-java-11

# 버전에 대한 메모
릴리즈 주기
- 6개월 주기로 릴리즈 된다
- 자바 LTS 버전: 17 (2021.09) [Link](https://www.oracle.com/java/technologies/java-se-support-roadmap.html)

배포
- Java 8까지 있던 JDK, JRE의 구분이 9부터 JDK로 통합

호환성
- Java8으로 개발된 코드는 Java18(=최신버전)에서도 동작한다

스프링부트 3.0
- `2023.04.02` 기준 3.0.5 버전이 GA: [Link](https://spring.io/projects/spring-boot#learn)
- Java 17버전 필요 [Link](https://spring.io/blog/2022/05/24/preparing-for-spring-boot-3-0)

# Java8
## Time
### 기본 정보
제공 클래스
- LocalDate
- LocalTime
- LocalDateTime
- Instant
- Duration
- Period 등

시간 정보
- LocalDate, LocalTime, LocalDateTime: 시스템 시계의 정보를 이용해서 현재 날짜 정보를 가져온다
- Instant: 유닉스 에포크 시간(Unix Epoch Time, 1970년 1월 1일 0시 0분 0초 UTC)를 기준으로 
- Duration: 초, 나노초 단위의 사간 차이
- Period: 날짜 단위의 차이

### 날짜 변환
지금까지 작성된 클래스는 모두 불편이기 때문에, 해당 값의 변경하면 기존 값이 변경되는 것이 아니래 새로운 객체를 반환한다. 
```java
LocalDate date1 = LocalDate.of(2023, 3, 26);
LocalDate date2 = date1.withYear(2024);
// date1: 2023.03.26
// date2: 2024.03.26
```

`'TemporalAdjuster'` 인터페이스를 이용하면 조금 더 복잡한 날짜 변환을 할 수 있다. 
- 'TemporalAdjusters' 클래스는 이러한 상황에 이용할 수 메서드들을 제공해준다

`'DateTimeFormatter'`를 이용해서 '날짜 -> 문자열', '문자열 -> 날짜'로 변환할 수 있다. 
- DateTimeFormatter는 이미 정해진 타입도 있고, 신규로 생성할 수도 있다. 
- 날짜 -> 문자열 변환
   ```java
   LocalDate date9 = LocalDate.of(2023, 3, 25);
   System.out.println(date9.format(DateTimeFormatter.BASIC_ISO_DATE));
   System.out.println(date9.format(DateTimeFormatter.ISO_WEEK_DATE));
   ```
- 문자열 -> 날짜 변환
   ```java
   // 문자열 ->  날짜
   LocalDate date10 = LocalDate.parse("2023-W12-6", DateTimeFormatter.ISO_WEEK_DATE);
   // Custom DatetimeFormatter
   DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
   LocalDateTime datetime11 = LocalDateTime.parse("2023-03-26 17:19:11", dateTimeFormatter);
   ```

### 시간대 변환
기존에 LocalDateTime, LocalDate는 시간대 정보를 가지고 있지 않는다. ZoneId와 ZonedDateTime을 이용하면 시간대 정보를 함께 표시할 수 있다. 

ZonedDateTime의 범위
1. LocalDate + LocalTime + ZoneId
2. LocalDateTime + ZoneId
3. ZonedDateTime

ZoneId
- '지역/도시' 형식으로 이루어진다
- zoneId 가져오기
   ```java
   // zoneId로 가져오기
   ZoneId.of("Etc/UTC");
   // 기본 값
   TiemZone.getDefault().toZoneId();
   ```

Zone 정보를 이용한 변환
```java
// LocalDateTime -> Instant로 변환
LocalDateTime currentTime = LocalDateTime.now();
// LocalDateTime이 변경되지는 않고, Zone 정보가 추가된다
ZonedDateTime seoulZone = currentTime.atZone(ZoneId.of("Asia/Seoul"));
Instant seoulInstant = seoulZone.toInstant();

// Instant -> LocalDateTime으로 변환
Instant instant13 = Instant.now();
// UTC 기준으로 현재 뉴욕시간이 표시된다. 하지만 zone 정보는 사라진다
LocalDateTime localDateTime = LocalDateTime.ofInstant(instant13, ZoneId.of("America/New_York"));
```

# Java 9
## 키워드
- Collection: 새로운 helper 메서드 추가
- Stream: 새로운 메서드 추가
   - iterate, takeWhile, dropWhile
- Optional: 새로운 메서드 추가
   - ifPresentOrElse
- Interface: private method 추가. interface에서 공통 코드를 분리할 수 있다

### Collection 생성
```java
// java 8
List<Integer> listInteger1 = new ArrayList<>();
listInteger1.add(1);
listInteger1.add(2);
listInteger1.add(3);

List<Integer> listInteger2 = new ArrayList<>() {{
    add(1);
    add(2);
    add(3);
    }};

List<Integer> listInteger3 = Stream.of(1, 2, 3).collect(Collectors.toList());

// 불변
List<Integer> listInteger4 = Arrays.asList(1, 2, 3);

// java9 - 불변
List<Integer> listInteger5 = List.of(1, 2, 3);
```

### Optional-ifPresentOrElse
```java
// java8
Optional<String> message = Optional.empty();
if (message.isPresent()) {
    System.out.println(message.get());
} else {
    System.out.println("empty");
}

// java9
message.ifPresentOrElse(System.out::println, () -> System.out.println("empty"));
```

### Interface with private mehtod
```java
public interface InterfaceEx {

  default void printHello() {
    printHelloInternal();
  }

  private void printHelloInternal() {
    System.out.println("hello");
  }
}
```

# Java 10
## 키워드
- var 키워드 추가

### var 키워드
```java
// java 8
String greeting = "hello";

// java 10
var greeting2 = "안녕하세요";  // class java.lang.String
```

# Java 11 - LTS
## 키워드
- String: 새로운 메서드 추가
   - isBlank(), lines(), strip()
- HttpClient: java9에 initial version이 final 버전으로 결정
   - 기존에는 Apache HttpClient 또는 OkHttp 같은 3rd party 라이브러리를 사용해야했다

## update java 8 to java 11
- 모듈 시스템 (java 9)
- 새로운 Profiling, Diagnostics 도구 사용 가능
   - JFR(Java Flight Recoder)
   - JMC(Java Mission Control)
   - Low-overhead 힙 프로파일링 제공
   - StackWalker
   - G1 GC
      - Java 8 default: Parallel GC. Multiple Thread를 이용한 garbage collection 속도 향상
   - docker container 지원 개선
      - jvm에서 memory, cpu constraint 설정 가능. (java8에서는 host 메모리의 1/4를 사용)


### String 헬퍼 메서드 - isBlank()
```java
// java 8 공백 체크
String greeting = " ";

if (greeting.trim().isEmpty()) {
    System.out.println("blank");
}

// java 8 + Apache Commons Lang library
if (StringUtils.isBlank(greeting)) {
    System.out.println("blank");
}

// java 11
if (greeting.isBlank()) {
    System.out.println("blank");
}
```

### String 헬퍼 메서드 - lines()
```java
String mixedAlphabet = "aaaa\rbbbb\ncccc";
Stream<String> lines = mixedAlphabet.lines();
lines.forEach(System.out::println);
// aaaa
// bbbb
// cccc
```

# Java 12
## 키워드
- Unicode 11 지원

# Java 13
## 키워드
- Unicode 12.1 지원
- Switch: 표현식을 지원 (Preview)
- MultiLine String 지원 (Preview)

# Java 14
## 키워드
- Switch: 표현식 정식 지원
- Records: Preview 추가
- NullPointerException: 어떤 값이 null인지 조금 더 자세히 표시한다

### Switch 표현식
```java
public enum Nationality { KOREA, JAPAN, USA, CHINA }

Nationality my = Nationality.KOREA;

// java 8
String greeting;
switch (my) {
    case KOREA:
      greeting = "안녕하세요";
      break;
    case USA:
      greeting = "헬로";
      break;
    default:
      greeting = "잘 모르겠네요";
      break;
}
System.out.println(greeting);

// java 14
String greeting2 = switch (my) {
    case KOREA -> "안녕하세요";
    case USA -> "헬로";
    default -> {
      yield "잘 모르겠네요";
    }
};
System.out.println(greeting2);
```

### NullPointerException의 null 표현 강화
```java
User user = null;
System.out.println(user.name);
// message: Cannot read field "name" because "user" is null
```

# Java 15
## 키워드
- MultiLine String: 정식 지원 (13에서 Preview)
- Sealed Class 추가 (Preview)
   - public class에 하위 클래스가 어떤게 올 수 있는지 지정할 수 있다
- ZGC: Production-Ready 로 상태 변경. [Link](https://wiki.openjdk.org/display/zgc/Main)

### MultiLine/TextBlock String
```java
// java8
String greeting = "안녕하세요.\n"
    + "만나서 반갑습니다";
System.out.println(greeting);

// java15
String greeting2 = """
    안녕하세요.
    만나서 반갑습니다""";
System.out.println(greeting2);

// if (greeting.equals(greeting2)) => true

String greeting3 = """
    안녕하세요. \
    만나서 반갑습니다""";
System.out.println(greeting3);  // 안녕하세요. 만나서 반갑습니다
```

# Java 16
## 키워드
- Pattern Matching: 정식 지원
- Record: 정식 지원
   - dto를 만들 때 편리하게 사용할 수 있다
   - 생성자, getter, toString, equals, hashCode를 기본으로 지원한다
- [Unix-Domain Socket](https://www.lesstif.com/linux-core/unix-domain-socket) Channel 지원

### Pattern Matching for instanceOf
```java
// java8
private void printData(Object data) {
if (data instanceof String) {
    String stringData = (String) data;
    System.out.println(stringData.substring(1));
}
}

// java16
private void printData2(Object data) {
if (data instanceof String stringData) {
    System.out.println(stringData.substring(1));
}
}
```

### Record
기본 사용
- 기본 정의 및 사용 코드
   ```java
   // record 선언
   record Point2(int x, int y) { }

   // Java 14 (Preview), Java16 (Official)
   // constructor
   Point2 point = new Point2(1, 2);
   // getter
   point.x();
   point.y();
   // toString()
   System.out.println(point); // Point2[x=1, y=2]
   // equals
   Point2 point2 = new Point2(1, 2);
   if (point.equals(point2)) { // true
      System.out.println("equal!");
   }
   // hashCode
   Set<Point2> pointSet = new HashSet<>();
   pointSet.add(point);
   pointSet.add(point2);
   System.out.println(pointSet.size());  // 1
   ```

생성자 
- 생성자 사용 샘플
   ```java
   public record SampleRequest(Long id, String name, int age) {
      // 클래스가 생성되었을 때 아래 코드가 동작한다
      public SampleRequest {
         System.out.println("생성되었습니다. id: " + id + ", name: " + name + ", age: " + age);
      }
   }
   ```

