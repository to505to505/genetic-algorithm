package src.TestsVisualisation;

import src.Algorithm.PracticalGA;

public class Test {
    public static TestData runPopulationSizeTests() {
        
        String target = "HELLO WORLD";
        int maxGenerations = 10000;
        double mutationRate = 0.03;
        double[] popSizes = {50, 100, 200, 500, 1000}; 
        int tournamentSize = 5;
        boolean crossover = true;

        double[] results = new double[popSizes.length];
        
        for (int i=0; i<popSizes.length; i++) {
            double result = runAverageTest(target, maxGenerations, mutationRate, (int) popSizes[i], tournamentSize, crossover);
            results[i] = result;
            
           
        }
        TestData data = new TestData(popSizes, results);
        return data;
    }
    public static TestData runMutationSizeTests() {
        
        String target = "HELLO WORLD";
        int maxGenerations = 10000;
        double[] mutationRates = { 0.01, 0.03, 0.05, 0.1, 0.2};
        int popSize = 1000;
        int tournamentSize = 5;
        boolean crossover = true;

        double[] results = new double[mutationRates.length];
        
        
        for (int j =0; j<mutationRates.length; j++) {
            
            double result = runAverageTest(target, maxGenerations, mutationRates[j], popSize, tournamentSize, crossover);
            results[j] = result;
            
           
        }
        TestData data = new TestData(mutationRates, results);

        return data;
    }
    public static double[] runCrossoverTest() {
        
        String target = "HELLO WORLD";
        int maxGenerations = 10000;
        double mutationRate = 0.075;
        int popSize = 100;
        int tournamentSize = 5;
        boolean[] crossover = {true, false};

        double[] results = new double[2];
        
        
        for (int j =0; j<2; j++) {
            
            double result = runAverageTest(target, maxGenerations, mutationRate, popSize, tournamentSize, crossover[j]);
            results[j] = result;
            
           
        }
        
        return results;
    }
    
    public static double runAverageTest(String target, int maxGenerations, double mutationRate, int popSize, int tournamentSize, boolean crossover) {
        int runs = 30;
        int sum = 0;
        int[] generationsArray = new int[runs];
        for (int i = 0; i < runs; i++) {
            PracticalGA ga = new PracticalGA();
            int generations = ga.RunAlgorithm(target, maxGenerations, mutationRate, popSize, tournamentSize, crossover);
            sum = sum + generations;

        }
        return sum/30;
    }

    public static void findOptimalParameters() {
        
        String target = "HELLO WORLD";
        int maxGenerations = 10000;
        double[] mutationRates = {0.01, 0.03, 0.05, 0.1, 0.2};
        double[] popSizes = {50, 100,200,  500, 1000};
        int tournamentSize = 5;
        boolean crossover = true;

      
        
        double bestRes = 1000;
        BestParams bestParams = null;
        for (double mutationRate  : mutationRates) {
            for (double popSize : popSizes) {
                
               
            
            double result = runAverageTest(target, maxGenerations, mutationRate, (int) popSize, tournamentSize, crossover);
            if (result < bestRes) {
                bestRes = result;
                bestParams = new BestParams(target, maxGenerations, mutationRate, (int) popSize, tournamentSize, crossover);
            }
            
           
        }
        System.out.println("Best popsizes: " + bestParams.popSize);
        System.out.println("Best mutation rate: " + bestParams.mutationRate);
        System.out.println("Best result: " + bestRes);
        
        
       
    }
}
}
