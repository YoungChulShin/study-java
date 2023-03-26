package study.java.version.java8.time;

import static java.time.temporal.TemporalAdjusters.nextOrSame;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeApplication {

  public static void main(String[] args) {
    // LocalDate 선언
    // 팩토리 메서드
    LocalDate date1 = LocalDate.of(2023, 3, 26);
    // 문자열 파싱
    LocalDate date2 = LocalDate.parse("2023-03-26");

    // Instant
    Instant instant1 = Instant.ofEpochSecond(3);
    Instant instant2 = Instant.ofEpochSecond(3, 0);
    System.out.println(instant1);
    System.out.println(instant2);

    // Duration - 초, 나노초의 시간 표현
    Duration br1 = Duration.between(Instant.now().minus(5, ChronoUnit.SECONDS), Instant.now());
    Duration br2 = Duration.between(LocalDateTime.now().minus(5, ChronoUnit.SECONDS), LocalDateTime.now());
    System.out.println(br1);
    System.out.println(br2);
    Duration dr3 = Duration.ofSeconds(1);

    // Period
    var pr1 = Period.between(LocalDate.now().minus(1, ChronoUnit.DAYS), LocalDate.now());
    System.out.println(pr1);
    var pr2 = Period.ofDays(10);

    // 불변 테스트
    // date3를 기준으로 값을 변경해도 date3 자체는 변경되지 않는다
    LocalDate date3 = LocalDate.of(2023, 3, 26);
    LocalDate date4 = date3.withYear(2024);
    System.out.println(date3);
    System.out.println(date4);

    // TemporalAdjusters
    LocalDate date5 = LocalDate.of(2023, 3, 26);
    LocalDate date6 = date5.with(nextOrSame(DayOfWeek.TUESDAY));
    System.out.println(date6);

    // working day 계산
    LocalDate date7 = LocalDate.of(2023, 3, 25);
    LocalDate date8 = date7.with(new NextWorkingDay());

    // 날짜 변환
    LocalDate date9 = LocalDate.of(2023, 3, 25);
    System.out.println(date9.format(DateTimeFormatter.BASIC_ISO_DATE));
    System.out.println(date9.format(DateTimeFormatter.ISO_WEEK_DATE));
    System.out.println(date9.format(DateTimeFormatter.ISO_ORDINAL_DATE));

    // 2023-W12-6
    LocalDate date10 = LocalDate.parse("2023-W12-6", DateTimeFormatter.ISO_WEEK_DATE);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CANADA);
    LocalDateTime datetime11 = LocalDateTime.parse("2023-03-26 17:19:11", dateTimeFormatter);

    // 타임존
    TimeZone defaultTimeZone = TimeZone.getDefault();
    ZoneId defaultZoneId = defaultTimeZone.toZoneId();
    System.out.println(defaultTimeZone);
    System.out.println(defaultZoneId);

    LocalDateTime datetime12 = LocalDateTime.now();
    ZonedDateTime zonedDateTimeUTC = datetime12.atZone(ZoneId.of("Etc/UTC"));
    ZonedDateTime zonedDateTimeUSA = datetime12.atZone(ZoneId.of("America/New_York"));
    ZonedDateTime zonedDateTimeKOR = datetime12.atZone(ZoneId.of("Asia/Seoul"));
    System.out.println(datetime12);
    System.out.println(zonedDateTimeUTC);
    System.out.println(zonedDateTimeUSA);
    System.out.println(zonedDateTimeKOR);
    // Instant는 UTC 기준이기 때문에 Zone 정보가 있어야한다
    System.out.println(zonedDateTimeUTC.toInstant());
    System.out.println(zonedDateTimeUSA.toInstant());
    System.out.println(zonedDateTimeKOR.toInstant());
  }
}
