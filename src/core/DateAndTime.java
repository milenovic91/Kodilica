package core;

import java.sql.Date;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.ChronoField;

public class DateAndTime {
  public static void main(String [] args) {
    System.out.println(LocalDate.of(1991, 1, 7).getDayOfWeek());
    // MONDAY

    // EQUIVALENT: moment().startOf('month');
    if (Instant.now().isSupported(ChronoField.DAY_OF_MONTH)) {
      // This branch is not taken since DAY_OF_MONTH is not supported
      // by Instant. Otherwise, It would throw:
      // java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: DayOfMonth
      System.out.println(Instant.now().with(TemporalAdjusters.firstDayOfMonth()));
    }
    System.out.println(
      Date.from(
        ZonedDateTime.now()
          .with(TemporalAdjusters.firstDayOfMonth())
          .with(ChronoField.MILLI_OF_DAY, 0)
          .toInstant()
      )
    );
    // Fri Dec 01 00:00:00 CET 2023

    // EQUIVALENT: moment().startOf('month').add(14, 'day').endOf('day');
    System.out.println(
      Date.from(
        ZonedDateTime.now()
          .withDayOfMonth(16)
          .withHour(0)
          .truncatedTo(ChronoUnit.HOURS)
          .minusSeconds(1)
          .toInstant()
      )
    );
    // Fri Dec 15 23:59:59 CET 2023

    // Local time in Athens:
    System.out.println(LocalTime.now(Clock.system(ZoneId.of("Europe/Athens"))));
    // 12:57:19.866979
  }
}
