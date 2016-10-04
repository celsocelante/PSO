import java.util.Arrays;
import java.util.LinkedList;

public class PSO {
	private LinkedList<Particle> swarm;
	private Problem problem;

	private double globalBestFitness;
	private double previousGlobalBestFitness;
	private double[] globalBestCoord;

	private int stopCriteria;

	public PSO(Problem problem) {
		this.problem = problem;
		swarm = new LinkedList<Particle>();

		// Cria o exame de tamanho pré-determinado pelo problema
		for (int i = 0; i < problem.getSwarmSize(); i++) {
			Particle p = new Particle(problem);
			swarm.add(p);
		}
		// Seleciona a primeira partícula como globalBest, apenas para início
		globalBestCoord = Arrays.copyOf(swarm.get(0).getCoord(), problem.getNumberOfVariables());
		globalBestFitness = 0;
		previousGlobalBestFitness = 0;
		stopCriteria = 0;
	}

	public Result run() {
		long startTime = System.nanoTime();

		while (problem.getNumberOfCalls() < problem.getNumberOfEvaluations() && stopCriteria < 15) {
			for (Particle p : swarm) {
				// Executa as etapas do PSO para cada partícula
				p.updateFitness();
				this.updateGlobalBest(p);
				p.updateVelocity(globalBestCoord);
				p.updatePosition();

			}
		}
		long endTime = System.nanoTime();

		// Retorna objeto Resultado com o númer ode chamadas, o melhor resultado
		// e o tempo de execução
		Result r = new Result(problem.getNumberOfCalls(), globalBestCoord, globalBestFitness,
				(endTime - startTime) / 1000000);
		return r;

	}

	// Método que atualiza o globalBest
	public void updateGlobalBest(Particle p) {
		if (p.getFitness() > globalBestFitness) {
			previousGlobalBestFitness = globalBestFitness;

			globalBestFitness = p.getFitness();
			globalBestCoord = Arrays.copyOf(p.getCoord(), p.getCoord().length);

			// Quando a variação é baixa, para o algoritmo antes de todas as
			// iterações possíveis
			if ((globalBestFitness - previousGlobalBestFitness) > 0.001) {
				this.stopCriteria++;
			} else {
				this.stopCriteria = 0;
			}
		}

	}

}
