package tictactoe;

public class MockAi extends Player {
	public boolean receivedMoveRequest;
	public Board receivedBoard;
	public String receivedPlayerSymbol;
	public String receivedOpponentSymbol;

	public MockAi(String playerSymbol, String playerType) {
		super(playerSymbol, playerType);
	}

	public int getMove(Board board, String aiSymbol, String opponentSymbol) {
		receivedBoard = board;
		receivedPlayerSymbol = aiSymbol;
		receivedOpponentSymbol = opponentSymbol;
		return 0;
	}
}
