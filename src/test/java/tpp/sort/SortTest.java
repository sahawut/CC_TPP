package tpp.sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class SortTest {
	@Test
	public void sortings() throws Exception {
		assertThat(sort(intList()), is(intList()));
		assertThat(sort(intList(1)), is(intList(1)));
	}

	private List<Integer> sort(List<Integer> list) {
		return list;
	}

	private List<Integer> intList(Integer... ints) {
		return Arrays.asList(ints);
	}
}
