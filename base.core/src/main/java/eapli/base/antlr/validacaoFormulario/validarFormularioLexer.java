// Generated from C:/Users/Bea/OneDrive/Documentos/lei20_21_s4_2dc_05/base.core/src/main/java/eapli/base/antlr\validarFormulario.g4 by ANTLR 4.9.1
package eapli.base.antlr.validacaoFormulario;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validarFormularioLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, NEWLINE=3, INT=4, ID=5, MUL=6, DIV=7, ADD=8, SUB=9, ATR=10, 
		LPR=11, RPR=12, CAMPOS=13, SE=14, OBRIGATORIO=15, VAZIO=16, TAMANHO=17, 
		QUANTIDADE=18, EQUALS=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "NEWLINE", "INT", "ID", "MUL", "DIV", "ADD", "SUB", "ATR", 
			"LPR", "RPR", "CAMPOS", "SE", "OBRIGATORIO", "VAZIO", "TAMANHO", "QUANTIDADE", 
			"EQUALS", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'||'", null, null, null, "'*'", "'/'", "'+'", "'-'", "'='", 
			"'('", "')'", "'Campo'", "'Se'", "'Obrigatorio'", "'Vazio'", "'Tamanho'", 
			null, "'Equivale:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "NEWLINE", "INT", "ID", "MUL", "DIV", "ADD", "SUB", 
			"ATR", "LPR", "RPR", "CAMPOS", "SE", "OBRIGATORIO", "VAZIO", "TAMANHO", 
			"QUANTIDADE", "EQUALS", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public validarFormularioLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "validarFormulario.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u008f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\3\3\4\6\4\62\n\4"+
		"\r\4\16\4\63\3\5\6\5\67\n\5\r\5\16\58\3\6\6\6<\n\6\r\6\16\6=\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\6"+
		"\25\u008a\n\25\r\25\16\25\u008b\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26\3\2\6\4\2\f\f\17\17\3\2\62;\3\2c|\4\2\13\13\"\"\2\u0092\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2\7\61\3\2\2\2\t\66\3"+
		"\2\2\2\13;\3\2\2\2\r?\3\2\2\2\17A\3\2\2\2\21C\3\2\2\2\23E\3\2\2\2\25G"+
		"\3\2\2\2\27I\3\2\2\2\31K\3\2\2\2\33M\3\2\2\2\35S\3\2\2\2\37V\3\2\2\2!"+
		"b\3\2\2\2#h\3\2\2\2%p\3\2\2\2\'~\3\2\2\2)\u0089\3\2\2\2+,\7.\2\2,\4\3"+
		"\2\2\2-.\7~\2\2./\7~\2\2/\6\3\2\2\2\60\62\t\2\2\2\61\60\3\2\2\2\62\63"+
		"\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\b\3\2\2\2\65\67\t\3\2\2\66\65"+
		"\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29\n\3\2\2\2:<\t\4\2\2;:\3\2"+
		"\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\f\3\2\2\2?@\7,\2\2@\16\3\2\2\2AB\7"+
		"\61\2\2B\20\3\2\2\2CD\7-\2\2D\22\3\2\2\2EF\7/\2\2F\24\3\2\2\2GH\7?\2\2"+
		"H\26\3\2\2\2IJ\7*\2\2J\30\3\2\2\2KL\7+\2\2L\32\3\2\2\2MN\7E\2\2NO\7c\2"+
		"\2OP\7o\2\2PQ\7r\2\2QR\7q\2\2R\34\3\2\2\2ST\7U\2\2TU\7g\2\2U\36\3\2\2"+
		"\2VW\7Q\2\2WX\7d\2\2XY\7t\2\2YZ\7k\2\2Z[\7i\2\2[\\\7c\2\2\\]\7v\2\2]^"+
		"\7q\2\2^_\7t\2\2_`\7k\2\2`a\7q\2\2a \3\2\2\2bc\7X\2\2cd\7c\2\2de\7|\2"+
		"\2ef\7k\2\2fg\7q\2\2g\"\3\2\2\2hi\7V\2\2ij\7c\2\2jk\7o\2\2kl\7c\2\2lm"+
		"\7p\2\2mn\7j\2\2no\7q\2\2o$\3\2\2\2pq\7S\2\2qr\7w\2\2rs\7c\2\2st\7p\2"+
		"\2tu\7v\2\2uv\7k\2\2vw\7f\2\2wx\7c\2\2xy\7f\2\2yz\7g\2\2z{\7<\2\2{|\3"+
		"\2\2\2|}\5\t\5\2}&\3\2\2\2~\177\7G\2\2\177\u0080\7s\2\2\u0080\u0081\7"+
		"w\2\2\u0081\u0082\7k\2\2\u0082\u0083\7x\2\2\u0083\u0084\7c\2\2\u0084\u0085"+
		"\7n\2\2\u0085\u0086\7g\2\2\u0086\u0087\7<\2\2\u0087(\3\2\2\2\u0088\u008a"+
		"\t\5\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\25\2\2\u008e*\3\2\2\2"+
		"\7\2\638=\u008b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}