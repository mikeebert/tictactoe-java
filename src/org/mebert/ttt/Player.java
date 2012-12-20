package org.mebert.ttt;

public class Player {
	public String symbol;
	public String type;

	public Player(String playerSymbol, String playerType) {
		symbol = playerSymbol;
		type = playerType;
	}

	public String getSymbol() {
		return symbol;
	}

}
