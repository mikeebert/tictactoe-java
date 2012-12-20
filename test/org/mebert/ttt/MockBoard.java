package org.mebert.ttt;

public class MockBoard extends Board {
	public String winner = "";
	public boolean draw = false;

	public String winner() {
		return winner;
	}

	public boolean draw() {
		return draw;
	}

}
