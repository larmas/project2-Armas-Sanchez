package pathagon;

import java.util.Arrays;

import framework.AdversarySearchState;

public class StatePathagon implements AdversarySearchState {
	private int tokensUser; // Player available tokens
	private int tokensCPU; //CPU available tokens
	private boolean max; //true==isMaxNode false==isMinNode
	private int turn; // turn== 1 is turn of player // turn==2 is turn of CPU
	private int[][] board; //Representations of the board

	public StatePathagon(boolean maxX, int tokensX, int tokensY, int turnX, int[][] boardX){

		max = maxX;
		tokensUser = tokensX;
		tokensCPU = tokensY;
		turn = turnX;
		board = boardX;

	}

	public boolean isMax(){

		return max;

	}

	public int turn(){

		return turn;

	}

	public int tokensUser(){

		return tokensUser;

	}

	public int tokensCPU(){

		return tokensUser;

	}

	public boolean equals(StatePathagon other){

		boolean res = true;
		if (this.max != other.max){ res = false;}
		if (this.turn != other.turn){ res = false;}
		if (this.tokensUser != other.tokensUser){ res = false;}
		if (this.tokensCPU != other.tokensCPU){ res = false;}
		for(int i=0; i<this.board.length; i++{
			if(!Arrays.equals(this.board[i]other.board[i])){ res = false;}
		}

		return res;

	}
}
