package tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

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
		ai.setMinAndMax("x","o");
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
		ai.max = new MaxPlayer("x", -5);
		ai.min = new MinPlayer("o", 5);
		Board board = new Board();
		int depth = 1;
		board.grid[0] = "x";
		board.grid[1] = "x";
		board.grid[2] = "x";
		assertEquals(99, ai.gameValue(board, depth));
	}

	@Test
	public void returnsValueForMinWonGame() throws Exception {
		ai.max = new MaxPlayer("x", -5);
		ai.min = new MinPlayer("o", 5);
		Board board = new Board();
		int depth = 1;
		board.grid[0] = "o";
		board.grid[1] = "o";
		board.grid[2] = "o";
		assertEquals(-99,ai.gameValue(board,depth));
	}

	@Test
	public void returnsNegativeOneInProgress() throws Exception {
		ai.max = new MaxPlayer("x", -5);
		ai.min = new MinPlayer("o", 5);
		Board board = new Board();
		int depth = 1;
		assertEquals(-1,ai.gameValue(board,depth));
	}

	@Test
	public void returnsZeroForDraw() throws Exception {
		ai.max = new MaxPlayer("x", -5);
		ai.min = new MinPlayer("o", 5);
		Board board = new Board();
		int depth = 7;
		board.grid[0] = "x";
		board.grid[1] = "x";
		board.grid[2] = "o";
		board.grid[3] = "o";
		board.grid[4] = "o";
		board.grid[5] = "x";
		board.grid[6] = "x";
		board.grid[7] = "o";
		board.grid[8] = "x";
		assertEquals(0, ai.gameValue(board,depth));
	}

	@Test
	public void returnsMoveBasedOnBoardAndPlayers() throws Exception {
		Board board = new Board();
		assertEquals("1", ai.getMove(board, "x", "o"));
	}

	@Test
	public void returnsWinningMove() throws Exception {
		Board board = new Board();
		board.grid[0] = "x";
		board.grid[4] = "x";
		assertEquals("9", ai.getMove(board, "x", "o"));
	}

	@Test
	public void blocksWinningMove() throws Exception {
		Board board = new Board();
		board.grid[0] = "o";
		board.grid[3] = "o";
		assertEquals("7", ai.getMove(board, "x", "o"));
	}

	@Test
	public void blocksKnightSetup() throws Exception {
		Board board = new Board();
		board.grid[0] = "o";
		board.grid[4] = "x";
		board.grid[7] = "o";
		ArrayList<String> safeMoves = new ArrayList<String>();
		safeMoves.add("6");
		safeMoves.add("7");
		safeMoves.add("9");
		assertEquals(true, safeMoves.contains(ai.getMove(board, "x", "o")));
	}

	@Test
	public void choosesCenterAfterCorner() throws Exception {
		Board board = new Board();
		board.grid[0] = "o";
		assertEquals("5", ai.getMove(board, "x", "o"));
	}
}
