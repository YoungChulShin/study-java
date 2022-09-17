package model;

import java.time.LocalDateTime;

public class Sample {

  private final Long id;
  private final String name;
  private final LocalDateTime time;

  public Sample(Long id, String name, LocalDateTime time) {
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

  public LocalDateTime getTime() {
    return time;
  }
}
