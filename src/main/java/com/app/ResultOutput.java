package com.app;

import com.app.exception.InvalidMatrixConfigurationException;
import com.app.matriceProcessor.MatrixProcessor;
import com.app.matriceProcessor.ParallelMatrixProcessor;
import com.app.model.MatrixData;

import java.util.Arrays;
import java.util.List;

public class ResultOutput {
    public void process(String[] args){
        List<String> arguments = Arrays.asList(args);

        if(arguments.isEmpty()){
            System.err.println("range is not defined");
            System.exit(0);
        }

        String rangeArgument = arguments.get(0);

        int range = 0;
        try{
            range = Integer.parseInt(rangeArgument);
        }catch (NumberFormatException e){
            System.err.println("range is not valid: " + rangeArgument);
            System.exit(0);
        }

        MatrixData matrixData = null;
        try {
            matrixData = MatrixData.newBuilder().setRange(range).build();
        } catch (InvalidMatrixConfigurationException e) {
            System.out.println("failed to create matrix: " + e.getMessage());
            System.exit(0);
        }

        MatrixProcessor sequentialMatrixProcessor = new ParallelMatrixProcessor();
        ParallelMatrixProcessor parallelMatrixProcessor = new ParallelMatrixProcessor();

        long sequentialMatrixProcessorTime = sequentialMatrixProcessor.getTime(matrixData);

        System.out.println("sequential time: " + sequentialMatrixProcessorTime);

        long parallelMatrixProcessorTime = parallelMatrixProcessor.getTime(matrixData);

        System.out.println("parallel time: " + parallelMatrixProcessorTime);
    }
}
