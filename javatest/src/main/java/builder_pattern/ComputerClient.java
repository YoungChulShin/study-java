package builder_pattern;

public class ComputerClient {
  public static void createComputer() {
    Computer computer = Computer.builder()
        .cpuModel("intel i9")
        .diskType("ssd")
        .diskSize(1024)
        .gpuModel("GTX 3080")
        .build();

    System.out.println(computer);
  }
}
