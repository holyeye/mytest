package refactoring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

public class ArgsRefctoringTest {

	@Test
	public void testBoolean() throws ParseException {

		// when
		ArgsRefactoring arg = new ArgsRefactoring("l", parseArgs("-l"));

		// then
		assertThat(arg.getBoolean('l'), is(true));
		assertThat(arg.getBoolean('f'), is(false));
	}
	
	@Test
	public void testString() throws ParseException {
		
		// when
		ArgsRefactoring arg = new ArgsRefactoring("d*", parseArgs("-d dev"));
		
		// then
		assertThat(arg.getString('d'), is("dev"));
		assertThat(arg.getString('f'), is(""));
	}
	
	private String[] parseArgs(String param) {
		String[] split = param.split(" ");
		return split;
	}

}
