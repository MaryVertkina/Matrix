package edu.spbu.cs;

/**
 * Created by Маша on 05.10.2016.
 */
public interface IMatrix {
    IMatrix add(IMatrix o);
    IMatrix multiply(IMatrix o);
    String toString();
}
