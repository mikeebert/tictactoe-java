package tictactoe;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class AiPlayerTest {
	private AiPlayer ai = new AiPlayer("x","computer");

	@Test
	public void initializesCorrectly() throws Exception {
	assertEquals("x", ai.symbol);
	}
}
