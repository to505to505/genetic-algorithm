package src.TestsVisualisation;

public class BestParams {
    String target = "HELLO WORLD";
    int maxGenerations = 10000;
    double mutationRate = 0.03;
    int popSize = 100;
    int tournamentSize = 5;
    boolean crossover = true;

    public BestParams(String target, int maxGenerations, double mutationRate, int popSize, int tournamentSize, boolean crossover) {
        this.target = target;
        this.maxGenerations = maxGenerations;
        this.mutationRate = mutationRate;
        this.popSize = popSize;
        this.tournamentSize = tournamentSize;
        this.crossover = crossover;
    }
}
