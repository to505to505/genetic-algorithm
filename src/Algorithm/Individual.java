package src.Algorithm;
import java.util.Random;

public class Individual {
	
	char[] chromosome;
	double fitness;
	static final String TARGET = "HELLO WORLD";
	
	public Individual(char[] chromosome) {
		this.chromosome = chromosome;
		this.fitness = 0;
	}

	public Individual() {
		this.chromosome = Generate.generateChromosome();
		this.fitness = 0;
	}


	public void calculateFitness(char[] target) {
		
        double score = 0;
        for (int i = 0; i < this.chromosome.length; i++) {
            if (this.chromosome[i] == target[i]) {
                score++;
            }
        }
		this.fitness = score;
    }
	


	public char getChromosome(int i) {
		return chromosome[i];
	}

	public void setChromosome(int i, char chromosome) {
		this.chromosome[i] =  chromosome;
	}

	public double getFitness() {
		
		return this.fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	
	public String genoToPhenotype() {
		StringBuilder builder = new StringBuilder();
		builder.append(chromosome);
		return builder.toString();
	}
	

	public void mutate(double mutationRate) {
        Random rand = new Random();
		
        for (int j = 0; j < 11; j++) {
			if (rand.nextDouble() < mutationRate) {
				chromosome[j] = Generate.generateChar();
		}
		
        }
	}
		
	public Individual clone() {
		char[] chromClone = new char[chromosome.length];
		for(int i = 0; i < chromClone.length; i++) {
			chromClone[i] = chromosome[i];
		}
		return new Individual(chromClone);
	}
	



	
}
