package tictactoe;

public class Ai {
	private MaxPlayer max;
	private MinPlayer min;

	public int getMove(Board board, String playerSymbol, String opponentSymbol) {
		int move = getMinimaxMove(board, playerSymbol, opponentSymbol);
		return move;
	}

	private int getMinimaxMove(Board board, String maxSymbol, String minSymbol) {
//		setMinAndMax
		return 1;
	}
}

class MaxPlayer {
	public String symbol;
	public int startingScore;

	public MaxPlayer(String playerSymbol, int score) {
		symbol = playerSymbol;
		startingScore = score;
	}


	public int compare(int bestScore, int newScore) {
		if (bestScore > newScore)
			return bestScore;
		return newScore;
	}
}

class MinPlayer {
	public String symbol;
	public int startingScore;

	public MinPlayer(String playerSymbol, int score) {
		symbol = playerSymbol;
		startingScore = score;
	}

	public int compare(int bestScore, int newScore) {
		if (bestScore < newScore)
			return bestScore;
		return newScore;
	}
}