package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

	// バブルソート, Bubble Sort s1280147
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> numbers) {
		int temp;

		for (int i = numbers.size() - 1; i >= 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (numbers.get(j) > numbers.get((j + 1))) {
					temp = numbers.get(j);
					numbers.set(j, numbers.get((j + 1)));
					numbers.set(j + 1, temp);
				}
			}
		}

		return numbers;
	}

	//　選択ソート, Selection Sort s1280153
	public ArrayList<Integer> selectionSort(ArrayList<Integer> numbers) {
		int minindex, temp;

		for (int i = 0; i < numbers.size(); i++) {
			minindex = i;
			for (int j = i + 1; j < numbers.size(); j++) {
				if (numbers.get(minindex) > numbers.get(j)) {
					minindex = j;
				}
			}
			if (minindex != i) {
				temp = numbers.get(i);
				numbers.set(i, numbers.get(minindex));
				numbers.set(minindex, temp);
			}
		}

		return numbers;
	}

	// 挿入ソート, Insertion Sort s1280124
	public ArrayList<Integer> insertionSort(ArrayList<Integer> numbers) {
		int temp;
		for (int i = 1; i < numbers.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (numbers.get(j - 1) > numbers.get(j)) {
					temp = numbers.get(j - 1);
					numbers.set(j - 1, numbers.get(j));
					numbers.set(j, temp);
				} else {
					break;
				}
			}
		}
		return numbers;
	}

	// バブルソート詳細
	@SuppressWarnings("unchecked")
	public ArrayList<List<ArrayList<Integer>>> getBubbleSortDetail(ArrayList<Integer> numbers) {
		ArrayList<List<ArrayList<Integer>>> sortDetail = new ArrayList<>(Arrays.asList());
		List<ArrayList<Integer>> beforeSort = new ArrayList<ArrayList<Integer>>(2);
		beforeSort.add((ArrayList<Integer>) numbers.clone());
		beforeSort.add(new ArrayList<>(Arrays.asList()));
		beforeSort.add(new ArrayList<>(Arrays.asList()));
		sortDetail.add(beforeSort);

		int temp4swap;
		ArrayList<Integer> sorted = new ArrayList<>(Arrays.asList());
		for (int i = numbers.size() - 1; i >= 0; --i) {

			for (int j = 0; j < i; ++j) {
				List<ArrayList<Integer>> beforeSwap = new ArrayList<ArrayList<Integer>>(2);
				beforeSwap.add((ArrayList<Integer>) numbers.clone());
				beforeSwap.add((ArrayList<Integer>) sorted.clone());
				beforeSwap.add(new ArrayList<>(Arrays.asList(j, j + 1)));
				sortDetail.add(beforeSwap);

				if (numbers.get(j) > numbers.get((j + 1))) {

					temp4swap = numbers.get(j);
					numbers.set(j, numbers.get((j + 1)));
					numbers.set(j + 1, temp4swap);
				}

				List<ArrayList<Integer>> afterSwap = new ArrayList<ArrayList<Integer>>(2);
				afterSwap.add((ArrayList<Integer>) numbers.clone());
				afterSwap.add((ArrayList<Integer>) sorted.clone());
				afterSwap.add(new ArrayList<>(Arrays.asList(j, j + 1)));
				sortDetail.add(afterSwap);
			}
			List<ArrayList<Integer>> afterSort = new ArrayList<ArrayList<Integer>>(2);
			sorted.add(i);
			afterSort.add((ArrayList<Integer>) numbers.clone());
			afterSort.add((ArrayList<Integer>) sorted.clone());
			afterSort.add(new ArrayList<>(Arrays.asList()));
			sortDetail.add(afterSort);

		}

		return sortDetail;
	}

	//　選択ソート詳細
	@SuppressWarnings("unchecked")
	public ArrayList<List<ArrayList<Integer>>> getSelectionSortDetail(ArrayList<Integer> numbers) {
		ArrayList<List<ArrayList<Integer>>> sortDetail = new ArrayList<>(Arrays.asList());
		List<ArrayList<Integer>> beforeSort = new ArrayList<ArrayList<Integer>>(2);
		beforeSort.add((ArrayList<Integer>) numbers.clone());
		beforeSort.add(new ArrayList<>(Arrays.asList()));
		beforeSort.add(new ArrayList<>(Arrays.asList()));
		sortDetail.add(beforeSort);

		int minindex, temp4swap;
		ArrayList<Integer> sorted = new ArrayList<>(Arrays.asList());
		for (int i = 0; i < numbers.size(); i++) {

			minindex = i;
			for (int j = i + 1; j < numbers.size(); j++) {
				if (numbers.get(minindex) > numbers.get(j)) {
					minindex = j;
				}
			}

			List<ArrayList<Integer>> beforeSwap = new ArrayList<ArrayList<Integer>>(2);
			beforeSwap.add((ArrayList<Integer>) numbers.clone());
			beforeSwap.add((ArrayList<Integer>) sorted.clone());
			beforeSwap.add(new ArrayList<>(Arrays.asList(i, minindex)));
			sortDetail.add(beforeSwap);

			if (minindex != i) {
				temp4swap = numbers.get(i);
				numbers.set(i, numbers.get(minindex));
				numbers.set(minindex, temp4swap);
			}

			List<ArrayList<Integer>> afterSwap = new ArrayList<ArrayList<Integer>>(2);
			afterSwap.add((ArrayList<Integer>) numbers.clone());
			afterSwap.add((ArrayList<Integer>) sorted.clone());
			afterSwap.add(new ArrayList<>(Arrays.asList(i, minindex)));
			sortDetail.add(afterSwap);

			List<ArrayList<Integer>> afterSort = new ArrayList<ArrayList<Integer>>(2);
			sorted.add(i);
			afterSort.add((ArrayList<Integer>) numbers.clone());
			afterSort.add((ArrayList<Integer>) sorted.clone());
			afterSort.add(new ArrayList<>(Arrays.asList()));
			sortDetail.add(afterSort);
		}

		return sortDetail;
	}

	// 挿入ソート詳細
	@SuppressWarnings("unchecked")
	public ArrayList<List<ArrayList<Integer>>> getInsertionSortDetail(ArrayList<Integer> numbers) {
		ArrayList<List<ArrayList<Integer>>> sortDetail = new ArrayList<>(Arrays.asList());
		List<ArrayList<Integer>> beforeSort = new ArrayList<ArrayList<Integer>>(2);
		beforeSort.add((ArrayList<Integer>) numbers.clone());
		beforeSort.add(new ArrayList<>(Arrays.asList()));
		beforeSort.add(new ArrayList<>(Arrays.asList()));
		sortDetail.add(beforeSort);

		int temp4swap;
		ArrayList<Integer> sorted = new ArrayList<>(Arrays.asList());
		for (int i = 0; i < numbers.size(); i++) {
			sorted.add(i);

			int toMove = -1;
			List<ArrayList<Integer>> beforeSwap = new ArrayList<ArrayList<Integer>>(2);
			beforeSwap.add((ArrayList<Integer>) numbers.clone());
			beforeSwap.add((ArrayList<Integer>) sorted.clone());
			beforeSwap.add(new ArrayList<>(Arrays.asList(i)));
			sortDetail.add(beforeSwap);

			for (int j = i; j > 0; j--) {
				if (numbers.get(j - 1) > numbers.get(j)) {
					toMove = j - 1;
					temp4swap = numbers.get(j - 1);
					numbers.set(j - 1, numbers.get(j));
					numbers.set(j, temp4swap);
				} else {
					break;
				}
			}

			List<ArrayList<Integer>> afterSwap = new ArrayList<ArrayList<Integer>>(2);
			afterSwap.add((ArrayList<Integer>) numbers.clone());
			afterSwap.add((ArrayList<Integer>) sorted.clone());
			if (toMove != -1) {
				afterSwap.add(new ArrayList<>(Arrays.asList(toMove)));
			} else {
				afterSwap.add(new ArrayList<>(Arrays.asList(i)));
			}
			sortDetail.add(afterSwap);

			List<ArrayList<Integer>> afterSort = new ArrayList<ArrayList<Integer>>(2);
			afterSort.add((ArrayList<Integer>) numbers.clone());
			afterSort.add((ArrayList<Integer>) sorted.clone());
			afterSort.add(new ArrayList<>(Arrays.asList()));
			sortDetail.add(afterSort);
		}

		return sortDetail;
	}
}
