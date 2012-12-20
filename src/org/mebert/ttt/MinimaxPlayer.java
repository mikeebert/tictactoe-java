package org.mebert.ttt;

public class MinimaxPlayer {
	public String symbol;
	public int startingScore;

	public int compare(int bestScore, int newScore) {
		return -999;
	}
}

class MaxPlayer extends MinimaxPlayer{
	public MaxPlayer(String playerSymbol, int score) {
		super.symbol = playerSymbol;
		super.startingScore = score;
	}

	public int compare(int bestScore, int newScore) {
		if (bestScore > newScore)
			return bestScore;
		return newScore;
	}
}

class MinPlayer extends MinimaxPlayer{
	public MinPlayer(String playerSymbol, int score) {
		super.symbol = playerSymbol;
		super.startingScore = score;
	}

	public int compare(int bestScore, int newScore) {
		if (bestScore < newScore)
			return bestScore;
		return newScore;
	}
}