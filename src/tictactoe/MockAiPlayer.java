package tictactoe;

public class MockAiPlayer extends Player {
	public boolean receivedMoveRequest;
	public Board receivedBoard;
	public String receivedPlayerSymbol;
	public String receivedOpponentSymbol;

	public MockAiPlayer(String playerSymbol, String playerType) {
		super(playerSymbol, playerType);
	}

	public int getMove(Board board, String aiSymbol, String opponentSymbol) {
		receivedBoard = board;
		receivedPlayerSymbol = aiSymbol;
		receivedOpponentSymbol = opponentSymbol;
		return 0;
	}
}
