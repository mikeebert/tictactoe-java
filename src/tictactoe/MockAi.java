package tictactoe;

public class MockAi extends Ai {
	public boolean receivedMoveRequest;
	public Board receivedBoard;
	public String receivedPlayerSymbol;
	public String receivedOpponentSymbol;

	public String getMove(Board board, String aiSymbol, String opponentSymbol) {
		receivedBoard = board;
		receivedPlayerSymbol = aiSymbol;
		receivedOpponentSymbol = opponentSymbol;
		return "1";
	}
}
