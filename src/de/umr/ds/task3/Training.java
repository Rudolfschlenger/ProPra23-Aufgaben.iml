package de.umr.ds.task3;

import java.util.Collections;

import static de.umr.ds.task3.Evaluation.accuracy;

public class Training {

	private static final double alpha = 0.05; // learning rate
	private static final int epochs = 100; // number of epochs

	/**
	 * A perceptron is trained on a dataset. After each epoch the perceptron's
	 * parameters are updated, the dataset is shuffled and the accuracy is computed.
	 * 
	 * @param perceptron the perceptron to train
	 * @param dataset the training dataset
	 */
	private static void train(Perceptron perceptron, Dataset dataset) {

		Visualization visualization = new Visualization(dataset, perceptron.weightVector, perceptron.bias);
		double currentAccuracy = 0;

		for (int i = 1; i <= epochs; i++) {
			for (int j = 0; j < dataset.size(); j++) {
				DataPoint data = dataset.get(j);
				Vector changendVector = data.mult(alpha * (data.getLabel() - perceptron.predict(data)));

				//Changes perceptron
				perceptron.bias = perceptron.bias + (alpha * (data.getLabel() - perceptron.predict(data)));
				perceptron.weightVector = perceptron.weightVector.add(changendVector);
			}

			//Updating visualization

			System.out.println("Epoch " + i + " accuracy: " + accuracy(perceptron, dataset));

			if (accuracy(perceptron, dataset) > currentAccuracy) {
				currentAccuracy = accuracy(perceptron, dataset);
				visualization.update(perceptron.weightVector, perceptron.bias, i);
			}
			if (accuracy(perceptron, dataset) == 1.0) {
				break;
			}

			Collections.shuffle(dataset);
		}
	}

	public static void main(String[] args) {

		Dataset dataset = new Dataset(1000);
		Perceptron perceptron = new Perceptron();
		train(perceptron, dataset);

	}

}
