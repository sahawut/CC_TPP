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
		assertSorted(intList(2, 1, 3), intList(1, 2, 3));
		assertSorted(intList(2, 3, 1), intList(1, 2, 3));
		assertSorted(intList(2, 1, 3), intList(1, 2, 3));
		assertSorted(intList(2, 3, 1), intList(1, 2, 3));
		assertSorted(intList(1, 3, 2), intList(1, 2, 3));
		assertSorted(intList(3, 2, 1), intList(1, 2, 3));
		assertSorted(intList(3, 2, 2, 1), intList(1, 2, 2, 3));
	}

	private List<Integer> sort(List<Integer> list) {
		List<Integer> sorted = new ArrayList<>();
		if (list.size() == 0)
			return list;
		else {
			List<Integer> l = new ArrayList<>();
			Integer m = list.get(0);
			List<Integer> h = new ArrayList<>();
			for (int i : list) {
				if (i > m)
					h.add(i);
				if (i < m)
					l.add(i);
			}
			sorted.addAll(sort(l));
			sorted.add(m);
			sorted.addAll(sort(h));
		}

		return sorted;
	}
}
