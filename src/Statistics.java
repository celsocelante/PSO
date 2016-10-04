import java.util.List;

public class Statistics {

	private Statistics() {
		;
	}

	// Média de chamadas da função objetiva
	public static double getAverageEvaluations(List<Result> l) {
		double total = 0;

		for (Result r : l) {
			total += r.getEvaluations();
		}

		return total / l.size();

	}

	// Média de tempo de execução
	public static double getAverageTime(List<Result> l) {
		double total = 0;

		for (Result r : l) {
			total += r.getTime();
		}

		return total / l.size();

	}

	// Média dos ótimos encontrados
	public static double getAverageFitness(List<Result> l) {
		double total = 0;

		for (Result r : l) {
			total += r.getFitness();
		}

		return total / l.size();

	}

	// Média de coordenadas dos ponto ótimos encontrados
	public static String getAverageCoord(List<Result> l, int numVar) {
		double[] total = new double[numVar];

		for (Result r : l) {

			for (int i = 0; i < numVar; i++) {
				total[i] += r.getCoord()[i] / l.size();
			}
		}

		String s = "[ ";
		for (int i = 0; i < numVar; i++) {
			s += total[i] + " ";
		}
		s += "]";

		return s;

	}

	// Mínimo de chamadas da função objetiva
	public static int getMinEvaluations(List<Result> l) {
		double min = Double.POSITIVE_INFINITY;

		for (Result r : l) {
			if (r.getEvaluations() < min) {
				min = r.getEvaluations();
			}
		}

		return (int) min;

	}

	// Máximo de chamadas da função objetiva
	public static int getMaxEvaluations(List<Result> l) {
		double max = Double.NEGATIVE_INFINITY;

		for (Result r : l) {
			if (r.getEvaluations() > max) {
				max = r.getEvaluations();
			}
		}

		return (int) max;

	}

	// Mínimo de tempo de execução
	public static long getMinTime(List<Result> l) {
		double min = Double.POSITIVE_INFINITY;

		for (Result r : l) {
			if (r.getTime() < min) {
				min = r.getTime();
			}
		}

		return (long) min;

	}

	// Máximo de tempo de execução
	public static long getMaxTime(List<Result> l) {
		double max = Double.NEGATIVE_INFINITY;

		for (Result r : l) {
			if (r.getTime() > max) {
				max = r.getTime();
			}
		}

		return (long) max;

	}

	// Mínimo de ótimos
	public static double getMinFitness(List<Result> l) {
		double min = Double.POSITIVE_INFINITY;

		for (Result r : l) {
			if (r.getFitness() < min) {
				min = r.getFitness();
			}
		}

		return min;

	}

	// Máximo de ótimos
	public static double getMaxFitness(List<Result> l) {
		double max = Double.NEGATIVE_INFINITY;

		for (Result r : l) {
			if (r.getFitness() > max) {
				max = r.getFitness();
			}
		}

		return max;

	}

	// Desvio padrão das avaliações
	public static double getSDEvaluations(List<Result> l) {
		double p1 = 1 / Double.valueOf(l.size() - 1);
		double p2 = 0;
		double p3 = 0;

		for (Result r : l) {
			p2 += r.getEvaluations();
			p3 += Math.pow(r.getEvaluations(), 2);
		}

		return Math.sqrt((p3 - (Math.pow(p2, 2) / Double.valueOf(l.size()))) * p1);
	}

	// Desvio padrão do tempo
	public static double getSDTime(List<Result> l) {
		double p1 = 1 / Double.valueOf(l.size() - 1);
		double p2 = 0;
		double p3 = 0;

		for (Result r : l) {
			p2 += r.getTime();
			p3 += Math.pow(r.getTime(), 2);
		}

		return Math.sqrt((p3 - (Math.pow(p2, 2) / Double.valueOf(l.size()))) * p1);
	}

	// Desvio padrão do ótimos (valores)
	public static double getSDFitness(List<Result> l) {
		double p1 = 1 / Double.valueOf(l.size() - 1);
		double p2 = 0;
		double p3 = 0;

		for (Result r : l) {
			p2 += r.getFitness();
			p3 += Math.pow(r.getFitness(), 2);
		}

		return Math.sqrt((p3 - (Math.pow(p2, 2) / Double.valueOf(l.size()))) * p1);
	}

}
