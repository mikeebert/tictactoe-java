package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class GameTest {
	private Game game;
	private Board board;

	@Before
	public void setUp() {
		board = new Board();
		game = new Game(board,"x","human","o","computer");
	}

	@Test
	public void newGameHasBoard() throws Exception {
		assertEquals(9,game.board.grid.length);
	}

	@Test
	public void newGameHasPlayers() throws Exception {
		Map<String,String> testPlayer1 = new HashMap<String, String>();
		Map<String,String> testPlayer2 = new HashMap<String, String>();
		testPlayer1.put("symbol", "x");
		testPlayer1.put("type","human");
		testPlayer2.put("symbol", "o");
		testPlayer2.put("type","computer");
		assertEquals(testPlayer1, game.firstPlayer);
		assertEquals(testPlayer2,game.secondPlayer);
	}

	@Test
	public void canGetPlayerSymbols() throws Exception {
		assertEquals("x",game.playerSymbol(game.firstPlayer));
		assertEquals("o",game.playerSymbol(game.secondPlayer));
	}

	@Test
	public void canGetPlayerType() throws Exception {
		assertEquals("human",game.playerType(game.firstPlayer));
		assertEquals("computer",game.playerType(game.secondPlayer));
	}

	@Test
	public void updatesGameBoardWithMove() throws Exception {
		String[] testBoard = {"1","2","3","4","x","6","7","8","9"};
		assertEquals(testBoard,game.board);
	}

}
