package com.app;

import com.app.exception.InvalidMatrixConfigurationException;
import com.app.matriceProcessor.MatrixProcessor;
import com.app.matriceProcessor.ParallelMatrixProcessor;
import com.app.model.MatrixData;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new ResultOutput().process(args);
    }
}