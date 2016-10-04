public class BukinProblem extends Problem {
	public BukinProblem() {
		super();

	}

	@Override
	public double evaluate(Particle p) {
		double[] coord = p.getCoord();
		double result;

		// Modelagem da função Bukin
		result = 100 * Math.sqrt(Math.abs(coord[1] - 0.01 * Math.pow(coord[0], 2))) + 0.01 * Math.abs(coord[0] + 10);
		incrementCalls();

		return result;
	}
}
