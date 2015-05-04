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
	}

	private List<Integer> sort(List<Integer> list) {
		List<Integer> sorted = new ArrayList<>();
		if (list.size() == 1)
			sorted.add(list.get(0));
		else if (list.size() == 2) {
			if (list.get(0) > list.get(1)) {
				sorted.add(list.get(1));
				sorted.add(list.get(0));
			} else {
				sorted.add(list.get(0));
				sorted.add(list.get(1));
			}
		}
		else if (list.size() == 3) {
			int l = 0;
			int m = list.get(0);
			int h = 0;
			for (int i : list) {
				if (i > m)
					h = i;
				if (i < m)
					l = i;
			}
			sorted.add(l);
			sorted.add(m);
			sorted.add(h);
		}

		return sorted;
	}
}
