package tictactoe;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class AiTest {
	@Test
	public void returnsMoveBasedOnBoardAndPlayers() throws Exception {
		Board board = new Board();
		Ai ai = new Ai();
		assertEquals(1, ai.getMove(board, "x", "o"));
	}


}
