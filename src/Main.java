import java.util.LinkedList;

public class Main {
	// Número de execuções do PSO
	static final int NUM_EXEC = 10;
	static double[] upperBukin = { -15, -3 };
	static double[] lowerBukin = { -5, 3 };

	static double[] upperEggholder = { 512, 512 };
	static double[] lowerEggholder = { -512, -512 };

	static double[] upperGriewank = { 600, 600, 600 };
	static double[] lowerGriewank = { -600, -600, -600 };

	static LinkedList<Result> results = new LinkedList<Result>();

	public static void main(String[] args) {

		for (int i = 0; i < NUM_EXEC; i++) {
			Problem bukin = new BukinProblem();
			// Setando limites da caixa de avaliação
			bukin.setLowerLimits(upperBukin);
			bukin.setUpperLimits(lowerBukin);
			// Setando valores para execuçao do PSO
			bukin.setNumberOfVariables(2);
			bukin.setNumberOfEvaluations(24000);
			bukin.setSwarmSize(8);
			// Coeficiente de inércia
			bukin.setW(0.9);
			// Coeficientes c1 e c2
			bukin.setC1(1.7);
			bukin.setC2(1.7);
			// Mínimos e máximos dos valores aleatórios
			bukin.setR1Min(0);
			bukin.setR1Max(5);
			bukin.setR2Min(-3);
			bukin.setR2Max(1);

			// Executa o PSO para o problema e salva o resultado em Result
			Result result = new PSO(bukin).run();

			results.add(result);
		}

		System.out.println("------------------ Bukin ------------------");

		System.out.println("Média de avaliações: " + Statistics.getAverageEvaluations(results));
		System.out.println("Mínimo de avaliações: " + Statistics.getMinEvaluations(results));
		System.out.println("Máximo de avaliações: " + Statistics.getMaxEvaluations(results));
		System.out.println("Desvio padrão das avaliações: " + Statistics.getSDEvaluations(results));

		System.out.println("Média de tempo: " + Statistics.getAverageTime(results) + " ms");
		System.out.println("Mínimo de tempo: " + Statistics.getMinTime(results) + " ms");
		System.out.println("Máximo de tempo: " + Statistics.getMaxTime(results) + " ms");
		System.out.println("Desvio padrão do tempo: " + Statistics.getSDTime(results) + " ms");

		System.out.println("Média de ótimos: " + Statistics.getAverageFitness(results));
		System.out.println("Mínimo de ótimos: " + Statistics.getMinFitness(results));
		System.out.println("Máximo de ótimos: " + Statistics.getMaxFitness(results));
		System.out.println("Desvio padrão dos ótimos: " + Statistics.getSDTime(results));

		System.out.println("Média de coordenadas: " + Statistics.getAverageCoord(results, 2));

		results.clear();

		/* ------------------ Eggholder ------------------ */
		for (int i = 0; i < NUM_EXEC; i++) {
			Problem eggholder = new EggholderProblem();
			// Setando limites da caixa de avaliação
			eggholder.setLowerLimits(upperEggholder);
			eggholder.setUpperLimits(lowerEggholder);
			// Setando valores para execuçao do PSO
			eggholder.setNumberOfVariables(2);
			eggholder.setNumberOfEvaluations(24000);
			eggholder.setSwarmSize(12);
			// Coeficiente de inércia
			eggholder.setW(0.8);
			// Coeficientes c1 e c2
			eggholder.setC1(2);
			eggholder.setC2(2);
			// Mínimos e máximos dos valores aleatórios
			eggholder.setR1Min(0);
			eggholder.setR1Max(1);

			eggholder.setR2Min(-1);
			eggholder.setR2Max(1);

			// Executa o PSO para o problema e salva o resultado em Result
			Result result = new PSO(eggholder).run();

			results.add(result);
		}
		System.out.println("------------------ Eggholder ------------------");

		System.out.println("Média de avaliações: " + Statistics.getAverageEvaluations(results));
		System.out.println("Mínimo de avaliações: " + Statistics.getMinEvaluations(results));
		System.out.println("Máximo de avaliações: " + Statistics.getMaxEvaluations(results));
		System.out.println("Desvio padrão das avaliações: " + Statistics.getSDEvaluations(results));

		System.out.println("Média de tempo: " + Statistics.getAverageTime(results) + " ms");
		System.out.println("Mínimo de tempo: " + Statistics.getMinTime(results) + " ms");
		System.out.println("Máximo de tempo: " + Statistics.getMaxTime(results) + " ms");
		System.out.println("Desvio padrão do tempo: " + Statistics.getSDTime(results) + " ms");

		System.out.println("Média de ótimos: " + Statistics.getAverageFitness(results));
		System.out.println("Mínimo de ótimos: " + Statistics.getMinFitness(results));
		System.out.println("Máximo de ótimos: " + Statistics.getMaxFitness(results));
		System.out.println("Desvio padrão dos ótimos: " + Statistics.getSDTime(results));

		System.out.println("Média de coordenadas: " + Statistics.getAverageCoord(results, 2));

		results.clear();

		// ------------------ Griewank ------------------
		for (int i = 0; i < NUM_EXEC; i++) {
			Problem griewank = new GriewankProblem();
			// Setando limites da caixa de avaliação
			griewank.setLowerLimits(upperGriewank);
			griewank.setUpperLimits(lowerGriewank);
			// Setando valores para execuçao do PSO
			griewank.setNumberOfVariables(3);
			griewank.setNumberOfEvaluations(24000);
			griewank.setSwarmSize(24);
			// Coeficiente de inércia
			griewank.setW(1.1);
			// Coeficientes c1 e c2
			griewank.setC1(1.5);
			griewank.setC2(1.5);
			// Mínimos e máximos dos valores aleatórios
			griewank.setR1Min(0);
			griewank.setR1Max(1);

			griewank.setR2Min(-1);
			griewank.setR2Max(1);

			// Executa o PSO para o problema e salva o resultado em Result
			Result result = new PSO(griewank).run();
			results.add(result);
		}

		System.out.println("------------------ Griewank ------------------");

		System.out.println("Média de avaliações: " + Statistics.getAverageEvaluations(results));
		System.out.println("Mínimo de avaliações: " + Statistics.getMinEvaluations(results));
		System.out.println("Máximo de avaliações: " + Statistics.getMaxEvaluations(results));
		System.out.println("Desvio padrão das avaliações: " + Statistics.getSDEvaluations(results));

		System.out.println("Média de tempo: " + Statistics.getAverageTime(results) + " ms");
		System.out.println("Mínimo de tempo: " + Statistics.getMinTime(results) + " ms");
		System.out.println("Máximo de tempo: " + Statistics.getMaxTime(results) + " ms");
		System.out.println("Desvio padrão do tempo: " + Statistics.getSDTime(results));

		System.out.println("Média de ótimos: " + Statistics.getAverageFitness(results));
		System.out.println("Mínimo de ótimos: " + Statistics.getMinFitness(results));
		System.out.println("Máximo de ótimos: " + Statistics.getMaxFitness(results));
		System.out.println("Desvio padrão dos ótimos: " + Statistics.getSDTime(results));

		System.out.println("Média de coordenadas: " + Statistics.getAverageCoord(results, 3));
	}

}
