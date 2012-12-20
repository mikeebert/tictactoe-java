package org.mebert.ttt;

import java.util.HashMap;

public class Game {
	public static final String X = "X";
	public static final String O = "O";
	public static final String human = "human";
	public static final String computer = "computer";
	public static final String NOWINNER = "none";

	private int id;

	public Board board;
	public Player firstPlayer;
	public Player secondPlayer;
	public Player nextPlayer;
	public Ai ai;

	public Game() {
		board = new Board();
		firstPlayer = new Player(X, human);
		secondPlayer = new Player(O, computer);
		nextPlayer = firstPlayer;
		ai = new Ai();
	}

	public Game(Board board, String firstSymbol, String firstType,
	                         String secondSymbol, String secondType) {
		this.board = board;
		firstPlayer = new Player(firstSymbol,firstType);
		secondPlayer = new Player(secondSymbol, secondType);
		nextPlayer = firstPlayer;
		ai = new Ai();
	}

	public String[] updateBoardWith(String move) {
		String[] newBoard = updateBoard(nextPlayer, move);
		if (playerIsComputer(nextPlayer) && !isOver())
			newBoard = updateBoard(nextPlayer, getComputerMove());
		return newBoard;
	}

	public String[] updateBoard(Player player, String space) {
		board.makeMove(player.symbol, Integer.parseInt(space));
		switchNextPlayer(player);
		return board.grid;
	}

	private void switchNextPlayer(Player player) {
		if (player.symbol.equals(firstPlayer.getSymbol()))
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

	public boolean isOver() {
		return board.winner() != null || board.draw();
	}

	public boolean playerIsComputer(Player player) {
		if (player.type.equals("computer"))
			return true;
		return false;
	}

	public String getComputerMove() {
		return ai.getMove(board, nextPlayer.symbol, nextOpponent().symbol);
	}

	public String getWinner() {
		return board.winner();
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

}
