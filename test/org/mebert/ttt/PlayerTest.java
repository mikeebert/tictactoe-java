package org.mebert.ttt;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerTest {

	@Test
	public void itInitializesWithSymbolAndType() throws Exception {
		Player player = new Player("x","human");
		assertEquals("x",player.symbol);
		assertEquals("human",player.type);
	}
}
