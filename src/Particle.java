import java.util.Arrays;

public class Particle {
	private double[] coord;
	private double[] velocity;
	private double fitness;

	private double[] personalBestCoord;
	private double personalBestFitness;
	private Problem problem;

	private boolean firstIteration;

	public Particle(Problem problem) {
		this.problem = problem;

		coord = new double[problem.getNumberOfVariables()];
		velocity = new double[problem.getNumberOfVariables()];

		firstIteration = true;
		fitness = 0;

		// Inicializando com a velocidade com zeros e as coordenadas com números
		// aleatórios
		for (int i = 0; i < problem.getNumberOfVariables(); i++) {
			velocity[i] = 0;
			// Gera coordenas aleatórias dentro dos limites do problema
			coord[i] = Math.random() * (problem.getUpperLimits(i) - problem.getLowerLimits(i))
					+ problem.getLowerLimits(i);
		}

	}

	public void updateFitness() {
		// Avalia a partícula no ponto atual
		fitness = problem.evaluate(this);

		// Inicializa o personalBest caso seja primeira iteração
		if (firstIteration) {
			firstIteration = false;
			personalBestCoord = Arrays.copyOf(coord, problem.getNumberOfVariables());
			personalBestFitness = fitness;
		}

		// Substitui o personalBest caso o novo resultado seja maior (max.
		// função)
		if (personalBestFitness < fitness) {
			personalBestFitness = fitness;
			personalBestCoord = Arrays.copyOf(coord, problem.getNumberOfVariables());
		}

	}

	public void updateVelocity(double[] globalBest) {
		// Calcula as partes da equação de velocidade
		double[] temp1 = new double[problem.getNumberOfVariables()];
		double[] temp2 = new double[problem.getNumberOfVariables()];
		double[] temp3 = new double[problem.getNumberOfVariables()];

		// Faz os cálculos vetoriais presentes na equação de velocidade
		for (int i = 0; i < problem.getNumberOfVariables(); i++) {
			// Multiplica pelo coeficiente de inércia e guarda em array
			// temporário
			temp1[i] = velocity[i] * problem.getW();

			// Multiplica os coeficientes c1 e r1
			temp2[i] = coord[i] - personalBestCoord[i];
			temp2[i] = temp2[i] * problem.getC1() * problem.getR1();

			// Multiplica os coeficientes c2 e r2
			temp3[i] = globalBest[i] - personalBestCoord[i];
			temp3[i] = temp3[i] * problem.getC2() * problem.getR2();

			// Soma todos os resultados temporários no array velocity
			velocity[i] = temp1[i] + temp2[i] + temp3[i];
		}
	}

	public void updatePosition() {
		// Atualiza cada componente do vetor de localização somando a nova
		// velocidade
		for (int i = 0; i < problem.getNumberOfVariables(); i++) {
			coord[i] = coord[i] + velocity[i];

			// Quando a coordenada sai do quadrado de avaliação, gera novas
			// coordenadas aleatórias dentro do limite
			if (coord[i] < problem.getLowerLimits(i) || coord[i] > problem.getUpperLimits(i)) {
				coord[i] = Math.random() * (problem.getUpperLimits(i) - problem.getLowerLimits(i))
						+ problem.getLowerLimits(i);
			}
		}

	}

	public double getPersonalBestFitness() {
		return personalBestFitness;
	}

	public double[] getPersonalBestCoord() {
		return personalBestCoord;
	}

	// Obtém as coordenadas atuais da partícula (shallow copy)
	public double[] getCoord() {
		return Arrays.copyOf(coord, coord.length);
	}

	// Obtém o fitness atual da partícula
	public double getFitness() {
		return fitness;
	}

	// Retorna uma String que representa textualmente a partícula com (x1, x2):
	// fitness
	public String toString() {
		return "(" + coord[0] + ", " + coord[1] + "): " + fitness;
	}

}
