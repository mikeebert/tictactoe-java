package tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Game {
	public Board board;
	public Player firstPlayer;
	public Player secondPlayer;
	public Player nextPlayer;

	public Game(Board board, String firstSymbol, String firstType,
	                         String secondSymbol, String secondType) {
		this.board = board;
		firstPlayer = new Player(firstSymbol,firstType);
		secondPlayer = new Player(secondSymbol, secondType);
		nextPlayer = firstPlayer;
	}

	public String[] updateBoard(Player player, String space) {
		board.makeMove(player.symbol, Integer.parseInt(space));
		switchNextPlayer(player);
		return board.grid;
	}

	private void switchNextPlayer(Player player) {
		if (player.symbol == "x")
			nextPlayer = secondPlayer;
		else
			nextPlayer = firstPlayer;
	}

	public Player nextOpponent() {
		if (nextPlayer == firstPlayer)
			return secondPlayer;
		else
			return firstPlayer;
	}

	public boolean over() {
		if (board.winner() != "none" || board.draw() == true)
			return true;
		return false;
	}

	public boolean playerIsComputer(Player player) {
		if (player.type == "computer")
			return true;
		return false;
	}

//	public int getAiMove(Board board, String aiSymbol, String opponentSymbol) {
//		return nextPlayer.getMove(board, aiSymbol, opponentSymbol);
//	}

	public Integer getNextPlayerMove() {
		return nextPlayer.getMove(board, nextPlayer.symbol, nextOpponent().symbol);
	}
}
