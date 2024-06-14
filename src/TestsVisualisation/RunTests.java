package src.TestsVisualisation;
import src.Algorithm.PracticalGA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class RunTests {

    public static void main(String[] args) {

        TestData populationData = Test.runPopulationSizeTests();


        List<Double> xData = Arrays.stream(populationData.parameter)
        .boxed()
        .collect(Collectors.toList());

        List<Double> yData = Arrays.stream(populationData.results)
        .boxed()
        .collect(Collectors.toList());


        
        TestData mutationData = Test.runMutationSizeTests();

        
        List<Double> xData1 = Arrays.stream(mutationData.parameter)
        .boxed()
        .collect(Collectors.toList());

        List<Double> yData1 = Arrays.stream(mutationData.results)
        .boxed()
        .collect(Collectors.toList());
        

        
        System.out.println(xData);
        System.out.println(yData);


        System.out.println(xData1);
        System.out.println(yData1);


        double[] result = Test.runCrossoverTest();

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    

        Test.findOptimalParameters();
    }
}
