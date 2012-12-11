package tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.rmi.log.LogInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		testGrid[8] = "x";
		assertArrayEquals(testGrid, board.makeMove("x", 9));
	}

	@Test
	public void canCheckIfAMoveIsValid() throws Exception {
		board.grid[5] = "x";
		assertEquals(false, board.isValidMove(6));
	}

	@Test
	public void returnsColumnWinner() throws Exception {
		board.grid[2] = "x";
		board.grid[5] = "x";
		board.grid[8] = "x";
		assertEquals("x", board.winner());
	}

	@Test
	public void returnsRowWinner() throws Exception {
		board.grid[3] = "o";
		board.grid[4] = "o";
		board.grid[5] = "o";
		assertEquals("o", board.winner());
	}

	@Test
	public void returnsDiagonalWinner() throws Exception {
		board.grid[2] = "x";
		board.grid[4] = "x";
		board.grid[6] = "x";
		assertEquals("x", board.winner());
	}

	@Test
	public void returnsNoWinner() throws Exception {
		assertEquals("none", board.winner());
	}

	@Test
	public void returnsDraw() throws Exception {
		board.grid[0] = "o";
		board.grid[1] = "x";
		board.grid[2] = "o";
		board.grid[3] = "x";
		board.grid[4] = "o";
		board.grid[5] = "x";
		board.grid[6] = "x";
		board.grid[7] = "o";
		board.grid[8] = "x";
		assertEquals(true, board.draw());
	}

	//possible to test the whole Array equals the whole Array?
	@Test
	public void returnsNumberOfAvailableMoves() throws Exception {
		String[] openMoves = {"6","7","8","9"};
		board.grid[0] = "o";
		board.grid[1] = "o";
		board.grid[2] = "o";
		board.grid[3] = "o";
		board.grid[4] = "o";
		assertEquals(openMoves[0],board.availableMoves()[0]);
		assertEquals(openMoves[1],board.availableMoves()[1]);
		assertEquals(openMoves[2],board.availableMoves()[2]);
		assertEquals(openMoves[3],board.availableMoves()[3]);
	}

	@Test
	public void canDuplicateBoard() throws Exception {
		board.makeMove("x",5);
		Board newBoard = board.copy();
		assertEquals("x", newBoard.grid[4]);
	}
}
