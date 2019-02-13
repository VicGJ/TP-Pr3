package Term;

import Exceptions.LexicalAnalysisException;

public class TermParser {
	
	private final static Term[] term = {new Variable(), new Number()};
	
	public static Term parse(String line) throws LexicalAnalysisException
	{
		for (int i = 0; i < term.length; i++) {
			Term b = term[i].parse(line);
			if (b != null)
				return b;
		}
		throw new LexicalAnalysisException("Término incorrecto");
	}
}
