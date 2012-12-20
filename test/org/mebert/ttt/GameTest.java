package org.mebert.ttt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GameTest {
	private Game game;
	private Board board;

	@Before
	public void setUp() {
		board = new Board();
		game = new Game(board,"X","human","O","computer");
	}

	@Test
	public void newGameHasBoard() throws Exception {
		assertEquals(9,game.board.grid.length);
	}

	@Test
	public void newGameSetsPlayers() throws Exception {
		assertEquals("X",game.firstPlayer.symbol);
		Assert.assertEquals("human", game.firstPlayer.type);
		assertEquals("O",game.secondPlayer.symbol);
		Assert.assertEquals("computer", game.secondPlayer.type);
	}

	@Test
	public void canGetPlayerSymbols() throws Exception {
		assertEquals("X",game.firstPlayer.symbol);
		assertEquals("O",game.secondPlayer.symbol);
	}

	@Test
	public void knowsIfPlayerIsComputer() throws Exception {
		assertEquals(true, game.playerIsComputer(game.secondPlayer));
		assertEquals(false, game.playerIsComputer(game.firstPlayer));
	}

	@Test
	public void updatesGameBoardWithMove() throws Exception {
		game.updateBoard(game.firstPlayer, "5");
		assertEquals("X",game.board.grid[4]);
	}

	@Test
	public void updateBoardReturnsNewBoard() throws Exception {
		String[] testGrid = {"1","2","3","4","X","6","7","8","9"};
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
		mockBoard.winner = "X";
		game.board = mockBoard;
		assertEquals(true, game.isOver());
	}

	@Test
	public void knowsGameOverForDraw() throws Exception {
		MockBoard mockBoard = new MockBoard();
		mockBoard.draw = true;
		game.board = mockBoard;
		assertEquals(true, game.isOver());
	}

	@Test
	public void knowsGameIsNotOverWhenInProgress() throws Exception {
		MockBoard mockBoard = new MockBoard();
		mockBoard.winner = null;
		mockBoard.draw = false;
		game.board = mockBoard;
		assertEquals(false, game.isOver());
	}

	@Test
	public void sendsBoardAndSymbolsToAi() throws Exception {
		MockAi mockAi = new MockAi();
		game.ai = mockAi;
		game.nextPlayer = game.firstPlayer;
		game.getComputerMove();
		assertEquals(mockAi.receivedBoard, game.board);
		assertEquals(mockAi.receivedPlayerSymbol, "X");
		assertEquals(mockAi.receivedOpponentSymbol, "O");
	}

	@Test
	public void itUpdatesGameAndMakesComputerMoveIfNext() throws Exception {
		MockAi mockAi = new MockAi();
		game.ai = mockAi;
		game.nextPlayer = game.firstPlayer;
		game.updateBoardWith("1");
		assertEquals(game.board, mockAi.receivedBoard);
		assertEquals("O", mockAi.receivedPlayerSymbol);
		assertEquals("X", mockAi.receivedOpponentSymbol);
	}

	@Test
	public void doesNotMakeComputerMoveIfOver() throws Exception {
		MockAi mockAi = new MockAi();
		game.ai = mockAi;
		game.nextPlayer = game.firstPlayer;
		game.board.grid = new String[]{"1", "X", "X", "X", "X", "X", "X", "X", "X"};

		assertEquals(null, mockAi.receivedBoard);
		assertEquals(null, mockAi.receivedPlayerSymbol);
		assertEquals(null, mockAi.receivedOpponentSymbol);
	}
}
