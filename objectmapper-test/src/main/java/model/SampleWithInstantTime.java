package model;

import java.time.Instant;
import java.time.LocalDateTime;

public class SampleWithInstantTime {

  private final Long id;
  private final String name;
  private final Instant time;

  public SampleWithInstantTime(Long id, String name, Instant time) {
    this.id = id;
    this.name = name;
    this.time = time;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Instant getTime() {
    return time;
  }
}
