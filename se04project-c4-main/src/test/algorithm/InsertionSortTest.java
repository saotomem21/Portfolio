package test.algorithm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import algorithm.Sort;

class InsertionSortTest {
	
	// 正常にソートが可能か
	@Test
    void SortSuccess() throws Exception {
		Sort sort = new Sort();
		
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 9, 3, 1, 2, -8, -4, -7, -6));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-8, -7, -6, -4, 1, 2, 3, 5, 9));
		ArrayList<Integer> result = sort.insertionSort(numbers);
		
		assertTrue(result.equals(expected));
    }
	
	// 同じ数字が存在した場合にも正常にソートが可能か
	@Test
    void HasSameNumberSortSuccess() throws Exception {
		Sort sort = new Sort();
		
		ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(4, 8, 3, 1, 1, 8, 4, 7, 6));
		ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 1, 3, 4, 4, 6, 7, 8, 8));
		ArrayList<Integer> result1 = sort.insertionSort(numbers1);
		
		assertTrue(result1.equals(expected1));
		
		ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1));
		ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1));
		ArrayList<Integer> result2 = sort.insertionSort(numbers2);
		
		assertTrue(result2.equals(expected2));
    }
	
}
