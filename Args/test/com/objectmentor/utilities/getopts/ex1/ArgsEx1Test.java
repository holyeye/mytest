package com.objectmentor.utilities.getopts.ex1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;

import org.junit.Test;

public class ArgsEx1Test {

	@Test
	public void test() throws ParseException {

		// given
		// when
		ArgsEx1 arg = new ArgsEx1("l,o", parseArgs("-l"));

		// then
		assertThat(arg.getBoolean('l'), is(true));
		assertThat(arg.getBoolean('o'), is(false));
	}

	private String[] parseArgs(String param) {
		String[] split = param.split(" ");
		return split;
	}

}
