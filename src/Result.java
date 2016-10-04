import java.util.Arrays;

public class Result {
	private long time;
	private int evaluations;
	private double[] coord;
	private double fitness;

	public Result(int evaluations, double[] coord, double fitness, long time) {
		this.evaluations = evaluations;
		this.coord = Arrays.copyOf(coord, coord.length);
		this.fitness = fitness;
		this.time = time;

	}

	public long getTime() {
		return time;
	}

	public int getEvaluations() {
		return evaluations;
	}

	public double[] getCoord() {
		return coord;
	}

	public double getFitness() {
		return fitness;
	}

}
