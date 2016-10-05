import edu.spbu.cs.DenseMatrix;
import edu.spbu.cs.IMatrix;
import edu.spbu.cs.SparseMatrix;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Пример программы на Java
 *
 */
// назавние главного класса, обычно совпадает с названием программы

public class Matrix {
    public static void main (String args[]) {
        mulDenseDense();
        mulSparseSparse();
        mulDenseSparce();
        mulSparceDense();
    }

    private static void mulDenseDense() {
        IMatrix m1 = new DenseMatrix("inD1.txt");
        IMatrix m2 = new DenseMatrix("inD2.txt");

        IMatrix res = m1.multiply(m2);

        PrintWriter out = null;
        try {
            out = new PrintWriter("outDD.txt");
            out.print(res.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static void mulSparseSparse() {
        IMatrix m1 = new SparseMatrix("inS1.txt");
        IMatrix m2 = new SparseMatrix("inS2.txt");

        IMatrix res = m1.multiply(m2);

        PrintWriter out = null;
        try {
            out = new PrintWriter("outSS.txt");
            out.print(res.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static void mulDenseSparce() {
        IMatrix m1 = new SparseMatrix("inD1.txt");
        IMatrix m2 = new SparseMatrix("inS2.txt");

        IMatrix res = m1.multiply(m2);

        PrintWriter out = null;
        try {
            out = new PrintWriter("outDS.txt");
            out.print(res.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static void mulSparceDense() {
        IMatrix m1 = new SparseMatrix("inS1.txt");
        IMatrix m2 = new SparseMatrix("inD2.txt");

        IMatrix res = m1.multiply(m2);

        PrintWriter out = null;
        try {
            out = new PrintWriter("outSD.txt");
            out.print(res.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
