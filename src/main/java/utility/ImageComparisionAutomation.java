package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparisionAutomation {

	public static void compareTwoFileAreSame(String actualImagePathWithImgExt, String expectedImagePathWithImgExt)
			throws IOException {

		// e.g for file path: //C:\\Users\\Kunal Satao\\OneDrive\\Documents\\Demo\\edeXa//pic\\News\\07.png

			// Assigns the provided image paths to local variables.
				String expectedImagePath = expectedImagePathWithImgExt;
				String actualImagePath = actualImagePathWithImgExt;
		
			// Initializes File objects for the expected and actual image files using the provided paths
				File expectedImageFile = new File(expectedImagePath);
				File actualImageFile = new File(actualImagePath);
		
			// Uses ImageIO.read to read the images from the file paths into BufferedImage objects.
				BufferedImage expectedImage = ImageIO.read(expectedImageFile);
				BufferedImage actualImage = ImageIO.read(actualImageFile);
		
			// Creates an instance of ImageDiffer (assumed to be from a library for image comparison).
			// Calls makeDiff on the ImageDiffer object to compare the two images, returning an ImageDiff object.
				ImageDiffer imgDiff = new ImageDiffer();
				ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
		
				if (diff.hasDiff()) {
					System.out.println("Images are NOT same");
				} else {
					System.out.println("Images are same");
				}

	}

}