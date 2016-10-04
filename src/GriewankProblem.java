public class GriewankProblem extends Problem {

	public GriewankProblem() {
		super();
	}

	@Override
	public double evaluate(Particle p) {
		double[] coord = p.getCoord();
		double sum = 0;
		double prod = 1;

		// Modelagem da função Griewank
		for (int i = 0; i < this.getNumberOfVariables(); i++) {
			sum += Math.pow(coord[i], 2) / 4000.0;
			prod *= Math.cos(coord[i] / Math.sqrt(i + 1));

		}

		incrementCalls();
		return sum - prod + 1;
	}
}
