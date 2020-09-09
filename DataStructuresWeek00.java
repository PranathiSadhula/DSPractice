package datastructures.week00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataStructuresWeek00 {
	public static void main(String[] args) {
		List<Integer> givenList = new ArrayList<Integer>();
		givenList.add(0);
		givenList.add(10);
		givenList.add(11);
		givenList.add(0);
		givenList.add(2);
		givenList.add(4);
		givenList.add(0);
		givenList.add(0);
		givenList.add(0);
		givenList.add(0);
		givenList.add(2);
		givenList.add(4);
		givenList.add(10);
		givenList.add(12);
		// System.out.println(givenList);
		p005_01_peakElement();

	}

	public static void P001_maxProduct(List<Integer> list) {
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);
		System.out.println("max Product :" + list.get(0) * list.get(1));
	}

	public static void P002_removeElementAddAtTheEnd(List<Integer> list) {
		int count = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) == 0 && count != Collections.frequency(list, 0)) {
				list.remove(i);
				count++;
				list.add(0);
				if (i > 0) {
					i--;
				}
			}
		}
	}

	public static void p003_longestIncreasingSequence() {
		/*
		 * array = [12,3,4,5,7,8,2,10,11,14,18,9,3,2,1,6,90,20] longest increasing
		 * subsequence ==> 3,4,5,7,8 2,10,11,14,18 ===> from these 3 subsequences
		 * longest among them is 2,10,11,14,18 1,6,90,20
		 */
		Integer[] array = { 12, 3, 4, 5, 7, 8, 2, 10, 11, 14, 18, 19, 3, 2, 1, 6, 90, 20 };
		List<Integer> longestSeq = new ArrayList<Integer>();
		List<Integer> finalSeq = new ArrayList<Integer>();
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] < array[i + 1]) {
				longestSeq.add(array[i]);
			} else {
				if (i != 0 && array[i] > array[i - 1]) {
					longestSeq.add(array[i]);
				}
				if (finalSeq.size() < longestSeq.size()) {
					finalSeq = new ArrayList<Integer>();
					finalSeq.addAll(longestSeq);
				}
				longestSeq = new ArrayList<Integer>();
			}

		}
		System.out.println(finalSeq);

	}

	public static void P004_00_duplicateElement(List<Integer> list) {

		int lastIndex = list.size();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < lastIndex; i++) {
			int currElement = list.get(i);

			List<Integer> subList = list.subList(i + 1, lastIndex);
			if (subList.indexOf(currElement) != -1) {
				set.add(currElement);
			}

		}
		System.out.println(set);
	}

	public static void P004_01_duplicateElement(List<Integer> list) {
		int lastIndex = list.size();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < lastIndex; i++) {
			if (Collections.frequency(list, list.get(i)) > 1) {
				set.add(list.get(i));
			}

		}
		System.out.println(set);

	}

	public static void P004_02_duplicateElement(List<Integer> list) {
		int lastIndex = list.size();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < lastIndex; i++) {
			if (map.containsKey(list.get(i))) {
				map.put(list.get(i), map.get(list.get(i)) + 1);
			} else {
				map.put(list.get(i), 1);
			}

		}

		System.out.println(map);

	}

	public static void p005_peakElement() {
		Integer[] array = { 12, 3, 4, 5, 7, 8, 2, 10, 11, 14, 18, 19, 3, 2, 1, 6, 90, 20 };

		List<Integer> list = Arrays.asList(array);
		/*
		 * List<Integer> sortedList = new ArrayList<Integer>() ;
		 * sortedList.addAll(list);
		 * 
		 * Collections.sort(sortedList); Collections.reverse(sortedList);
		 * System.out.println(list); System.out.println(sortedList);
		 */
		System.out.println(list);
		List<Integer> peakList = new ArrayList<Integer>();
		int index = 0;
		int lastIndex = list.size() - 1;
		while (lastIndex > index) {

			if (index == 0) {
				if (list.get(index) > list.get(index + 1)) {
					peakList.add(list.get(index));
				}
			} else if (index == lastIndex) {
				if (list.get(index) > list.get(index - 1)) {
					peakList.add(list.get(index));
				}
			} else {
				if (list.get(index) > list.get(index - 1) && list.get(index) > list.get(index + 1)) {
					peakList.add(list.get(index));
				}
			}

			if (index < lastIndex) {
				index++;
			} else
				break;

		}

		System.out.println(peakList);

	}

	public static void p005_01_peakElement() {
		/*
		 * given an array = [12,3,4,5,7,8,2,10,11,14,18,9,3,2,1,6,90,20]
			sortedList = 90,20,19,18,14,12,11,10,8,7,6,5,4,3,3,2,2,1
			> Sort given array and store in new list
			> iterate through given array and find index of sortedList.get(0) in givenArray
			> if givenArray[i] < givenArray[index of sortedList.get(0) ] < givenArray[i] ==> then givenArray[index of sortedList.get(0) ] is peak element
		 */
		Integer[] array = { 12, 3, 4, 5, 7, 8, 2, 10, 11, 14, 18, 19, 3, 2, 1, 6, 90, 20 };
		
		List<Integer> list = Arrays.asList(array);
		int peakElement = 0;
		List<Integer> peakElementList = new ArrayList<Integer>();
		List<Integer> sortedList = new ArrayList<Integer>();
		sortedList.addAll(list);
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		for(int i = 1; i < list.size()-1; i++) {
			int indexOfPeakElt = list.indexOf(sortedList.get(i-1));
			if(indexOfPeakElt != 0 && indexOfPeakElt != list.size()-1) {
			if(list.get(indexOfPeakElt-1) < list.get(indexOfPeakElt) && list.get(indexOfPeakElt) > list.get(indexOfPeakElt+1)) {
				
				peakElement = list.get(indexOfPeakElt);
				peakElementList.add(peakElement);
				//break;
			}
			}
		}
		
		System.out.println(peakElement);
		System.out.println(peakElementList);
		
	}

}
