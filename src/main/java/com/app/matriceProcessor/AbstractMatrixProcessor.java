package com.app.matriceProcessor;

import com.app.model.MatrixData;

public abstract class AbstractMatrixProcessor implements MatrixProcessor {
    protected abstract int[][] process(MatrixData matrixData);

    public long getTime(MatrixData matrixData) {
        long start = System.currentTimeMillis();

        int [][] result = process(matrixData);

        displayMatrix(result);

        return System.currentTimeMillis() - start;
    }

    private static void displayMatrix(int[][] product) {
        for (int[] row : product) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}