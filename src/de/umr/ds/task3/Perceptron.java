package de.umr.ds.task3;

/**
 * A Perceptron holds weights and bias and can be applied to a data vector to
 * predict its class. Weights and bias are initialized randomly.
 */
public class Perceptron {

    Vector weightVector;
    double bias;

    public Perceptron() {
        weightVector = new Vector(Math.random(), Math.random());
        this.bias = Math.random();
    }

    /**
     * Apply the perceptron to classify a data vector.
     *
     * @param x An input vector
     * @return 0 or 1
     */
    public int predict(Vector x) {

        return weightVector.dot(x) + bias > 0 ? 1 : 0;
    }
}
