package src.Algorithm;
import java.util.Random;




public class PracticalGA {

	private final String TARGET = "HELLO WORLD";
	private  final int maxGenerations = 10000;
	private  final double mutationRate = 0.05;
	private final int popSize = 100;	
	private final int tournamentSize = 5;
	private final boolean Crossover = true;



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PracticalGA ga = new PracticalGA();
		ga.RunAlgorithm("HELLO WORLD", 1000, 0.02, 200, 5, true);

	}

	public int RunAlgorithm(String TARGET, int maxGenerations, double mutationRate, int popSize, int tournamentSize, boolean Crossover) {

		init();
		
		int generationNumber = 0;
		Individual[] population = new Individual[popSize];
		
		// we initialize the population with random characters
		for (int i = 0; i < popSize; i++) {
			
			char[] chromosome = Generate.generateChromosome();
			population[i] = new Individual(chromosome);

			
		}

		for (int generation = 0; generation < maxGenerations; generation++) {
			// Calculate fitness for each individual
			for (Individual individual : population) {
			
				individual.calculateFitness(TARGET.toCharArray());
				
			}

		// Sort population by fitness
			
			HeapSort.sort(population);
	
			System.out.println("Generation: " + generation + " Best individual: " + population[0].genoToPhenotype()  );
		
		// Check if we have found a solution
		if (population[0].getFitness() == TARGET.length()) {
			System.out.println("Solution found on generation " + generation  );
			System.out.println("Best individual: " + population[0].genoToPhenotype());
			break;
		}

		// Selection and reproduction
		Individual[] newPopulation = new Individual[popSize];
		for (int i = 0; i < popSize; i++) {
			Individual parent1 = tournamentSelection(population, tournamentSize);
			Individual parent2 = tournamentSelection(population,tournamentSize );
			Individual offspring = null;
			if(Crossover == true) { 
				offspring = crossover(parent1, parent2);
			}
			 else {
				offspring = new Individual();
				offspring = parent1.clone();
                offspring.mutate(mutationRate);
			 }
			offspring.mutate(mutationRate);

			newPopulation[i] = offspring;

		}

		population = newPopulation;

		generationNumber = generation;
		}
		return generationNumber;
	}

	

	public static void init() {
        Generate.initAlphabet();
    }



	public static Individual tournamentSelection(Individual[] population, int tournamentSize) {
        Random rand = new Random();
        Individual best = null;
        for (int i = 0; i < tournamentSize; i++) {
            Individual candidate = population[rand.nextInt(population.length)];
            if (best == null || candidate.getFitness() > best.getFitness()) {
                best = candidate;
            }
        }
        return best;
    }

	public static Individual crossover(Individual parent1, Individual parent2) {
   
        Individual offspring = new Individual();
        Random rand = new Random();
        int crossoverPoint = rand.nextInt(10);

        for (int i = 0; i < 11; i++) {
            if (i < crossoverPoint) {
                offspring.setChromosome(i, parent1.getChromosome(i));
				
            } else {
                offspring.setChromosome(i, parent2.getChromosome(i));
            }
        }
        return offspring;
    }


}
