package Condition;

import Compile.LexicalParser;
import Exceptions.LexicalAnalysisException;
import Condition.Condition;

public class ConditionParser {
	private final static Condition[] cond = {new Equal(), new Less(), new LessEq(), new NotEqual()};
	public ConditionParser(){};
	
	public static Condition parse(String t1, String op, String t2, LexicalParser parser) throws LexicalAnalysisException
	{
		for (int i = 0; i < cond.length; i++) {
			Condition b = cond[i].parse(t1, op, t2, parser);
			if (b != null)
				return b;
		}
		throw new LexicalAnalysisException("Condición incorrecta");
	}
}
