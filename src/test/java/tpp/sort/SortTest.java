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
		int index = 0;
		while (list.size() > index + 1) { // If to While transformation
			if (list.get(index) > list.get(index + 1)) {
				Integer temp = list.get(index);
				list.set(index, list.get(index + 1));
				list.set(index + 1, temp);
			}
			index++;
		}
		return list;
	}
}
