public class EggholderProblem extends Problem {

	public EggholderProblem() {
		super();
	}

	@Override
	public double evaluate(Particle p) {
		double[] coord = p.getCoord();
		double result;

		// Modelagem da função Eggholder
		result = -1 * (coord[1] + 47) * Math.sin(Math.sqrt(Math.abs(coord[1] + (coord[0] / 2) + 47)))
				- coord[0] * Math.sin(Math.sqrt(Math.abs(coord[0] - (coord[1] + 47))));
		incrementCalls();

		return result;

	}
}
