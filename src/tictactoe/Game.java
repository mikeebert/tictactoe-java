package tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Game {
	public Board board;
	public Player firstPlayer;
	public Player secondPlayer;
	public Player nextPlayer;
	public Ai ai;

	public Game(Board board, String firstSymbol, String firstType,
	                         String secondSymbol, String secondType) {
		this.board = board;
		firstPlayer = new Player(firstSymbol,firstType);
		secondPlayer = new Player(secondSymbol, secondType);
		nextPlayer = firstPlayer;
		ai = new Ai();
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

	public String getComputerMove() {
		return ai.getMove(board, nextPlayer.symbol, nextOpponent().symbol);
	}
}
