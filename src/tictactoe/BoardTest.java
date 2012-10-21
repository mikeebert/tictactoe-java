package tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.*;

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
	public void verifiesFirstRowWinningLayout() throws Exception {
		board.grid[0] = "x";
		board.grid[1] = "x";
		board.grid[2] = "x";
		assertEquals(true,board.hasWinner());
	}

	@Test
	public void verifiesLastRowWinningLayout() throws Exception {
		board.grid[6] = "x";
		board.grid[7] = "x";
		board.grid[8] = "x";
		assertEquals(true,board.hasWinner());
	}

	@Test
	public void verifiesfirstColumnWinningLayout() throws Exception {
		board.grid[0] = "x";
		board.grid[3] = "x";
		board.grid[6] = "x";
		assertEquals(true,board.hasWinner());
	}
	@Test
	public void verifiesLastColumnWinningLayout() throws Exception {
		board.grid[2] = "x";
		board.grid[5] = "x";
		board.grid[8] = "x";
		assertEquals(true,board.hasWinner());
	}

	@Test
	public void verifiesForwardSlashWinningLayout() throws Exception {
		board.grid[0] = "x";
		board.grid[4] = "x";
		board.grid[8] = "x";
		assertEquals(true,board.hasWinner());
	}

	@Test
	public void verifiesBackwardSlashWinningLayout() throws Exception {
		board.grid[2] = "x";
		board.grid[4] = "x";
		board.grid[6] = "x";
		assertEquals(true,board.hasWinner());
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

	// should really return the array of available moves, but don't know how to test
	@Test
	public void returnsNumberOfAvailableMoves() throws Exception {
		String[] openMoves = {"6","7","8","9"};
		board.grid[0] = "o";
		board.grid[1] = "o";
		board.grid[2] = "o";
		board.grid[3] = "o";
		board.grid[4] = "o";
		assertEquals(4,board.availableMoves().size());
	}

}
