package edu.spbu.cs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Маша on 05.10.2016.
 */

public class DenseMatrix implements IMatrix {
    private int matrix[][];

    public DenseMatrix(String inFileName) {
        Scanner in = null;
        try {
            in = new Scanner(new File(inFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size = in.nextInt();
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
    }

    private DenseMatrix(int size) {
        matrix = new int[size][size];
    }


    @Override
    public IMatrix add(IMatrix o) {
        return null;
    }

    @Override
    public IMatrix multiply(IMatrix o) {
        int size = matrix.length;
        DenseMatrix res = new DenseMatrix(size);
        transponation(o.getMatrix());
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    res.matrix[i][j] = res.matrix[i][j] + this.matrix[i][k] * o.getMatrix()[j][k];
                }
            }
        }
        return res;
    }

    @Override
    public int[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                res.append(matrix[i][j] + "  ");
            }
            res.append("\n");
        }

        return res.toString();
    }

    private void transponation(int[][] m){
        for (int i = 0; i < m.length - 1; i++) {
            for (int j = i + 1; j < m.length; j++) {
                int b = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = b;
            }
        }
    }
}
