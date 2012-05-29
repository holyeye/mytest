package com.objectmentor.utilities.getopts.ex3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;

import org.junit.Test;

public class ArgsTest {

	@Test
	public void test() throws ParseException {

		// given
		// when
		ArgsEx3 arg = new ArgsEx3("p#, d*", parseArgs("-p 100 -d dev"));

		// then
		assertThat(arg.getInt('p'), is(100));
		assertThat(arg.getString('d'), is("dev"));
	}

	private String[] parseArgs(String param) {
		String[] split = param.split(" ");
		return split;
	}

}
