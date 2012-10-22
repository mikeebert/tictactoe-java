package tictactoe;

import org.junit.Assert;
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
	public void newGameSetsPlayers() throws Exception {
		assertEquals("x",game.firstPlayer.symbol);
		Assert.assertEquals("human", game.firstPlayer.type);
		assertEquals("o",game.secondPlayer.symbol);
		Assert.assertEquals("computer", game.secondPlayer.type);
	}

	@Test
	public void canGetPlayerSymbols() throws Exception {
		assertEquals("x",game.firstPlayer.symbol);
		assertEquals("o",game.secondPlayer.symbol);
	}

	@Test
	public void knowsIfPlayerIsComputer() throws Exception {
		assertEquals(true, game.playerIsComputer(game.secondPlayer));
		assertEquals(false, game.playerIsComputer(game.firstPlayer));
	}

	@Test
	public void updatesGameBoardWithMove() throws Exception {
		game.updateBoard(game.firstPlayer, "5");
		assertEquals("x",game.board.grid[4]);
	}

	@Test
	public void updateBoardReturnsNewBoard() throws Exception {
		String[] testGrid = {"1","2","3","4","x","6","7","8","9"};
		String[] new_board = game.updateBoard(game.firstPlayer, "5");
		assertEquals(testGrid[4],new_board[4]);
	}

	@Test
	public void hasNextPlayer() throws Exception {
		assertEquals(game.firstPlayer,game.nextPlayer);
	}

	@Test
	public void hasNextOpponent() throws Exception {
		Assert.assertEquals(game.secondPlayer, game.nextOpponent());
	}

	@Test
	public void switchesNextPlayerOnMove() throws Exception{
		game.updateBoard(game.firstPlayer,"1");
		assertEquals(game.nextPlayer, game.secondPlayer);
	}

	@Test
	public void knowsGameOverForWin() throws Exception {
		MockBoard mockBoard = new MockBoard();
		mockBoard.winner = "x";
		game.board = mockBoard;
		assertEquals(true, game.over());
	}

	@Test
	public void knowsGameOverForDraw() throws Exception {
		MockBoard mockBoard = new MockBoard();
		mockBoard.draw = true;
		game.board = mockBoard;
		assertEquals(true, game.over());
	}


	@Test
	public void canGetMoveFromComputerPlayer() throws Exception {
		MockAiPlayer mockAi = new MockAiPlayer("o", "computer");
		game.secondPlayer = mockAi;
		game.nextPlayer = game.secondPlayer;
		game.getNextPlayerMove();
		assertEquals(mockAi.receivedBoard, game.board);
		assertEquals(mockAi.receivedPlayerSymbol, "o");
		assertEquals(mockAi.receivedOpponentSymbol, "x");
	}
}
