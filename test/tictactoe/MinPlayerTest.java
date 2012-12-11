package tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MinPlayerTest {
	@Test
	public void initializesWithSymbolAndStartingScore() throws Exception {
		MinPlayer min = new MinPlayer("x", -5);
		assertEquals("x", min.symbol);
	}

	@Test
	public void returnsLowerScore() throws Exception {
		MinPlayer min = new MinPlayer("x", -5);
		assertEquals(-10, min.compare(-5,-10));
	}
}
