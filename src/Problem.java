abstract class Problem {
	// Limites da caixa de avaliação
	private double[] upperLimits;
	private double[] lowerLimits;

	// Constantes customizáveis para cada problema a ser otimizado por PSO
	protected double w;
	private double c1;
	private double c2;

	// Minimos e máximos de valores gerados aleatoriamente para o PSO
	private double r1Min;
	private double r1Max;

	private double r2Min;
	private double r2Max;

	private int swarmSize;
	private int numberOfVariables;
	private int numberOfEvaluations;
	private int numberOfCalls;

	public Problem() {
		numberOfCalls = 0;
	}

	public double evaluate(Particle p) {
		// Implementar nas classes que herdam esta classe
		return 0;
	}

	public void incrementCalls() {
		numberOfCalls++;
	}

	public int getNumberOfCalls() {
		return numberOfCalls;
	}

	public int getSwarmSize() {
		return swarmSize;
	}

	public void setSwarmSize(int swarmSize) {
		this.swarmSize = swarmSize;
	}

	public int getNumberOfVariables() {
		return numberOfVariables;
	}

	public void setNumberOfVariables(int numberOfVariables) {
		this.numberOfVariables = numberOfVariables;
	}

	public int getNumberOfEvaluations() {
		return numberOfEvaluations;
	}

	public void setNumberOfEvaluations(int numberOfEvaluations) {
		this.numberOfEvaluations = numberOfEvaluations;
	}

	public double getC1() {
		return c1;
	}

	public void setC1(double c1) {
		this.c1 = c1;
	}

	public double getC2() {
		return c2;
	}

	public void setC2(double c2) {
		this.c2 = c2;
	}

	public void setR1Min(double r1Min) {
		this.r1Min = r1Min;
	}

	public void setR2Min(double r2Min) {
		this.r2Min = r2Min;
	}

	public void setR1Max(double r1Max) {
		this.r1Max = r1Max;
	}

	public void setR2Max(double r2Max) {
		this.r2Max = r2Max;
	}

	public double getR1() {
		return Math.random() * (r1Max - r1Min) + r1Min;
	}

	public double getR2() {
		return Math.random() * (r2Max - r2Min) + r2Min;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getLowerLimits(int index) {
		return lowerLimits[index];
	}

	public double getUpperLimits(int index) {
		return upperLimits[index];
	}

	public void setLowerLimits(double[] lowerLimits) {
		this.lowerLimits = lowerLimits;
	}

	public void setUpperLimits(double[] upperLimits) {
		this.upperLimits = upperLimits;
	}
}
