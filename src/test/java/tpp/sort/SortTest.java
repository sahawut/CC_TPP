package tpp.sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortTest {
	private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
		assertThat(sort(unsorted), is(sorted));
	}

	private List<Integer> intList(Integer... ints) {
		return Arrays.asList(ints);
	}

	@Test
	public void sortings() throws Exception {
		assertSorted(intList(), intList());
		assertSorted(intList(1), intList(1));
		assertSorted(intList(2, 1), intList(1, 2));
	}

	private List<Integer> sort(List<Integer> list) {
		List<Integer> sorted = new ArrayList<>(); // Add Computation transformation
		if (list.size() <= 1) // Split Flow transformation
			return list;
		if (list.get(0) > list.get(1)) {  // Split Flow transformation
			sorted.add(list.get(1)); // Assign transformation
			sorted.add(list.get(0)); // Assign transformation
		} else {  // Split Flow transformation
			sorted.add(list.get(0)); // Assign transformation
			sorted.add(list.get(1)); // Assign transformation
		}
		return sorted;
	}
}
