package tictactoe;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

class MaxPlayerTest {
	@Test
	public void initializesWithSymbolAndStartingScore() throws Exception {
		MaxPlayer max = new MaxPlayer("x", -5);
		assertEquals("x", max.symbol);
	}

	@Test
	public void returnsHigherScore() throws Exception {
		MaxPlayer max = new MaxPlayer("x", -5);
		assertEquals(15,max.compare(-5, 15));
	}
}
