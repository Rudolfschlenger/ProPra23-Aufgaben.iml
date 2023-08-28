package de.umr.ds.task3;

public class Evaluation {

	/**
	 * Applies the model to each data vector in the dataset and computes the
	 * accuracy.
	 * 
	 * @return accuracy
	 */
	public static double accuracy(Perceptron model, Dataset dataset) {
		
		double correct = 0;

		for (int i = 0; i < dataset.size(); i++) {
			if (model.predict(dataset.get(i)) == dataset.get(i).getLabel()) {
				correct++;
			}
		}
		
		return correct / dataset.size();
	}

}
