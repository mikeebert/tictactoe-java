package tictactoe;

import java.util.ArrayList;
import java.util.*;

public class Board {
	public String[] grid = {"1","2","3","4","5","6","7","8","9"};

	public List<String> availableMoves() {
		List<String> availableMoves = new ArrayList<String>();
		for (int i = 0; i < 9; i++)
			if (grid[i] != "x" && grid[i] != "o")
				availableMoves.add(grid[i]);
		return availableMoves;
	}

	public String[] makeMove(String playerSymbol, int i) {
		grid[i-1] = playerSymbol;
		return grid;
	}

	public boolean isValidMove(int i) {
		boolean valid = false;
		if (grid[i-1] != "x" && grid[i-1] != "o") {
			valid = true;
		}
		return valid;
	}

	public boolean hasWinner() {
		if (grid[0] == grid[1] && grid[0] == grid[2])
			return true;
		if (grid[3] == grid[4] && grid[3] == grid[5])
			return true;
		if (grid[6] == grid[7] && grid[6] == grid[8])
			return true;
		if (grid[0] == grid[3] && grid[0] == grid[6])
			return true;
		if (grid[2] == grid[5] && grid[2] == grid[8])
			return true;
		if (grid[1] == grid[4] && grid[1] == grid[7])
			return true;
		if (grid[0] == grid[4] && grid[0] == grid[8])
			return true;
		if (grid[2] == grid[4] && grid[2] == grid[6])
			return true;
		return false;
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
		return "none";
	}

	public boolean draw() {
		if (!this.hasWinner() && this.availableMoves().size() == 0)
			return true;
		return false;
	}
}
