// Generated from C:/Users/Bea/OneDrive/Documentos/lei20_21_s4_2dc_05/base.core/src/main/java/eapli/base/antlr\validarFormulario.g4 by ANTLR 4.9.1
package eapli.base.antlr.validacaoFormulario;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validarFormularioParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, NEWLINE=3, INT=4, ID=5, MUL=6, DIV=7, ADD=8, SUB=9, ATR=10, 
		LPR=11, RPR=12, CAMPOS=13, SE=14, OBRIGATORIO=15, VAZIO=16, TAMANHO=17, 
		QUANTIDADE=18, EQUALS=19, WS=20, EXPRESSAOR=21;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_expr = 2, RULE_exprCampo = 3, RULE_equival = 4, 
		RULE_condicao = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "expr", "exprCampo", "equival", "condicao"
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
			"QUANTIDADE", "EQUALS", "WS", "EXPRESSAOR"
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
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitProg(this);
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
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				stat();
				}
				}
				setState(15); 
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
	public static class PrintCampoContext extends StatContext {
		public ExprCampoContext exprCampo() {
			return getRuleContext(ExprCampoContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(validarFormularioParser.NEWLINE, 0); }
		public PrintCampoContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterPrintCampo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitPrintCampo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitPrintCampo(this);
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
		public TerminalNode ATR() { return getToken(validarFormularioParser.ATR, 0); }
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
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				expr(0);
				setState(18);
				match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new PrintCampoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				exprCampo();
				setState(21);
				match(NEWLINE);
				}
				break;
			case 3:
				_localctx = new PrintCondicaoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(23);
				condicao();
				setState(24);
				match(NEWLINE);
				}
				break;
			case 4:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(26);
				match(ID);
				setState(27);
				match(ATR);
				setState(28);
				expr(0);
				setState(29);
				match(NEWLINE);
				}
				break;
			case 5:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(31);
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
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				_localctx = new MaisQualquerCoisaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(35);
				match(T__0);
				setState(36);
				expr(4);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(ID);
				}
				break;
			case LPR:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				match(LPR);
				setState(40);
				expr(0);
				setState(41);
				match(RPR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(51);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(45);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(46);
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
						setState(47);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(48);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(49);
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
						setState(50);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(55);
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

	public static class ExprCampoContext extends ParserRuleContext {
		public ExprCampoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprCampo; }
	 
		public ExprCampoContext() { }
		public void copyFrom(ExprCampoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CampoNaoPreencherContext extends ExprCampoContext {
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode VAZIO() { return getToken(validarFormularioParser.VAZIO, 0); }
		public CampoNaoPreencherContext(ExprCampoContext ctx) { copyFrom(ctx); }
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
	public static class EqualsContext extends ExprCampoContext {
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode EQUALS() { return getToken(validarFormularioParser.EQUALS, 0); }
		public EquivalContext equival() {
			return getRuleContext(EquivalContext.class,0);
		}
		public EqualsContext(ExprCampoContext ctx) { copyFrom(ctx); }
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
	public static class DefinirTamanhoContext extends ExprCampoContext {
		public List<TerminalNode> INT() { return getTokens(validarFormularioParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(validarFormularioParser.INT, i);
		}
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode TAMANHO() { return getToken(validarFormularioParser.TAMANHO, 0); }
		public TerminalNode ATR() { return getToken(validarFormularioParser.ATR, 0); }
		public DefinirTamanhoContext(ExprCampoContext ctx) { copyFrom(ctx); }
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
	public static class CampoObrigatorioContext extends ExprCampoContext {
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode OBRIGATORIO() { return getToken(validarFormularioParser.OBRIGATORIO, 0); }
		public CampoObrigatorioContext(ExprCampoContext ctx) { copyFrom(ctx); }
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
	public static class ExpressaoRegularContext extends ExprCampoContext {
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode EXPRESSAOR() { return getToken(validarFormularioParser.EXPRESSAOR, 0); }
		public ExpressaoRegularContext(ExprCampoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterExpressaoRegular(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitExpressaoRegular(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitExpressaoRegular(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprCampoContext exprCampo() throws RecognitionException {
		ExprCampoContext _localctx = new ExprCampoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exprCampo);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new CampoObrigatorioContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(INT);
				setState(57);
				match(CAMPOS);
				setState(58);
				match(OBRIGATORIO);
				}
				break;
			case 2:
				_localctx = new CampoNaoPreencherContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(INT);
				setState(60);
				match(CAMPOS);
				setState(61);
				match(VAZIO);
				}
				break;
			case 3:
				_localctx = new DefinirTamanhoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				match(INT);
				setState(63);
				match(CAMPOS);
				setState(64);
				match(TAMANHO);
				setState(65);
				match(ATR);
				setState(66);
				match(INT);
				}
				break;
			case 4:
				_localctx = new ExpressaoRegularContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				match(INT);
				setState(68);
				match(CAMPOS);
				setState(69);
				match(EXPRESSAOR);
				}
				break;
			case 5:
				_localctx = new EqualsContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				match(INT);
				setState(71);
				match(CAMPOS);
				setState(72);
				match(EQUALS);
				setState(73);
				equival();
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

	public static class EquivalContext extends ParserRuleContext {
		public EquivalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equival; }
	 
		public EquivalContext() { }
		public void copyFrom(EquivalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NadaContext extends EquivalContext {
		public List<TerminalNode> ID() { return getTokens(validarFormularioParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(validarFormularioParser.ID, i);
		}
		public NadaContext(EquivalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterNada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitNada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitNada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquivalContext equival() throws RecognitionException {
		EquivalContext _localctx = new EquivalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_equival);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new NadaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(ID);
				setState(77);
				match(T__1);
				setState(78);
				match(ID);
				setState(79);
				match(T__1);
				setState(80);
				match(ID);
				}
				break;
			case 2:
				_localctx = new NadaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(ID);
				setState(82);
				match(T__1);
				setState(83);
				match(ID);
				}
				break;
			case 3:
				_localctx = new NadaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
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
	public static class CondicaoValidacao2Context extends CondicaoContext {
		public TerminalNode SE() { return getToken(validarFormularioParser.SE, 0); }
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode OBRIGATORIO() { return getToken(validarFormularioParser.OBRIGATORIO, 0); }
		public ExprCampoContext exprCampo() {
			return getRuleContext(ExprCampoContext.class,0);
		}
		public CondicaoValidacao2Context(CondicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterCondicaoValidacao2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitCondicaoValidacao2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitCondicaoValidacao2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondicaoValidacaoContext extends CondicaoContext {
		public TerminalNode SE() { return getToken(validarFormularioParser.SE, 0); }
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode ATR() { return getToken(validarFormularioParser.ATR, 0); }
		public TerminalNode ID() { return getToken(validarFormularioParser.ID, 0); }
		public ExprCampoContext exprCampo() {
			return getRuleContext(ExprCampoContext.class,0);
		}
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
	public static class CondicaoValidacao1Context extends CondicaoContext {
		public TerminalNode SE() { return getToken(validarFormularioParser.SE, 0); }
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public TerminalNode CAMPOS() { return getToken(validarFormularioParser.CAMPOS, 0); }
		public TerminalNode VAZIO() { return getToken(validarFormularioParser.VAZIO, 0); }
		public ExprCampoContext exprCampo() {
			return getRuleContext(ExprCampoContext.class,0);
		}
		public CondicaoValidacao1Context(CondicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterCondicaoValidacao1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitCondicaoValidacao1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitCondicaoValidacao1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantidadeContext extends CondicaoContext {
		public TerminalNode QUANTIDADE() { return getToken(validarFormularioParser.QUANTIDADE, 0); }
		public TerminalNode ATR() { return getToken(validarFormularioParser.ATR, 0); }
		public TerminalNode INT() { return getToken(validarFormularioParser.INT, 0); }
		public QuantidadeContext(CondicaoContext ctx) { copyFrom(ctx); }
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

	public final CondicaoContext condicao() throws RecognitionException {
		CondicaoContext _localctx = new CondicaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_condicao);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new CondicaoValidacaoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(SE);
				setState(88);
				match(INT);
				setState(89);
				match(CAMPOS);
				setState(90);
				match(ATR);
				setState(91);
				match(ID);
				setState(92);
				exprCampo();
				}
				break;
			case 2:
				_localctx = new CondicaoValidacao1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(SE);
				setState(94);
				match(INT);
				setState(95);
				match(CAMPOS);
				setState(96);
				match(VAZIO);
				setState(97);
				exprCampo();
				}
				break;
			case 3:
				_localctx = new CondicaoValidacao2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				match(SE);
				setState(99);
				match(INT);
				setState(100);
				match(CAMPOS);
				setState(101);
				match(OBRIGATORIO);
				setState(102);
				exprCampo();
				}
				break;
			case 4:
				_localctx = new QuantidadeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				match(QUANTIDADE);
				setState(104);
				match(ATR);
				setState(105);
				match(INT);
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
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27o\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3#\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4.\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\66\n"+
		"\4\f\4\16\49\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5M\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"X\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7m\n\7\3\7\2\3\6\b\2\4\6\b\n\f\2\4\3\2\b\t\3\2\n\13\2{"+
		"\2\17\3\2\2\2\4\"\3\2\2\2\6-\3\2\2\2\bL\3\2\2\2\nW\3\2\2\2\fl\3\2\2\2"+
		"\16\20\5\4\3\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2"+
		"\22\3\3\2\2\2\23\24\5\6\4\2\24\25\7\5\2\2\25#\3\2\2\2\26\27\5\b\5\2\27"+
		"\30\7\5\2\2\30#\3\2\2\2\31\32\5\f\7\2\32\33\7\5\2\2\33#\3\2\2\2\34\35"+
		"\7\7\2\2\35\36\7\f\2\2\36\37\5\6\4\2\37 \7\5\2\2 #\3\2\2\2!#\7\5\2\2\""+
		"\23\3\2\2\2\"\26\3\2\2\2\"\31\3\2\2\2\"\34\3\2\2\2\"!\3\2\2\2#\5\3\2\2"+
		"\2$%\b\4\1\2%&\7\3\2\2&.\5\6\4\6\'.\7\6\2\2(.\7\7\2\2)*\7\r\2\2*+\5\6"+
		"\4\2+,\7\16\2\2,.\3\2\2\2-$\3\2\2\2-\'\3\2\2\2-(\3\2\2\2-)\3\2\2\2.\67"+
		"\3\2\2\2/\60\f\b\2\2\60\61\t\2\2\2\61\66\5\6\4\t\62\63\f\7\2\2\63\64\t"+
		"\3\2\2\64\66\5\6\4\b\65/\3\2\2\2\65\62\3\2\2\2\669\3\2\2\2\67\65\3\2\2"+
		"\2\678\3\2\2\28\7\3\2\2\29\67\3\2\2\2:;\7\6\2\2;<\7\17\2\2<M\7\21\2\2"+
		"=>\7\6\2\2>?\7\17\2\2?M\7\22\2\2@A\7\6\2\2AB\7\17\2\2BC\7\23\2\2CD\7\f"+
		"\2\2DM\7\6\2\2EF\7\6\2\2FG\7\17\2\2GM\7\27\2\2HI\7\6\2\2IJ\7\17\2\2JK"+
		"\7\25\2\2KM\5\n\6\2L:\3\2\2\2L=\3\2\2\2L@\3\2\2\2LE\3\2\2\2LH\3\2\2\2"+
		"M\t\3\2\2\2NO\7\7\2\2OP\7\4\2\2PQ\7\7\2\2QR\7\4\2\2RX\7\7\2\2ST\7\7\2"+
		"\2TU\7\4\2\2UX\7\7\2\2VX\7\7\2\2WN\3\2\2\2WS\3\2\2\2WV\3\2\2\2X\13\3\2"+
		"\2\2YZ\7\20\2\2Z[\7\6\2\2[\\\7\17\2\2\\]\7\f\2\2]^\7\7\2\2^m\5\b\5\2_"+
		"`\7\20\2\2`a\7\6\2\2ab\7\17\2\2bc\7\22\2\2cm\5\b\5\2de\7\20\2\2ef\7\6"+
		"\2\2fg\7\17\2\2gh\7\21\2\2hm\5\b\5\2ij\7\24\2\2jk\7\f\2\2km\7\6\2\2lY"+
		"\3\2\2\2l_\3\2\2\2ld\3\2\2\2li\3\2\2\2m\r\3\2\2\2\n\21\"-\65\67LWl";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}