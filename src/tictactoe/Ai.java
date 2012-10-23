package tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class Ai {
	public MaxPlayer max;
	public MinPlayer min;
	private int MAXSTARTINGSCORE = -5;
	private int MINSTARTINGSCORE = 5;

	public String getMove(Board board, String playerSymbol, String opponentSymbol) {
		String move = getMinimaxMove(board, playerSymbol, opponentSymbol);
		return move;
	}

	private String getMinimaxMove(Board board, String maxSymbol, String minSymbol) {
		setMinAndMax(maxSymbol, minSymbol);
		int bestMaxScore = max.startingScore;
		int depth = 0;
		Board newBoard = null;
		ArrayList<String> possibleMoves = new ArrayList<String>();

		for (String move : board.availableMoves()) {
			newBoard = board.copy();
			newBoard.makeMove(max.symbol, Integer.parseInt(move));
			int newScore = minimaxScore(newBoard, opponentOf(max), depth++);
			if (newScore > bestMaxScore) {
				bestMaxScore = newScore;
				possibleMoves.clear();
				possibleMoves.add(move);
			}
			else if (newScore == bestMaxScore) {
				possibleMoves.add(move);
			}
		}
		return chosenMove(possibleMoves);
	}

	private int minimaxScore(Board board, MinimaxPlayer player, int depth) {
		int score = gameValue(board,depth);
		if (score != -1)
			return score;

		int bestScore = player.startingScore;

		for (String move : board.availableMoves()) {
			Board newBoard = null;
			newBoard = board.copy();
			newBoard.makeMove(player.symbol, Integer.parseInt(move));
			int newScore = minimaxScore(newBoard, opponentOf(player), depth++);
			bestScore = player.compare(newScore,bestScore);
		}

		return bestScore;
	}

	public int gameValue(Board board, int depth) {
		if (board.winner() == max.symbol)
			return (100 - depth);
		else if (board.winner() == min.symbol) {
			return (-100 + depth);
		}
		else if (board.draw() == true) {
			return 0;
		}
		else
			return -1;
	}

	public String chosenMove(ArrayList<String> possibleMoves) {
		for (String move : possibleMoves)
			if (Integer.parseInt(move) % 2 != 0)
				return move;

		Random random = new Random();
		int randomIndex = random.nextInt(possibleMoves.size());
		return possibleMoves.get(randomIndex);
	}

	private MinimaxPlayer opponentOf(MinimaxPlayer player) {
		if (player == max)
			return min;
		return max;
	}

	public void setMinAndMax(String maxSymbol, String minSymbol) {
		max = new MaxPlayer(maxSymbol, MAXSTARTINGSCORE);
		min = new MinPlayer(minSymbol, MINSTARTINGSCORE);
	}

}

