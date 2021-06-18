// Generated from C:/Users/Bea/OneDrive/Documentos/lei20_21_s4_2dc_05/base.core/src/main/java/eapli/base/antlr\validarFormulario.g4 by ANTLR 4.9.1
package eapli.base.antlr.eapli.base.antlr;
import eapli.base.antlr.eapli.base.antlr.validarFormularioListener;
import eapli.base.antlr.eapli.base.antlr.validarFormularioVisitor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validarFormularioParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, NEWLINE=3, INT=4, ID=5, MUL=6, DIV=7, ADD=8, SUB=9, ATR=10, 
		LPR=11, RPR=12, CAMPOS=13, SE=14, OBRIGATORIO=15, VAZIO=16, TAMANHO=17, 
		QUANTIDADE=18, EQUALS=19, WS=20, VAZIA=21;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_expr = 2, RULE_equival = 3, RULE_condicao = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "expr", "equival", "condicao"
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
			"QUANTIDADE", "EQUALS", "WS", "VAZIA"
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

	@Override
	public String getGrammarFileName() { return "validarFormulario.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public validarFormularioParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor) return ((validarFormularioVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				stat();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NEWLINE) | (1L << INT) | (1L << ID) | (1L << LPR) | (1L << SE) | (1L << QUANTIDADE))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintCondicaoContext extends StatContext {
		public CondicaoContext condicao() {
			return getRuleContext(CondicaoContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(validarFormularioParser.NEWLINE, 0); }
		public PrintCondicaoContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterPrintCondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitPrintCondicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitPrintCondicao(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlankContext extends StatContext {
		public TerminalNode NEWLINE() { return getToken(validarFormularioParser.NEWLINE, 0); }
		public BlankContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitBlank(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintExprContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(validarFormularioParser.NEWLINE, 0); }
		public PrintExprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterPrintExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitPrintExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitPrintExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends StatContext {
		public TerminalNode ID() { return getToken(validarFormularioParser.ID, 0); }
		public TerminalNode SUB() { return getToken(validarFormularioParser.SUB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(validarFormularioParser.NEWLINE, 0); }
		public AssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(15);
				expr(0);
				setState(16);
				match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new PrintCondicaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				condicao();
				setState(19);
				match(NEWLINE);
				}
				break;
			case 3:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(21);
				match(ID);
				setState(22);
				match(SUB);
				setState(23);
				expr(0);
				setState(24);
				match(NEWLINE);
				}
				break;
			case 4:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(26);
				match(NEWLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CampoNaoPreencherContext extends ExprContext {
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode VAZIA() { return getToken(validarFormularioParser.VAZIA, 0); }
		public CampoNaoPreencherContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterCampoNaoPreencher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitCampoNaoPreencher(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitCampoNaoPreencher(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualsContext extends ExprContext {
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode EQUALS() { return getToken(validarFormularioParser.EQUALS, 0); }
		public EquivalContext equival() {
			return getRuleContext(EquivalContext.class,0);
		}
		public EqualsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterEquals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitEquals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends ExprContext {
		public TerminalNode LPR() { return getToken(validarFormularioParser.LPR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPR() { return getToken(validarFormularioParser.RPR, 0); }
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefinirTamanhoContext extends ExprContext {
		public List<TerminalNode> INT() { return getTokens(validarFormularioParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(validarFormularioParser.INT, i);
		}
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode TAMANHO() { return getToken(validarFormularioParser.TAMANHO, 0); }
		public TerminalNode SUB() { return getToken(validarFormularioParser.SUB, 0); }
		public DefinirTamanhoContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterDefinirTamanho(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitDefinirTamanho(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitDefinirTamanho(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(validarFormularioParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(validarFormularioParser.DIV, 0); }
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(validarFormularioParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(validarFormularioParser.SUB, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CampoObrigatorioContext extends ExprContext {
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode OBRIGATORIO() { return getToken(validarFormularioParser.OBRIGATORIO, 0); }
		public CampoObrigatorioContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterCampoObrigatorio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitCampoObrigatorio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitCampoObrigatorio(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaisQualquerCoisaContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MaisQualquerCoisaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterMaisQualquerCoisa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitMaisQualquerCoisa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitMaisQualquerCoisa(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(validarFormularioParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantidadeContext extends ExprContext {
		public TerminalNode QUANTIDADE() { return getToken(validarFormularioParser.QUANTIDADE, 0); }
		public QuantidadeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterQuantidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitQuantidade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitQuantidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				_localctx = new MaisQualquerCoisaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(30);
				match(T__0);
				setState(31);
				expr(9);
				}
				break;
			case 2:
				{
				_localctx = new CampoObrigatorioContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				match(INT);
				setState(33);
				match(CAMPOS);
				setState(34);
				match(OBRIGATORIO);
				}
				break;
			case 3:
				{
				_localctx = new CampoNaoPreencherContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(INT);
				setState(36);
				match(CAMPOS);
				setState(37);
				match(VAZIA);
				}
				break;
			case 4:
				{
				_localctx = new DefinirTamanhoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(INT);
				setState(39);
				match(CAMPOS);
				setState(40);
				match(TAMANHO);
				setState(41);
				match(SUB);
				setState(42);
				match(INT);
				}
				break;
			case 5:
				{
				_localctx = new QuantidadeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				match(QUANTIDADE);
				}
				break;
			case 6:
				{
				_localctx = new EqualsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(INT);
				setState(45);
				match(CAMPOS);
				setState(46);
				match(EQUALS);
				setState(47);
				equival();
				}
				break;
			case 7:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(INT);
				}
				break;
			case 8:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				match(ID);
				}
				break;
			case 9:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				match(LPR);
				setState(51);
				expr(0);
				setState(52);
				match(RPR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(62);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(56);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(57);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(58);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(59);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(60);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(61);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EquivalContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(validarFormularioParser.ID, 0); }
		public EquivalContext equival() {
			return getRuleContext(EquivalContext.class,0);
		}
		public EquivalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equival; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterEquival(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitEquival(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitEquival(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquivalContext equival() throws RecognitionException {
		EquivalContext _localctx = new EquivalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_equival);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(ID);
				setState(69);
				match(T__1);
				setState(70);
				equival();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondicaoContext extends ParserRuleContext {
		public CondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicao; }
	 
		public CondicaoContext() { }
		public void copyFrom(CondicaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CondicaoValidacaoContext extends CondicaoContext {
		public TerminalNode SE() { return getToken(validarFormularioParser.SE, 0); }
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode SUB() { return getToken(validarFormularioParser.SUB, 0); }
		public TerminalNode ID() { return getToken(validarFormularioParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode VAZIO() { return getToken(validarFormularioParser.VAZIO, 0); }
		public TerminalNode OBRIGATORIO() { return getToken(validarFormularioParser.OBRIGATORIO, 0); }
		public CondicaoValidacaoContext(CondicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterCondicaoValidacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitCondicaoValidacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitCondicaoValidacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicaoContext condicao() throws RecognitionException {
		CondicaoContext _localctx = new CondicaoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_condicao);
		int _la;
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new CondicaoValidacaoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(SE);
				setState(75);
				match(INT);
				setState(76);
				match(CAMPOS);
				setState(77);
				match(SUB);
				setState(78);
				match(ID);
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(79);
					expr(0);
					}
					}
					setState(82); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << INT) | (1L << ID) | (1L << LPR) | (1L << QUANTIDADE))) != 0) );
				}
				break;
			case 2:
				_localctx = new CondicaoValidacaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(SE);
				setState(85);
				match(INT);
				setState(86);
				match(CAMPOS);
				setState(87);
				match(VAZIO);
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(88);
					expr(0);
					}
					}
					setState(91); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << INT) | (1L << ID) | (1L << LPR) | (1L << QUANTIDADE))) != 0) );
				}
				break;
			case 3:
				_localctx = new CondicaoValidacaoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				match(SE);
				setState(94);
				match(INT);
				setState(95);
				match(CAMPOS);
				setState(96);
				match(OBRIGATORIO);
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(97);
					expr(0);
					}
					}
					setState(100); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << INT) | (1L << ID) | (1L << LPR) | (1L << QUANTIDADE))) != 0) );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27k\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\49\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4A\n\4\f\4\16\4D\13\4\3\5\3\5"+
		"\3\5\3\5\3\5\5\5K\n\5\3\6\3\6\3\6\3\6\3\6\3\6\6\6S\n\6\r\6\16\6T\3\6\3"+
		"\6\3\6\3\6\3\6\6\6\\\n\6\r\6\16\6]\3\6\3\6\3\6\3\6\3\6\6\6e\n\6\r\6\16"+
		"\6f\5\6i\n\6\3\6\2\3\6\7\2\4\6\b\n\2\4\3\2\b\t\3\2\n\13\2z\2\r\3\2\2\2"+
		"\4\35\3\2\2\2\68\3\2\2\2\bJ\3\2\2\2\nh\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2"+
		"\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\3\3\2\2\2\21\22\5\6\4\2"+
		"\22\23\7\5\2\2\23\36\3\2\2\2\24\25\5\n\6\2\25\26\7\5\2\2\26\36\3\2\2\2"+
		"\27\30\7\7\2\2\30\31\7\13\2\2\31\32\5\6\4\2\32\33\7\5\2\2\33\36\3\2\2"+
		"\2\34\36\7\5\2\2\35\21\3\2\2\2\35\24\3\2\2\2\35\27\3\2\2\2\35\34\3\2\2"+
		"\2\36\5\3\2\2\2\37 \b\4\1\2 !\7\3\2\2!9\5\6\4\13\"#\7\6\2\2#$\7\17\2\2"+
		"$9\7\21\2\2%&\7\6\2\2&\'\7\17\2\2\'9\7\27\2\2()\7\6\2\2)*\7\17\2\2*+\7"+
		"\23\2\2+,\7\13\2\2,9\7\6\2\2-9\7\24\2\2./\7\6\2\2/\60\7\17\2\2\60\61\7"+
		"\25\2\2\619\5\b\5\2\629\7\6\2\2\639\7\7\2\2\64\65\7\r\2\2\65\66\5\6\4"+
		"\2\66\67\7\16\2\2\679\3\2\2\28\37\3\2\2\28\"\3\2\2\28%\3\2\2\28(\3\2\2"+
		"\28-\3\2\2\28.\3\2\2\28\62\3\2\2\28\63\3\2\2\28\64\3\2\2\29B\3\2\2\2:"+
		";\f\r\2\2;<\t\2\2\2<A\5\6\4\16=>\f\f\2\2>?\t\3\2\2?A\5\6\4\r@:\3\2\2\2"+
		"@=\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\7\3\2\2\2DB\3\2\2\2EK\3\2\2"+
		"\2FG\7\7\2\2GH\7\4\2\2HK\5\b\5\2IK\7\7\2\2JE\3\2\2\2JF\3\2\2\2JI\3\2\2"+
		"\2K\t\3\2\2\2LM\7\20\2\2MN\7\6\2\2NO\7\17\2\2OP\7\13\2\2PR\7\7\2\2QS\5"+
		"\6\4\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2Ui\3\2\2\2VW\7\20\2\2WX"+
		"\7\6\2\2XY\7\17\2\2Y[\7\22\2\2Z\\\5\6\4\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2"+
		"\2]^\3\2\2\2^i\3\2\2\2_`\7\20\2\2`a\7\6\2\2ab\7\17\2\2bd\7\21\2\2ce\5"+
		"\6\4\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hL\3\2\2\2hV\3"+
		"\2\2\2h_\3\2\2\2i\13\3\2\2\2\f\17\358@BJT]fh";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}