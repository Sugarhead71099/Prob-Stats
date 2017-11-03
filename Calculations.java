import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

public class Calculations {
	
	private static List<List<Integer>> arraysOfValues = new ArrayList<List<Integer>>();
	private static List<Double> differenceFromMean = new ArrayList<Double>(), differenceValuesSquared = new ArrayList<Double>();
	
	public Calculations() {}
	
	public Calculations(@SuppressWarnings("unchecked") List<List<Integer>>...arrays) {
		for(List<List<Integer>> arrs : arrays)
			for(List<Integer> arrValues : arrs)
				arraysOfValues.add(arrValues);
		sortArrays();
	}
	
	public void sortArrays() {
		Collections.sort(arraysOfValues, new Comparator<List<Integer>>(){
			public int compare(List<Integer> array1, List<Integer> array2) {
				return Integer.valueOf(array1.size()).compareTo(array2.size());
			}
		});
		
		for(List<Integer> arrays : arraysOfValues)
			sortArray(arrays);
	}
	
	public void sortArray(List<Integer> unsortedArr) {
		Collections.sort(unsortedArr);
	}
	
	public static List<List<Integer>> getArray() {
		return arraysOfValues;
	}
	
	public double size(List<Integer> array) {
		return array.size();
	}
	
	public int minimum(List<Integer> array) {
		if(array != null)
			return array.get(0);
		return -1;
	}
	
	public double firstQuartile(List<Integer> array) {
		if(array != null) {
			int median = (array.size() / 2) - 1;
			return median % 2 == 0 ? (double) array.get(median / 2) : (double) ((array.get(median / 2) + array.get((median / 2) + 1)) / 2);
		}
		return -1;
	}
	
	public double median(List<Integer> array) {
		if(array != null)
			return array.size() % 2 == 0 ? ((array.get(array.size() / 2) + array.get((array.size() / 2) - 1)) / 2) : array.get(array.size() / 2);
		return -1;
	}
	
	public double thirdQuartile(List<Integer> array) {
		if(array != null) {
			int median = (array.size() / 2);
			if(median % 2 == 0)
				return array.size() % 2 == 0 ? ((array.get(median + ((array.size() - median) / 2)) + array.get((median + ((array.size() - median) / 2)) - 1)) / 2) : ((array.get(median + ((array.size() - median) / 2)) + array.get((median + ((array.size() - median) / 2)) + 1)) / 2);
			return array.get((array.size() - median) + 1);
		}
		return -1;
	}
	
	public int maximum(List<Integer> array) {
		if(array != null)
			return array.get(array.size() - 1);
		return -1;
	}
	
	public double sum(List<Integer> array) {
		int sum = 0;
		for(Integer values : array)
			sum += values;
		return sum;
	}
	
	public double mean(List<Integer> array) {
		if(array != null)
			return Math.round((sum(array) / size(array)) * 100) / 100;
		return -1;
	}
	
	public int mode(List<Integer> array) {
		if(array != null) {
			Map<Integer,Integer> hM = new HashMap<Integer,Integer>();
		    int max = 1, temp = 0;
		    for(int i = 0; i < array.size() ; i++)
		    	if(hM.get(array.get(i)) != null) {
		    		int count = hM.get(array.get(i));
		            count++;
		            hM.put(array.get(i), count);
		            if(count > max) {
		            	max = count;
		                temp = array.get(i);
		            }
		        } else
		        	hM.put(array.get(i), 1);
	        return temp == 0 ? -1 : temp;
		}
		return -1;
	}
	
	public double lowerFence(List<Integer> array) {
		return firstQuartile(array) - (1.5 * interQuartileRange(array));
	}
	
	public double upperFence(List<Integer> array) {
		return thirdQuartile(array) + (1.5 * interQuartileRange(array));
	}
	
	public double interQuartileRange(List<Integer> array) {
		return thirdQuartile(array) - firstQuartile(array);
	}
	
	public boolean outliers(List<Integer> array) {
		for(Integer values : array)
			if(values < lowerFence(array) || values > upperFence(array))
				return true;
		return false;
	}
	
	public double variance(List<Integer> array) {
		differenceFromMean.removeAll(differenceFromMean);
		differenceValuesSquared.removeAll(differenceValuesSquared);
		if(array != null) {
			double mean = mean(array);
			for(Integer i : array)
				differenceFromMean.add(i - mean);
			for(Double j : differenceFromMean)
				differenceValuesSquared.add(Math.pow(j, 2));
			double variance = 0;
			for(Double k : differenceValuesSquared)
				variance += k;
			return Math.round((variance / (array.size() - 1)) * 100.0) / 100.0;
		}
		return -1;
	}
	
	public double standardDeviation(List<Integer> array) {
		return Math.round((Math.sqrt(variance(array))) * 100.0) / 100.0;
	}
	
	public String getDiffereneceFromMean() {
		StringBuilder differenceValues = new StringBuilder();
		for(Double values : differenceFromMean)
			if(values != differenceFromMean.get(differenceFromMean.size() - 1))
				differenceValues.append(Math.round(values * 100) / 100).append(", ");
			else
				differenceValues.append(Math.round(values * 100) / 100);
		return differenceValues.toString();
	}
	
	public String getDifferenceValuesSquared() {
		StringBuilder differenceValuesSquared = new StringBuilder();
		int counter = 0;
		for(Double values : Calculations.differenceValuesSquared)
			if(counter != Calculations.differenceValuesSquared.size() - 1)
				differenceValuesSquared.append(Double.toString(values)).append(", ");
			else
				differenceValuesSquared.append(Double.toString(values));
		return differenceValuesSquared.toString();
	}
	
}
