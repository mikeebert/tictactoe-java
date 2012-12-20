package org.mebert.ttt;

public class Board {
	public String[] grid = {"1","2","3","4","5","6","7","8","9"};

	public String[] makeMove(String playerSymbol, int i) {
		grid[i-1] = playerSymbol;
		return grid;
	}

	public String[] availableMoves() {
		int spaces = 0;
		for (String space : grid)
		  if ("X" != space && "O" != space)
			  spaces++;
		String[] availableSpaces = new String[spaces];
		int spacesIndex = 0;
		for (int i = 0; i < 9; i++)
			if (grid[i] != "X" && grid[i] != "O") {
				availableSpaces[spacesIndex] = grid[i];
				spacesIndex++;
			}
		return availableSpaces;
	}

	public boolean isValidMove(int i) {
		boolean valid = false;
		if (grid[i-1] != "X" && grid[i-1] != "O") {
			valid = true;
		}
		return valid;
	}

	public String winner() {
		if (grid[0] == grid[1] && grid[0] == grid[2])
			return grid[0];
		if (grid[3] == grid[4] && grid[3] == grid[5])
			return grid[3];
		if (grid[6] == grid[7] && grid[6] == grid[8])
			return grid[6];
		if (grid[0] == grid[3] && grid[0] == grid[6])
			return grid[0];
		if (grid[2] == grid[5] && grid[2] == grid[8])
			return grid[2];
		if (grid[1] == grid[4] && grid[1] == grid[7])
			return grid[1];
		if (grid[0] == grid[4] && grid[0] == grid[8])
			return grid[0];
		if (grid[2] == grid[4] && grid[2] == grid[6])
			return grid[2];
		return null;
	}

	public boolean draw() {
		if (this.winner() == null && this.availableMoves().length == 0)
			return true;
		return false;
	}

	public Board copy() {
		Board newBoard = new Board();
		for (int i = 0; i < 9; i++)
			newBoard.grid[i] = this.grid[i];
		return newBoard;
	}
}
