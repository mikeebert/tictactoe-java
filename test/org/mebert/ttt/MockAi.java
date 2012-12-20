package org.mebert.ttt;

public class MockAi extends Ai {
	public boolean receivedMoveRequest;
	public Board receivedBoard = null;
	public String receivedPlayerSymbol = null;
	public String receivedOpponentSymbol = null;

	public String getMove(Board board, String aiSymbol, String opponentSymbol) {
		receivedBoard = board;
		receivedPlayerSymbol = aiSymbol;
		receivedOpponentSymbol = opponentSymbol;
		return "1";
	}
}
