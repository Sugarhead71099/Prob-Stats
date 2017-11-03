import java.util.List;

public class DisplayCalculations extends Calculations {
	
	private String outliers;
	private int minimum, maximum, mode;
	private double size, firstQuartile, median, thirdQuartile, sum, mean, lowerFence, upperFence, interQuartileRange, variance, standardDeviation;
	
	public DisplayCalculations() {
		for(List<Integer> arrays : getArray()) {
			size = size(arrays);
			minimum = minimum(arrays);
			firstQuartile = firstQuartile(arrays);
			median = median(arrays);
			thirdQuartile = thirdQuartile(arrays);
			maximum = maximum(arrays);
			sum = sum(arrays);
			mean = mean(arrays);
			mode = mode(arrays);
			lowerFence = lowerFence(arrays);
			upperFence = upperFence(arrays);
			interQuartileRange = interQuartileRange(arrays);
			outliers = outliers(arrays) ? "yes" : "no";
			variance = variance(arrays);
			standardDeviation = standardDeviation(arrays);
			displayArrayContents();
		}
	}
	
	public void displayArrayContents() {
		System.out.println("");
		System.out.println("SIZE:\t\t" + size);
		System.out.println("MINIMUM:\t" + minimum);
		System.out.println("FIRST QUARTILE:\t" + firstQuartile);
		System.out.println("MEDIAN:\t\t" + median);
		System.out.println("THIRD QUARTILE:\t" + thirdQuartile);
		System.out.println("MAXIMUM:\t" + maximum);
		System.out.println("SUM:\t\t" + sum);
		System.out.println("MEAN:\t\t" + mean);
		if(mode != -9999)
			System.out.println("MODE:\t\t" + mode);
		System.out.println("LOWER FENCE:\t" + lowerFence);
		System.out.println("UPPER FENCE:\t" + upperFence);
		System.out.println("INTER QUARTILE RANGE:\t" + interQuartileRange);
		System.out.println("OUTLIERS:\t" + outliers);
		System.out.println("VARIANCE:\t" + variance);
		System.out.println("STANDARD DEVIATION:\t" + standardDeviation);
		System.out.println("");
		System.out.println("DIFFERENCE FROM MEAN:\n\t" + getDiffereneceFromMean());
		System.out.println("DIFFERENCE VALUES SQUARED:\n\t" + getDifferenceValuesSquared());
		System.out.println("");
	}
	
}
