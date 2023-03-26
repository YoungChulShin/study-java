# 저장소 설명
Java 버전별 특징에 대한 코딩

버전별 특징에 대한 설명:
https://github.com/YoungChulShin/TIL/blob/master/Java/버전별정리.md

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



