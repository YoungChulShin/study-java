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

  public static void createComputer2() {
    Computer2 computer = new Computer2.Computer2Builder("ryzen3", 64)
        .diskSize(512)
        .diskType("hdd")
        .gpuModel("radeon 9600xt")
        .build();



    System.out.println(computer);
  }
}
