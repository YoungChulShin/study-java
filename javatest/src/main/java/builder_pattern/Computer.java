package builder_pattern;

public class Computer {

  private String cpuModel;

  private int ramSize;

  private String powerModel;

  private String gpuModel;

  private String diskType;

  private int diskSize;

  @Override
  public String toString() {
    return "Computer{" +
        "cpuModel='" + cpuModel + '\'' +
        ", ramSize=" + ramSize +
        ", powerModel='" + powerModel + '\'' +
        ", gpuModel='" + gpuModel + '\'' +
        ", diskType='" + diskType + '\'' +
        ", diskSize=" + diskSize +
        '}';
  }

  public static ComputerBuilder builder() {
    return new ComputerBuilder();
  }

  public static class ComputerBuilder {
    private String cpuModel;

    private int ramSize;

    private String powerModel;

    private String gpuModel;

    private String diskType;

    private int diskSize;

    public ComputerBuilder cpuModel(String cpuModel) {
      this.cpuModel = cpuModel;
      return this;
    }

    public ComputerBuilder ramSize(int ramSize) {
      this.ramSize = ramSize;
      return this;
    }

    public ComputerBuilder powerModel(String powerModel) {
      this.powerModel = powerModel;
      return this;
    }

    public ComputerBuilder gpuModel(String gpuModel) {
      this.gpuModel = gpuModel;
      return this;
    }

    public ComputerBuilder diskType(String diskType) {
      this.diskType = diskType;
      return this;
    }

    public ComputerBuilder diskSize(int diskSize) {
      this.diskSize = diskSize;
      return this;
    }

    public Computer build() {
      Computer computer = new Computer();
      computer.cpuModel = cpuModel;
      computer.ramSize = ramSize;
      computer.powerModel = powerModel;
      computer.gpuModel = gpuModel;
      computer.diskType = diskType;
      computer.diskSize = diskSize;

      return computer;
    }
  }
}
