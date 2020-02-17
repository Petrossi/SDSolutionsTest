package com.app.model;

import com.app.exception.InvalidMatrixConfigurationException;

public class MatrixData {
    private int range;

    private int [][] matrix1;
    private int [][] matrix2;

    private MatrixData() { }

    public int getRange() {
        return range;
    }

    public int[][] getMatrix1() {
        return matrix1;
    }

    public void setMatrix1(int[][] matrix1) {
        this.matrix1 = matrix1;
    }

    public int[][] getMatrix2() {
        return matrix2;
    }

    public void setMatrix2(int[][] matrix2) {
        this.matrix2 = matrix2;
    }

    public static Builder newBuilder() {
        return new MatrixData().new Builder();
    }

    public class Builder {
        private Builder() { }

        public Builder setRange(int range) {
            MatrixData.this.range = range;

            return this;
        }

        public MatrixData build() throws InvalidMatrixConfigurationException {

            validate();

            matrix1 = createMatrix();
            matrix2 = createMatrix();

            return MatrixData.this;
        }

        private int [][] createMatrix(){

            int [][] data = new int [range] [range];

            for (int i=0; i<data.length; i++) {
                for (int j=0; j<data[i].length; j++) {
                    data[i][j] = (int) (Math.random()*10);
                }
            }

            return data;
        }

        private void validate() throws InvalidMatrixConfigurationException {
            if(MatrixData.this.range == 0){
                throw new InvalidMatrixConfigurationException("xRange is not defined");
            }
        }
    }
}