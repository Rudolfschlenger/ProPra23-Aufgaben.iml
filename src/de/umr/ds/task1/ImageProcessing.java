package de.umr.ds.task1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessing {

	/**
	 * Loads an image from the given file path
	 *
	 * @param path The path to load the image from
	 * @return BufferedImage
	 */
	private static BufferedImage loadImage(String path) throws IOException {

		// TODO Task 1a)
		try {
			return ImageIO.read(new File(path));
		}
		catch (IOException e) {
			throw new IOException("Path not available!");
		}

	}


	/**
	 * Converts the input RGB image to a single-channel gray scale array.
	 * 
	 * @param img The input RGB image
	 * @return A 2-D array with intensities
	 */
	private static int[][] convertToGrayScaleArray(BufferedImage img) {
		
		// TODO Task 1b)
		int[][] grayArray = new int[img.getWidth()][img.getHeight()];

		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				Color rgb = new Color(img.getRGB(i, j));

				int r = rgb.getRed();
				int g = rgb.getGreen();
				int b = rgb.getBlue();
				int grayPixle = (int) ((int) 0.299 * r + 0.587 * g + 0.114 * b);

				grayArray[i][j] = grayPixle;
			}
		}
		
		return grayArray;
	}

	/**
	 * Converts a single-channel (gray scale) array to an RGB image.
	 * 
	 * @param img The input image array
	 * @return BufferedImage
	 */
	private static BufferedImage convertToBufferedImage(int[][] img) {
		
		// TODO Task 1c)
		
		return null;
	}

	/**
	 * Saves an image to the given file path
	 *
	 * @param img The RGB image
	 * @param path The path to save the image to
	 */
	private static void saveImage(BufferedImage img, String path) throws IOException {

		// TODO Task 1c)
	}

	/**
	 * Converts input image to gray scale and applies the kernel.
	 * 
	 * @param img The RGB input image
	 * @param kernel The kernel to apply
	 * @return The convolved gray-scale image
	 */
	private static BufferedImage filter(BufferedImage img, Kernel kernel) {

		// TODO Task 1f)

		return null;
	}


	// TODO Task 1g)


	public static void main(String[] args) throws IOException {

		// TODO
		System.out.println(loadImage("C:\\Users\\Rudolf\\Downloads\\ProPra23_Verteilte_Systeme_Code\\example.jpg"));

	}

}
