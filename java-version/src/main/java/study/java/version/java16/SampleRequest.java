package study.java.version.java16;

public record SampleRequest(Long id, String name, int age) {

  public SampleRequest {
    System.out.println("생성되었습니다. id: " + id + ", name: " + name + ", age: " + age);
  }

  public void printName() {
    System.out.println(name);
  }
}
