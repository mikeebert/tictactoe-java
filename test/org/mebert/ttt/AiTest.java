package org.mebert.ttt;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AiTest {
	private Ai ai;

	@Before
	public void setUp() throws Exception {
		ai = new Ai();
	}

	@Test
	public void itSetsMinAndMaxPlayers() throws Exception {
		ai.setMinAndMax("X","O");
		assertEquals(-5,ai.max.startingScore);
		assertEquals(5,ai.min.startingScore);
	}

	@Test
	public void returnsOddChosenMove() throws Exception {
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("2");
		choices.add("3");
		assertEquals("3",ai.chosenMove(choices));
	}

	//Poor Test
	@Test
	public void returnsRandomChosenMove() throws Exception {
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("2");
		choices.add("4");
		choices.add("6");
		assertEquals(true, choices.contains(ai.chosenMove(choices)));
	}

	@Test
	public void returnsValueForMaxWonGame() throws Exception {
		ai.max = new MaxPlayer("X", -5);
		ai.min = new MinPlayer("O", 5);
		Board board = new Board();
		int depth = 1;
		board.grid[0] = "X";
		board.grid[1] = "X";
		board.grid[2] = "X";
		assertEquals(99, ai.gameValue(board, depth));
	}

	@Test
	public void returnsValueForMinWonGame() throws Exception {
		ai.max = new MaxPlayer("X", -5);
		ai.min = new MinPlayer("O", 5);
		Board board = new Board();
		int depth = 1;
		board.grid[0] = "O";
		board.grid[1] = "O";
		board.grid[2] = "O";
		assertEquals(-99,ai.gameValue(board,depth));
	}

	@Test
	public void returnsNegativeOneInProgress() throws Exception {
		ai.max = new MaxPlayer("X", -5);
		ai.min = new MinPlayer("O", 5);
		Board board = new Board();
		int depth = 1;
		assertEquals(-1,ai.gameValue(board,depth));
	}

	@Test
	public void returnsZeroForDraw() throws Exception {
		ai.max = new MaxPlayer("X", -5);
		ai.min = new MinPlayer("O", 5);
		Board board = new Board();
		int depth = 7;
		board.grid[0] = "X";
		board.grid[1] = "X";
		board.grid[2] = "O";
		board.grid[3] = "O";
		board.grid[4] = "O";
		board.grid[5] = "X";
		board.grid[6] = "X";
		board.grid[7] = "O";
		board.grid[8] = "X";
		assertEquals(0, ai.gameValue(board,depth));
	}

	@Test
	public void returnsFirstCornerForOpeningMove() throws Exception {
		Board board = new Board();
		assertEquals("1", ai.getMove(board, "X", "O"));
	}

	@Test
	public void returnsWinningMove() throws Exception {
		Board board = new Board();
		board.grid[0] = "X";
		board.grid[4] = "X";
		assertEquals("9", ai.getMove(board, "X", "O"));
	}

	@Test
	public void blocksWinningMove() throws Exception {
		Board board = new Board();
		board.grid[0] = "O";
		board.grid[3] = "O";
		assertEquals("7", ai.getMove(board, "X", "O"));
	}

	@Test
	public void blocksKnightSetup() throws Exception {
		Board board = new Board();
		board.grid[0] = "O";
		board.grid[4] = "X";
		board.grid[7] = "O";
		ArrayList<String> safeMoves = new ArrayList<String>();
		safeMoves.add("6");
		safeMoves.add("7");
		safeMoves.add("9");
		assertEquals(true, safeMoves.contains(ai.getMove(board, "X", "O")));
	}

	@Test
	public void choosesCenterAfterCorner() throws Exception {
		Board board = new Board();
		board.grid[0] = "O";
		assertEquals("5", ai.getMove(board, "X", "O"));
	}
}
