package pathagon;

import framework.AdversarySearchProblem;

public class ProblemPathagon implements AdversarySearchProblem {

	public ProblemPathagon(){}

	public StatePathagon initialState(){
		int[][] newBoard = new int[7][7];
		for(int i=0; i<newBoard.length; i++){
			Arrays.fill(newBoard, 0);
		}
		StatePathagon init = new StatePathagon(false,14,14,1,newBoard);

		return init;
	}

	public int minValue(){

		return -10000;

	}

	public int maxValue(){

		return 10000;

	}

	public StatePathagon insertToken(StatePathagon state, int column, int row){

		int[][] auxBoard = new int[7][7];
		for (int i=0; i<auxBoard.length; i++){
			for (int j=0; j<auxBoard.length; j++){
				auxBoard[i][j] = state.board()[i][j];
			}
		}
		StatePathagon res = null;
		int currentTurn = state.turn();
		int turnTokens;
		if( currentTurn==1){
			turnTokens = state.tokensUser();
		}else{
			turnTokens = state.tokensCPU();
		}

		if (auxBoard[row][column]==0 && turnTokens>0){
			auxBoard[row][column] = currentTurn;
			if (currentTurn == 1){
				if(state.tokensCPU>0)
					res = new StatePathagon(!state.isMax(),turnTokens-1,state.tokensCPU,2,auxBoard);
				else
					res = new StatePathagon(state.isMax(),turnTokens-1, state.tokensCPU,1,auxBoard);
			}else{
				if(state.tokensUser>0)
					res = new StatePathagon(!state.isMax(),state.tokensUser,turnTokens-1,1,auxBoard);
				else
					res = new StatePathagon(state.isMax(),state.tokensUser,turnTokens-1,2,auxBoard);
			}
		}else{
			System.out.println("Casillero ocupado");
		}

		return res;

	}

}
