package model;

import java.time.LocalDateTime;

public class SampleWithoutLocalDateTime {

  private Long id;
  private String name;

  public SampleWithoutLocalDateTime(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
