import edu.spbu.cs.DenseMatrix;
import edu.spbu.cs.IMatrix;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Пример программы на Java
 *
 */
// назавние главного класса, обычно совпадает с названием программы

public class Matrix {
    public static void main (String args[]) {
        IMatrix m1 = new DenseMatrix("in1.txt");
        IMatrix m2 = new DenseMatrix("in2.txt");

        IMatrix res = m1.multiply(m2);

        PrintWriter out = null;
        try {
            out = new PrintWriter("out.txt");
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
