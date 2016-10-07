package edu.spbu.cs;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseMatrix implements IMatrix {
    private Map<Point, Integer> map;
    private int mapSize;

    public SparseMatrix(String inFileName) {
        Scanner in = null;
        try {
            in = new Scanner(new File(inFileName));
            mapSize = in.nextInt();
            map = new HashMap<>();
            int v;
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    v = in.nextInt();
                    if (v != 0) {
                        map.put(new Point(j, i), v);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    private SparseMatrix(Map<Point, Integer> map, int size) {
        this.map = map;
        this.mapSize = size;
    }

    @Override
    public IMatrix multiply(IMatrix o) {
        return (o instanceof DenseMatrix) ? multiplyDense((DenseMatrix) o) : multiplySparse((SparseMatrix) o);
    }

    private IMatrix multiplySparse(SparseMatrix o) {
        Map<Point, Integer> resMatrix = new HashMap<>();
        for (Map.Entry<Point,Integer> e : map.entrySet()){
            Point k = e.getKey();
            int v = e.getValue();
        }
//        int size = Math.max(mapSize, o.getSize());
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                Point coordRes = new Point(j, i);
//                int res = 0;
//                for (int k = 0; k < size; k++) {
//                    Point coord1 = new Point(k, i);
//                    Point coord2 = new Point(j, k);
//                    int v1 = map.get(coord1) != null ? map.get(coord1) : 0;
//                    int v2 = o.getMap().get(coord2) != null ? o.getMap().get(coord2) : 0;
//                    res +=  v1 * v2;
//                }
//                if (res != 0) {
//                    resMatrix.put(coordRes, res);
//                }
//            }
//        }
        return new SparseMatrix(resMatrix, size);
    }

    private IMatrix multiplyDense(DenseMatrix o) {
        Map<Point, Integer> resMatrix = new HashMap<>();
        int size = o.getMatrix().length;
        o.transponation();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Point coordRes = new Point(j, i);
                int res = 0;
                for (int k = 0; k < size; k++) {
                    Point coord1 = new Point(k, i);
                    int v1 = map.get(coord1) != null ? map.get(coord1) : 0;
                    res +=  v1 * o.getMatrix()[j][k];
                }
                if (res != 0) {
                    resMatrix.put(coordRes, res);
                }
            }
        }
        return new SparseMatrix(resMatrix, size);
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                Integer v = map.get(new Point(j, i));
                if (v == null) {
                    v = 0;
                }
                res.append(v + " ");
            }
            res.append("\n");
        }

        return res.toString();
    }

    public int getSize() {
        return mapSize;
    }

    public Map<Point, Integer> getMap() {
        return map;
    }
}
