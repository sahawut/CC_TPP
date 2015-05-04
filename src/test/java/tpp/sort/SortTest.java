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
		assertSorted(intList(3, 2, 1), intList(1, 2, 3));
	}

	private List<Integer> sort(List<Integer> list) {
		for (int size = list.size(); size > 0; size--) {
			for (int index = 0; size > index + 1; index++)
				if (outOfOrder(list, index))
					swap(list, index);
		}
		return list;
	}

	private boolean outOfOrder(List<Integer> list, int index) {
		return list.get(index) > list.get(index + 1);
	}

	private void swap(List<Integer> list, int index) {
		Integer temp = list.get(index);
		list.set(index, list.get(index + 1));
		list.set(index + 1, temp);
	}
}
