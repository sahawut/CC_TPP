package tpp.sort;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SortTest {
	@Test
	public void sortings() throws Exception {
		assertThat(sort(intList()), is(intList()));
	}

	private List<Integer> sort(List<Integer> list) {
		return null;
	}

	private List<Integer> intList() {
		return Arrays.asList();
	}
}
