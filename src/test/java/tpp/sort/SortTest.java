package tpp.sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
		assertSorted(intList(1, 3, 2), intList(1, 2, 3));
	}

	private List<Integer> sort(List<Integer> list) {
		if (list.size() > 1) { // Split Flow transformation
			if (list.get(0) > list.get(1)) { // Split Flow transformation
				Integer temp = list.get(0); // Computation transformation
				list.set(0, list.get(1)); // Assign transformation
				list.set(1, temp); // Assign transformation
			}
		}
		if (list.size() > 2) { // Split Flow transformation
			if (list.get(1) > list.get(2)) { // Split Flow transformation
				Integer temp = list.get(1); // Computation transformation
				list.set(1, list.get(2)); // Assign transformation
				list.set(2, temp); // Assign transformation
			}
		}
		return list;
	}
}
