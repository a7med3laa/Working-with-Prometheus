package Testing;

/**
 * This class represents a book.
 * 
 * @author www.codejava.net
 *
 */
public class Metric {
	private double throughput;
	private double CPU;
	private double Memory;
	private double Load;

	public Metric() {
	}

	public Metric(double T, double CPU, double Mem, double load) {
		this.throughput = T;
		this.CPU = CPU;
		this.Memory = Mem;
		this.Load = load;
	}

	public double getThroughput() {
		return throughput;
	}

	public void setThroughput(double throughput) {
		this.throughput = throughput;
	}

	public double getCPU() {
		return CPU;
	}

	public void setCPU(double cPU) {
		CPU = cPU;
	}

	public double getMemory() {
		return Memory;
	}

	public void setMemory(double memory) {
		Memory = memory;
	}

	public double getLoad() {
		return Load;
	}

	public void setLoad(double load) {
		Load = load;
	}

	public String toString() {
		return String.format("%f - %f - %f - %f", throughput, CPU, Memory, Load);
	}
}
