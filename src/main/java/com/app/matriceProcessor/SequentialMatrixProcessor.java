package com.app.matriceProcessor;

import com.app.model.MatrixData;

public class SequentialMatrixProcessor extends AbstractMatrixProcessor {

    protected int[][] process(MatrixData matrixData) {
        int[][] result = new int[matrixData.getRange()][matrixData.getRange()];

        for(int i = 0; i < matrixData.getRange(); i++) {
            for (int j = 0; j < matrixData.getRange(); j++) {
                for (int k = 0; k < matrixData.getRange(); k++) {
                    result[i][j] += matrixData.getMatrix1()[i][k] * matrixData.getMatrix2()[k][j];
                }
            }
        }

        return result;
    }
}