package com.app.matriceProcessor;

import com.app.model.MatrixData;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ParallelMatrixProcessor extends AbstractMatrixProcessor {

    private int[][] result;
    private CountDownLatch processExecutorLatch;
    private MatrixData matrixData;

    public int[][] process(MatrixData matrixData) {
        this.matrixData = matrixData;
        result = new int[matrixData.getRange()][matrixData.getRange()];

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        processExecutorLatch = new CountDownLatch(matrixData.getRange());

        IntStream.range(0, matrixData.getRange()).forEach(i -> executorService.execute(() -> processAsync(i)));

        try {
            processExecutorLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void processAsync(int indexToProcess) {
        int sum;
        int a;
        for (a = 0; a < matrixData.getRange(); a++) {
            sum = 0;
            for (int b = 0; b < matrixData.getRange(); b++) {
                sum = sum + matrixData.getMatrix1()[indexToProcess][b] * matrixData.getMatrix2()[b][a];
            }
            result[indexToProcess][a] = sum;
        }

        processExecutorLatch.countDown();
    }
}