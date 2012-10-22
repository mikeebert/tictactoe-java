package tictactoe;

public class MockBoard extends Board {
	public String winner;
	public boolean draw;

	public String winner() {
		return winner;
	}

	public boolean draw() {
		return draw;
	}

}
