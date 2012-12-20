package org.mebert.ttt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class BoardTest {
	private String[] testGrid = {"1","2","3","4","5","6","7","8","9"};
	private Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
  public void initializeWithProperSizeGrid() throws Exception {
	  assertEquals(9,board.grid.length);
  }

	@Test
	public void canPlaceMove() throws Exception {
		testGrid[8] = "X";
		assertArrayEquals(testGrid, board.makeMove("X", 9));
	}

	@Test
	public void canCheckIfAMoveIsValid() throws Exception {
		board.grid[5] = "X";
		assertEquals(false, board.isValidMove(6));
	}

	@Test
	public void returnsColumnWinner() throws Exception {
		board.grid[2] = "X";
		board.grid[5] = "X";
		board.grid[8] = "X";
		assertEquals("X", board.winner());
	}

	@Test
	public void returnsRowWinner() throws Exception {
		board.grid[3] = "O";
		board.grid[4] = "O";
		board.grid[5] = "O";
		assertEquals("O", board.winner());
	}

	@Test
	public void returnsDiagonalWinner() throws Exception {
		board.grid[2] = "X";
		board.grid[4] = "X";
		board.grid[6] = "X";
		assertEquals("X", board.winner());
	}

	@Test
	public void returnsNoWinner() throws Exception {
		assertEquals(null, board.winner());
	}

	@Test
	public void returnsDraw() throws Exception {
		board.grid[0] = "O";
		board.grid[1] = "X";
		board.grid[2] = "O";
		board.grid[3] = "X";
		board.grid[4] = "O";
		board.grid[5] = "X";
		board.grid[6] = "X";
		board.grid[7] = "O";
		board.grid[8] = "X";
		assertEquals(true, board.draw());
	}

	//possible to test the whole Array equals the whole Array?
	@Test
	public void returnsNumberOfAvailableMoves() throws Exception {
		String[] openMoves = {"6","7","8","9"};
		board.grid[0] = "O";
		board.grid[1] = "O";
		board.grid[2] = "O";
		board.grid[3] = "O";
		board.grid[4] = "O";
		assertEquals(openMoves[0],board.availableMoves()[0]);
		assertEquals(openMoves[1],board.availableMoves()[1]);
		assertEquals(openMoves[2],board.availableMoves()[2]);
		assertEquals(openMoves[3],board.availableMoves()[3]);
	}

	@Test
	public void canDuplicateBoard() throws Exception {
		board.makeMove("X",5);
		Board newBoard = board.copy();
		assertEquals("X", newBoard.grid[4]);
	}
}
