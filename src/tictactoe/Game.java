package tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Game {
	public Board board;
	public Map<String,String> firstPlayer = new HashMap<String, String>();
	public Map<String,String> secondPlayer = new HashMap<String, String>();

	public Game(Board board, String firstSymbol, String firstType,
	                         String secondSymbol, String secondType) {
		this.board = board;
		this.firstPlayer.put("symbol", firstSymbol);
		this.firstPlayer.put("type", firstType);
		this.secondPlayer.put("symbol", secondSymbol);
		this.secondPlayer.put("type", secondType);
	}

	public String playerSymbol(Map player) {
		return (String) player.get("symbol");
	}

	public String playerType(Map player) {
		return (String) player.get("type");
	}
}
