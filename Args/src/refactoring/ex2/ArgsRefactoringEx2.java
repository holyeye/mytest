package refactoring.ex2;

import java.text.ParseException;
import java.util.*;

/**
 * Args: ArgumentMarshaller로 무조껀 옮김
 * (boolean, String)
 *
 */
public class ArgsRefactoringEx2 {
	
	private String schema;
	private String[] args;
	private boolean valid = true;
	private Set<Character> unexpectedArguments = new TreeSet<Character>();
	private Map<Character, BooleanArgumentMarshaler> booleanArgs = new HashMap<Character, BooleanArgumentMarshaler>();
	private Map<Character, StringArgumentMarshaler> stringArgs = new HashMap<Character, StringArgumentMarshaler>();
	private Set<Character> argsFound = new HashSet<Character>();
	private int currentArgument;
	private char errorArgumentId = '\0';
	private String errorParameter = "TILT";
	private ErrorCode errorCode = ErrorCode.OK;

	private enum ErrorCode {
		OK, MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, UNEXPECTED_ARGUMENT	}

	public ArgsRefactoringEx2(String schema, String[] args) throws ParseException {
		this.schema = schema;
		this.args = args;
		valid = parse();
	}

	private boolean parse() throws ParseException {
		if (schema.length() == 0 && args.length == 0)
			return true;
		parseSchema();
		try {
			parseArguments();
		} catch (ArgsException e) {
		}
		return valid;
	}

	private boolean parseSchema() throws ParseException {
		for (String element : schema.split(",")) {
			if (element.length() > 0) {
				String trimmedElement = element.trim();
				parseSchemaElement(trimmedElement);
			}
		}
		return true;
	}

	private void parseSchemaElement(String element) throws ParseException {
		char elementId = element.charAt(0);
		String elementTail = element.substring(1);
		validateSchemaElementId(elementId);
		if (isBooleanSchemaElement(elementTail))
			parseBooleanSchemaElement(elementId);
		else if (isStringSchemaElement(elementTail))
			parseStringSchemaElement(elementId);
		else {
			throw new ParseException(String.format(
					"Argument: %c has invalid format: %s.", elementId,
					elementTail), 0);
		}
	}

	private void validateSchemaElementId(char elementId) throws ParseException {
		if (!Character.isLetter(elementId)) {
			throw new ParseException("Bad character:" + elementId
					+ "in Args format: " + schema, 0);
		}
	}

	private void parseBooleanSchemaElement(char elementId) {
		booleanArgs.put(elementId, new BooleanArgumentMarshaler());
	}

	private void parseStringSchemaElement(char elementId) {
		stringArgs.put(elementId, new StringArgumentMarshaler());
	}

	private boolean isStringSchemaElement(String elementTail) {
		return elementTail.equals("*");
	}

	private boolean isBooleanSchemaElement(String elementTail) {
		return elementTail.length() == 0;
	}

	private boolean parseArguments() throws ArgsException {
		for (currentArgument = 0; currentArgument < args.length; currentArgument++) {
			String arg = args[currentArgument];
			parseArgument(arg);
		}
		return true;
	}

	private void parseArgument(String arg) throws ArgsException {
		if (arg.startsWith("-"))
			parseElements(arg);
	}

	private void parseElements(String arg) throws ArgsException {
		for (int i = 1; i < arg.length(); i++)
			parseElement(arg.charAt(i));
	}

	private void parseElement(char argChar) throws ArgsException {
		if (setArgument(argChar))
			argsFound.add(argChar);
		else {
			unexpectedArguments.add(argChar);
			errorCode = ErrorCode.UNEXPECTED_ARGUMENT;
			valid = false;
		}
	}

	private boolean setArgument(char argChar) throws ArgsException {
		if (isBooleanArg(argChar))
			setBooleanArg(argChar, true);
		else if (isStringArg(argChar))
			setStringArg(argChar);
		else
			return false;
		return true;
	}

	private void setStringArg(char argChar) throws ArgsException {
		currentArgument++;
		try {
			stringArgs.get(argChar).setString(args[currentArgument]);
		} catch (ArrayIndexOutOfBoundsException e) {
			valid = false;
			errorArgumentId = argChar;
			errorCode = ErrorCode.MISSING_STRING;
			throw new ArgsException();
		}
	}

	private boolean isStringArg(char argChar) {
		return stringArgs.containsKey(argChar);
	}

	private void setBooleanArg(char argChar, boolean value) {
		booleanArgs.get(argChar).setBoolean(value);
	}

	private boolean isBooleanArg(char argChar) {
		return booleanArgs.containsKey(argChar);
	}

	public int cardinality() {
		return argsFound.size();
	}

	public String usage() {
		if (schema.length() > 0)
			return "-[" + schema + "]";
		else
			return "";
	}

	public String errorMessage() throws Exception {
		switch (errorCode) {
		case OK:
			throw new Exception("TILT: Should not get here.");
		case UNEXPECTED_ARGUMENT:
			return unexpectedArgumentMessage();
		case MISSING_STRING:
			return String.format("Could not find string parameter for -%c.",
					errorArgumentId);
		case INVALID_INTEGER:
			return String.format(
					"Argument -%c expects an integer but was '%s'.",
					errorArgumentId, errorParameter);
		case MISSING_INTEGER:
			return String.format("Could not find integer parameter for -%c.",
					errorArgumentId);
		}
		return "";
	}

	private String unexpectedArgumentMessage() {
		StringBuffer message = new StringBuffer("Argument(s) -");
		for (char c : unexpectedArguments) {
			message.append(c);
		}
		message.append(" unexpected.");
		return message.toString();
	}

	public boolean getBoolean(char arg) {
		ArgumentMarshaler am = booleanArgs.get(arg);
		return am != null && am.getBoolean();
	}

	public String getString(char arg) {
		ArgumentMarshaler am = stringArgs.get(arg);
		return am == null ? "" : am.getString();
	}

	public boolean has(char arg) {
		return argsFound.contains(arg);
	}

	public boolean isValid() {
		return valid;
	}

	private class ArgsException extends Exception {
	}
	
	private class ArgumentMarshaler {
		
		private boolean booleanValue = false;
		private String stringValue;

		public void setBoolean(boolean value) {
			booleanValue = value;
		}

		public boolean getBoolean() {
			return booleanValue;
		}
		public void setString(String string) {
			this.stringValue = string;
		}
		
		public String getString() {
			return stringValue == null ? "" : stringValue;
		}
	}

	private class BooleanArgumentMarshaler extends ArgumentMarshaler {
	}

	private class StringArgumentMarshaler extends ArgumentMarshaler {

	}
}