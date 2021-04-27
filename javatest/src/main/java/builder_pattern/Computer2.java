package builder_pattern;

public class Computer2 {

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

  public Computer2(Computer2Builder builder) {
    this.cpuModel = builder.getCpuModel();
    this.ramSize = builder.getRamSize();
    this.powerModel = builder.getPowerModel();
    this.gpuModel = builder.getGpuModel();
    this.diskType = builder.getDiskType();
    this.diskSize = builder.getDiskSize();
  }

  public static class Computer2Builder {

    private String cpuModel;

    private int ramSize;

    private String powerModel;

    private String gpuModel;

    private String diskType;

    private int diskSize;

    public Computer2Builder(String cpuModel, int ramSize) {
      this.cpuModel = cpuModel;
      this.ramSize = ramSize;
    }

    public Computer2Builder powerModel(String powerModel) {
      this.powerModel = powerModel;
      return this;
    }

    public Computer2Builder gpuModel(String gpuModel) {
      this.gpuModel = gpuModel;
      return this;
    }

    public Computer2Builder diskType(String diskType) {
      this.diskType = diskType;
      return this;
    }

    public Computer2Builder diskSize(int diskSize) {
      this.diskSize = diskSize;
      return this;
    }



    public String getCpuModel() {
      return cpuModel;
    }

    public int getRamSize() {
      return ramSize;
    }

    public String getPowerModel() {
      return powerModel;
    }

    public String getGpuModel() {
      return gpuModel;
    }

    public String getDiskType() {
      return diskType;
    }

    public int getDiskSize() {
      return diskSize;
    }

    public Computer2 build() {
      return new Computer2(this);
    }
  }
}
