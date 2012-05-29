package com.objectmentor.utilities.getopts.ex2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;

import org.junit.Test;

public class ArgsEx2Test {

	@Test
	public void test() throws ParseException {

		// given
		// when
		ArgsEx2 arg = new ArgsEx2("l, d*", parseArgs("-l -d dev"));

		// then
		assertThat(arg.getBoolean('l'), is(true));
		assertThat(arg.getString('d'), is("dev"));
	}

	private String[] parseArgs(String param) {
		String[] split = param.split(" ");
		return split;
	}

}
